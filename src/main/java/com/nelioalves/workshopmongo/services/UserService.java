package com.nelioalves.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id){
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insertUser(User obj){
		return repo.insert(obj);
	}

	public void deleteUser(String id){
		findById(id);
		repo.deleteById(id);
	}

	public User fromDTO(UserDTO obJDto){
		return new User(obJDto.getId(), obJDto.getName(), obJDto.getEmail());
	}
}
