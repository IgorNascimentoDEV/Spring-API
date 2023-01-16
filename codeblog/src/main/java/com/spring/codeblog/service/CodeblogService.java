package com.spring.codeblog.service;

import java.util.List;

import com.spring.codeblog.model.Post;

public interface CodeblogService {

	public List<Post> findAll();
	
	public Post findById(long id);
	
	public Post save(Post post);

}
