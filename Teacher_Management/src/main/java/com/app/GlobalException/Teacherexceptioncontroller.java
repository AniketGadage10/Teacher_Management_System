package com.app.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.dto.responsedto;
import com.app.exception.Teacherexception;

@RestControllerAdvice
public class Teacherexceptioncontroller {

	@ExceptionHandler(Teacherexception.class)
	public ResponseEntity<?> handleteacherexception(Teacherexception t) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)

				.body(new responsedto(t.getMessage()));
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> httpmessagenotreadableexception(HttpMessageNotReadableException h)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responsedto(h.getMessage()));
	}

}
