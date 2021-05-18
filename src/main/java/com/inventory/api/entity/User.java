package com.inventory.api.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

	@Id
	@Column(name = "user_id", length = 64)
	private String userId;
	private String name;
	private String mobile;
	private String username;
	private String password;
	private String role;
	private String status;
	Timestamp createdAt;
	Timestamp updatedAt;

}
