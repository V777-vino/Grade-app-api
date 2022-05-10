package com.Gradeapp.Gradeappapi.message;

import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Configuration
public class Message {
	
	
	private String Message =null;
	
	public Message(String message) {
		this.Message = message;
	}

}
