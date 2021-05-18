package com.inventory.api.dto;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.dozer.DozerBeanMapper;

import com.inventory.api.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	private String userId;
	private String name;
	private String mobile;
	@Email
	private String email;
	@NotEmpty(message = "Password is mandatory")
	private String password;
	@NotEmpty(message = "Role is mandatory")
	private String role;
	private String status;
	Timestamp createdAt;
	Timestamp updatedAt;

	// Converts Entity into DTO
	public static UserDTO valueOf(User user) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		return mapper.map(user, UserDTO.class);

	}

	// Converts DTO into Entity
	public User createEntity() {
		DozerBeanMapper mapper = new DozerBeanMapper();
		return mapper.map(this, User.class);
	}
}
