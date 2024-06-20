package com.emidiogustavo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

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
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User user) {
		Optional<User> optionalNewUser = repo.findById(user.getId());
	    User newUser = optionalNewUser.
	    orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
		updateData(newUser, user); 
		return repo.save(newUser); 
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail()); 
	}
	
}
