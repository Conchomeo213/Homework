package vn.tmt.homework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class handlerException {
    @ExceptionHandler(value = InvalidSizeException.class)
    public Object handle(InvalidSizeException ex) {
        // 1.a
        Date date = new Date();
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setCode("04105");
//        errorResponse.setMessage("Category name độ dài phải lớn hơn 5");
//        errorResponse.setTimeStamp(date);
//        String message = ex.getMessage();
//
//        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

        // 1.b

        Map<String, Object> err = new HashMap<>();
        err.put("code", "04105");
        err.put("message", ex.getMessage());
        err.put("timeStamp", date);
        return err;
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> baRequest(Exception ex) {
        Map<String, Object> err = new HashMap<>();
        err.put("code", "002");
        err.put("message", ex.getMessage());
        return err;
    }

    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, Object> conflict(Exception ex) {
        Map<String, Object> err = new HashMap<>();
        err.put("code", "003");
        err.put("message", ex.getMessage());
        return err;
    }
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Map<String, Object> methodNotSupport(Exception ex) {
        Map<String, Object> err = new HashMap<>();
        err.put("code", "001");
        err.put("message", ex.getMessage());
        err.put("time", new Date());
        return err;
    }
    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,Object> notFoundException(Exception ex){
        Map<String, Object> err = new HashMap<>();
        err.put("code", "004");
        err.put("message", ex.getMessage());
        err.put("time", new Date());
        return err;
    }
}
