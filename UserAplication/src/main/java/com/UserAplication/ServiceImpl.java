package com.UserAplication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

	@Autowired
	private Repo repo;

	@Override
	public UserDetails saveUser(UserDetails user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public List<UserDetails> getAllUserData() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<UserDetails> getUserById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	
	
	

}
