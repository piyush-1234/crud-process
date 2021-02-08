package com.UserAplication;

import java.util.List;
import java.util.Optional;

public interface Service {

	UserDetails saveUser(UserDetails user);
	List<UserDetails> getAllUserData();
	Optional<UserDetails> getUserById(Long id);
	void deleteUserById(Long id);
}
