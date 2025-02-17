package com.qatelo.backend.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChangePasswordDTO {
	@NotBlank(message = "Old password cannot be blank")
	private String oldPassword;

	@NotBlank(message = "New password cannot be blank")
	private String newPassword;
}
