package com.meetpaija.toDo.exceptionHandling;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
//
//   @Override
//   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//       String error = "Malformed JSON request";
//       return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
//   }
//
//   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
//       return new ResponseEntity<>(apiError, apiError.getStatus());
//   }
//
//   //other exception handlers below
//   @ExceptionHandler(EntityNotFoundException.class)
//   protected ResponseEntity<Object> handleEntityNotFound(
//           EntityNotFoundException ex) {
//       ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
//       apiError.setMessage(ex.getMessage());
//       return buildResponseEntity(apiError);
//   }
//  
//   
//   @Override
//   protected ResponseEntity<Object> handleMethodArgumentNotValid(
//     MethodArgumentNotValidException ex, 
//     HttpHeaders headers, 
//     HttpStatus status, 
//     WebRequest request) {
//       List<String> errors = new ArrayList<String>();
//       for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//           errors.add(error.getField() + ": " + error.getDefaultMessage());
//       }
//       for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
//           errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
//       }
//        
//       ApiError apiError = 
//         new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
//       return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
//   }
//   
	
	
   @ExceptionHandler( Exception.class )
   public ResponseEntity<ApiError> handleAll(Exception ex, WebRequest request) {
       ApiError apiError = new ApiError();
       apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
       apiError.setMessage(ex.getMessage());
       apiError.setDebugMessage("error arise");
       return new ResponseEntity<ApiError>(apiError, new HttpHeaders(), apiError.getStatus());
   }
   
//   @ResponseStatus(HttpStatus.NOT_FOUND)
//   public void handle() {
//	   System.out.println("hii");
//   }
//   
//   
//   @ExceptionHandler(Throwable.class)
//   @ResponseBody
//   ResponseEntity<Object> handleControllerException(HttpServletRequest req, Throwable ex) {
//       ApiError errorResponse = new ApiError(HttpStatus.BAD_REQUEST,"hii",ex);
//           return new ResponseEntity<Object>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
//       
//   }
}