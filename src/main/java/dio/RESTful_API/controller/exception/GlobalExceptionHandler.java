package dio.RESTful_API.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleBusinessExecption(IllegalArgumentException businessExecption) {		
		return new ResponseEntity<>(businessExecption.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> noSucElementException(NoSuchElementException noSucElementException) {		
		return new ResponseEntity<>("Resource ID not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> noUn(Throwable unexpectedException) {		
		var message = "Unexpected server error";
		logger.error(message, unexpectedException);
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

}
