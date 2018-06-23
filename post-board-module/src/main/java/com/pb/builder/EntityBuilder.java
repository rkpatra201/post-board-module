package com.pb.builder;

import java.util.Date;

import org.springframework.security.core.context.SecurityContextHolder;

import com.pb.model.Post;
import com.pb.model.PostReply;

public class EntityBuilder {

	public static Post createPost(String postContent) {
		Post post = new Post();
		post.setPostContent(postContent);
		post.setPostOwner(getLoggedInUser());
		post.setPostCreatedAt(new Date());
		post.setActive(true);
		return post;
	}

	
	public static PostReply createPostReply(Integer postId, String replyContent) {
		Post post = new Post();
		post.setPostId(postId);

		PostReply postReply = new PostReply();
		postReply.setPost(post);
		postReply.setActive(true);
		postReply.setReplyOwner(getLoggedInUser());
		postReply.setRepliedAt(new Date());
		postReply.setReplyContent(replyContent);
		return postReply;
	}

	public static String getLoggedInUser() {
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			return "SYSTEM";
		}
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
