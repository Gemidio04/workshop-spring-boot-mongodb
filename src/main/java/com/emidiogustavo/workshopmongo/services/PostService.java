package com.emidiogustavo.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emidiogustavo.workshopmongo.domain.Post;
import com.emidiogustavo.workshopmongo.repository.PostRepository;
import com.emidiogustavo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo; 
	
	public Post findById(String id) {
		return repo.findById(id).orElseThrow(() -> 
        new ObjectNotFoundException("Post não encontrado"));
	}
	

}
