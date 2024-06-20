package com.emidiogustavo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emidiogustavo.workshopmongo.DTO.UserDTO;
import com.emidiogustavo.workshopmongo.domain.User;
import com.emidiogustavo.workshopmongo.repository.UserRepository;
import com.emidiogustavo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo; 
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		return repo.findById(id).orElseThrow(() -> 
        new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return repo.insert(user); 
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail()); 
	}
	
	
}
