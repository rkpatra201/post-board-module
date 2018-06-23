package com.pb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.builder.EntityBuilder;
import com.pb.model.Post;
import com.pb.model.PostReply;
import com.pb.response.ResponseSender;
import com.pb.service.IPostService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	IPostService postService;

	@Autowired
	ResponseSender responseSender;

	@PostMapping("/newpost")
	public ResponseEntity<Object> create(@RequestBody String postContent) {
		Post post = EntityBuilder.createPost(postContent);

		Post createdPost = postService.create(post);
		Post[] posts = new Post[] { createdPost };

		return responseSender.sendResponse(posts);

	}

	@PostMapping("/reply/{postId}")
	public ResponseEntity<Object> create(@PathVariable("postId") Integer postId, @RequestBody String replyContent) {
		PostReply postReply = EntityBuilder.createPostReply(postId, replyContent);

		PostReply postReplyCreated = postService.create(postReply);
		PostReply[] postReplies = new PostReply[] { postReplyCreated };

		return responseSender.sendResponse(postReplies);

	}

	@GetMapping("/active")
	public ResponseEntity<Object> getActivePosts() {
		List<Post> activePosts = postService.findActivePosts(true);
		Post[] posts = activePosts.toArray(new Post[activePosts.size()]);
		return responseSender.sendResponse(posts);
	}

	@GetMapping("/timeline")
	public ResponseEntity<Object> getMyPosts() throws JsonProcessingException {
		List<Post> currentUserPosts = postService.findPostsOfCurrentUser();
		Post[] posts = currentUserPosts.toArray(new Post[currentUserPosts.size()]);
		return responseSender.sendResponse(posts);
	}

	@DeleteMapping("/{postId}")
	public ResponseEntity<Object> deletePost(@PathVariable("postId") Integer postId) {
		Post updatePost = postService.activateOrDeactivatePost(postId);
		Post[] posts = new Post[] { updatePost };

		return responseSender.sendResponse(posts);
	}

}
