package com.pb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pb.model.Post;

public interface PostDao extends JpaRepository<Post, Integer> {

	public List<Post> findByPostOwner(String postOwner);

	@Query(value = "select e from #{#entityName} e where e.isActive=?1")
	List<Post> findActivePosts(boolean isActive);
}
