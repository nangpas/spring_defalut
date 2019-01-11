package spring_default.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import spring_default.common.dao.AbstractDAO;

@ControllerAdvice
public class AnnotationExceptionHandler {
	protected static final Logger logger = LoggerFactory.getLogger(AnnotationExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public void handleException(Exception e, WebRequest request) {
		logger.debug("에러 발생!!");
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public void handleRuntimeException(RuntimeException e, WebRequest request) {
		logger.debug("RuntimeException 발생!!");
		e.printStackTrace();
	}
	
}
