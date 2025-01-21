package com.app.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.app.dtos.Message;
import com.app.exceptions.CategoryNotFound;
import com.app.exceptions.ProductNotFound;

@RestControllerAdvice
public class ExceptionsHandler {
	
	@Autowired
	Message message;
	
	@ExceptionHandler
	public ResponseEntity<Message> categoryNotFound(CategoryNotFound categoryNotFound)
	{
		String msg = categoryNotFound.getMessage();
		Message message1 = message.getMessage(msg);
		return new ResponseEntity<Message>(message1,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<Message> productNotFound(ProductNotFound productNotFound)
	{
		String msg = productNotFound.getMessage();
		Message message1 = message.getMessage(msg);
		return new ResponseEntity<Message>(message1,HttpStatus.NOT_FOUND);
	}

}
