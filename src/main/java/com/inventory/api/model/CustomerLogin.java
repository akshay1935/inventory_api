package com.inventory.api.model;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerLogin {

	@NotEmpty(message = "Mobile is mandatory")
	private String mobile;
	@NotEmpty(message = "OTP is mandatory")
	private String otp;

}
