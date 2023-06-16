package com.event.feedbackservice.exception;

import java.util.HashMap;
import java.util.Map;

import com.event.feedbackservice.Response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalController {

@ExceptionHandler(resourceException.class)
public ResponseEntity<?> globalExcpectionHandler(resourceException ex){

	return new ResponseEntity<ApiResponse>(new ApiResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage(),"not found"),HttpStatus.NOT_FOUND);
	
}
@ExceptionHandler(MethodArgumentNotValidException.class)	
public ResponseEntity<Map<String,String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
	Map<String,String> resp = new HashMap<>();
	ex.getBindingResult().getAllErrors().forEach((error)->{
		String field = ((FieldError)error).getField();
		String message= error.getDefaultMessage();
		resp.put(field, message);
	}
			);
	return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
	
}


}
