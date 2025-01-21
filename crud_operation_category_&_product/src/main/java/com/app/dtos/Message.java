package com.app.dtos;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Message {

	private String message;
	private Date date;

	public Message getMessage(String message) {
		Date date = new Date();
		Message message2 = new Message(message, date);
		return message2;
	}

}
