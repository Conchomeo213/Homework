package vn.tmt.homework.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

}
