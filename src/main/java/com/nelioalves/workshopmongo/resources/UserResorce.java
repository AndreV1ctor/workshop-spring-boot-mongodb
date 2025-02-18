package com.nelioalves.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.workshopmongo.domain.User;


@RestController
@RequestMapping(value="/users")
public class UserResorce {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User rogerinha = new User("1", "Rogerinha da lapa", "rogeria@gmail.com");
		User rochelle = new User("2", "Rochelle Rocha", "rochelle@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(rogerinha, rochelle));
		return ResponseEntity.ok().body(list);
	}

}
