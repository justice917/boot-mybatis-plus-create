package com.boot.create.api.service.validation;

import com.boot.create.api.model.RespEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        StringBuilder errorInfo = new StringBuilder();
        BindingResult bindingResult = exception.getBindingResult();
        for(int i = 0; i < bindingResult.getFieldErrors().size(); i++){
            if(i > 0){
                errorInfo.append(",");
            }
            FieldError fieldError = bindingResult.getFieldErrors().get(i);
            errorInfo.append(fieldError.getField()).append(" :").append(fieldError.getDefaultMessage());
        }

        //返回BaseResponse
        RespEntity<String> response = new RespEntity<>();
        response.setMsg(errorInfo.toString());
        response.setCode("-1");
        return response;
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespEntity<String> handleConstraintViolationException(ConstraintViolationException exception) {
        StringBuilder errorInfo = new StringBuilder();
        String errorMessage ;

        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        for (ConstraintViolation<?> item : violations) {
            errorInfo.append(item.getMessage()).append(",");
        }
        errorMessage = errorInfo.toString().substring(0, errorInfo.toString().length()-1);

        RespEntity<String> response = new RespEntity<>();
        response.setMsg(errorMessage);
        response.setCode("-1");
        return response;
    }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespEntity<String> handleDefaultException(Exception exception) {

        RespEntity<String> response = new RespEntity<>();
        response.setMsg("其他错误");
        response.setCode("-1");
        return response;
    }

}
