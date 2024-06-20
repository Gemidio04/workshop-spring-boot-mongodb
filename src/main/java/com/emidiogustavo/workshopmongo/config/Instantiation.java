package com.emidiogustavo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.emidiogustavo.workshopmongo.domain.Post;
import com.emidiogustavo.workshopmongo.domain.User;
import com.emidiogustavo.workshopmongo.repository.PostRepository;
import com.emidiogustavo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
			; 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/93/2018"),"Partiu Viagem","Vou viajar para São Paulo. Abraços!",maria);
		Post post2 = new Post(null, sdf.parse("21/93/2018"),"Partiu Viagem","Vou viajar para São Paulo. Abraços!",maria);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
