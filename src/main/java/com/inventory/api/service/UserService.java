package com.inventory.api.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.inventory.api.dto.UserDTO;

public interface UserService {

	public UserDetails loadUserByUsername(String username);

}
