package com.inventory.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.inventory.api.entity.User;



public interface UserRepository extends CrudRepository<User, String> {
	Optional<User> findByUsername(String username);

	public Iterable<User> findAllByRole(String role);

	public long countByRole(String role);
}
