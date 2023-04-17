package com.app.subscription.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class ErrorMessage {
	@NotNull
	private String message;
	@NotNull
	private Date timestamp;
}
