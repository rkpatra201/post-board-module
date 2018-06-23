package com.pb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.builder.EntityBuilder;
import com.pb.dao.PostDao;
import com.pb.dao.PostReplyDao;
import com.pb.exceptions.RecordNotFoundException;
import com.pb.model.Post;
import com.pb.model.PostReply;

@Transactional
@Service
public class PostServiceImpl implements IPostService {

	private static Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);
	@Autowired
	PostDao postDao;

	@Autowired
	PostReplyDao postReplyDao;

	@Override
	public Post create(Post post) {
		postDao.saveAndFlush(post);
		Post createdPost = postDao.findOne(post.getPostId());
		LOGGER.info(createdPost.getPostCreatedAt() + "-------------------");
		return createdPost;
	}

	@Override
	public Post activateOrDeactivatePost(Integer postId) {
		Post postFromDb = postDao.findOne(postId);
		if (postFromDb == null)
			throw new RecordNotFoundException("post not exists");

		postFromDb.setActive(!postFromDb.isActive());
		postDao.saveAndFlush(postFromDb);
		return postDao.findOne(postId);
	}

	@Override
	public PostReply create(PostReply postReply) {

		Post post = postReply.getPost();
		Post postFromDb = postDao.findOne(post.getPostId());
		if (postFromDb == null)
			throw new RecordNotFoundException("post not exists");
		else
			postReplyDao.saveAndFlush(postReply);
		
		return postReplyDao.findOne(postReply.getReplyId());
	}

	@Override
	public List<Post> findPostsByUserName(String postOwner) {
		return postDao.findByPostOwner(postOwner);
	}

	@Override
	public List<Post> findPostsOfCurrentUser() {
		String currentUser=EntityBuilder.getLoggedInUser();
		return postDao.findByPostOwner(currentUser);
	}

	@Override
	public List<Post> findActivePosts(boolean isActive) {
		return postDao.findActivePosts(isActive);
	}
	
	
	
	
	

}
