package com.pb.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "post")
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	private String postContent;
	private boolean isActive;
	private String postOwner;
	private Date postCreatedAt;
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
	@JsonManagedReference
	List<PostReply> postReplies;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPostOwner() {
		return postOwner;
	}

	public void setPostOwner(String postOwner) {
		this.postOwner = postOwner;
	}

	public Date getPostCreatedAt() {
		return postCreatedAt;
	}

	public void setPostCreatedAt(Date postCreatedAt) {
		this.postCreatedAt = postCreatedAt;
	}

	public List<PostReply> getPostReplies() {
		return postReplies;
	}

	public void setPostReplies(List<PostReply> postReplies) {
		this.postReplies = postReplies;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

}
