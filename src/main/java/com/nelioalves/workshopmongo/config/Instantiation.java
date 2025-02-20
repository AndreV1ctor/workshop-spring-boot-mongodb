package com.nelioalves.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.dto.AuthorDTO;
import com.nelioalves.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... arg0) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User alexander = new User(null, "Alexander Corvinus", "alexanderCV@gmail.com");
		User victorino = new User(null, "Victorino Juncelino", "victorJunc@gmail.com");
		User danielson = new User(null, "Danielson Jr.", "danielsanjr@gmail.com");

		userRepository.save(alexander);
		userRepository.save(victorino);
		userRepository.save(danielson);

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(danielson));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(danielson));

		postRepository.save(post1);
		postRepository.save(post2);

		danielson.getPosts().addAll(Arrays.asList(post1));
		danielson.getPosts().addAll(Arrays.asList(post2));
		userRepository.save(danielson);
	}

}
