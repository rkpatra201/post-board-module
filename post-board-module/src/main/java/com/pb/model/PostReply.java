package com.pb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "post_reply")
@Table(name = "post_reply")
public class PostReply {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer replyId;
	private String replyContent;
	private boolean isActive;
	private String replyOwner;
	private Date repliedAt;

	@ManyToOne
	@JoinColumn(name = "postIdRef")
	@JsonBackReference
	private Post post;

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getReplyOwner() {
		return replyOwner;
	}

	public void setReplyOwner(String replyOwner) {
		this.replyOwner = replyOwner;
	}

	public Date getRepliedAt() {
		return repliedAt;
	}

	public void setRepliedAt(Date repliedAt) {
		this.repliedAt = repliedAt;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public PostReply() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
