package com.pb.service;

import java.util.List;

import com.pb.model.Post;
import com.pb.model.PostReply;

public interface IPostService {

	public Post create(Post post);

	public PostReply create(PostReply postReply);

	public List<Post> findPostsByUserName(String postOwner);

	public List<Post> findPostsOfCurrentUser();

	public List<Post> findActivePosts(boolean isActive);

	public Post activateOrDeactivatePost(Integer postId);

}
