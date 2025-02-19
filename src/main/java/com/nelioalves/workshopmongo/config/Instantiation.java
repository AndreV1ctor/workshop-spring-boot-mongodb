package com.nelioalves.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... arg0) throws Exception {
		
		userRepository.deleteAll();
		
		User alexander = new User(null, "Alexander Corvinus", "alexanderCV@gmail.com");
		User victorino = new User(null, "Victorino Juncelino", "victorJunc@gmail.com");
		User danielson = new User(null, "Danielson Jr.", "danielsanjr@gmail.com");
		
		userRepository.save(alexander);
		userRepository.save(victorino);
		userRepository.save(danielson);
	}

}
