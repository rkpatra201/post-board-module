package com.pb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pb.model.PostReply;

public interface PostReplyDao extends JpaRepository<PostReply, Integer> {

	@Query(value = "select e from #{#entityName} e where e.post.postId=?1")
	List<PostReply> findRepliesByPostId(Integer postIdRef);
}
