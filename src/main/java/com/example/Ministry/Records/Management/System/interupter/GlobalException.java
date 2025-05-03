package com.example.Ministry.Records.Management.System.interupter;

import com.example.Ministry.Records.Management.System.exception.MinistryRecordsManagementSystemApplicationException;
import com.example.Ministry.Records.Management.System.vo.ResponseVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(MinistryRecordsManagementSystemApplicationException.class)
    public ResponseEntity<ResponseVO <Object> >handler(MinistryRecordsManagementSystemApplicationException exception)
    {
        ResponseVO responseVO=new ResponseVO<>();
        responseVO.setError(exception.getMessage());
        responseVO.setStatus(exception.getStatus().value());
        return new ResponseEntity<>(responseVO,exception.getStatus());
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ResponseVO<Object>> handles(
            HttpServletRequest request, MissingServletRequestParameterException exception) {
        StringBuilder validationErrors = new StringBuilder();
        validationErrors.append(exception.getParameterName()).append(exception.getMessage());
        String error = String.valueOf(validationErrors);
        ResponseVO<Object> response = new ResponseVO<>();
        response.setMessage(error);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseVO<Object>> handles(
            HttpServletRequest request, DataIntegrityViolationException exception) {
        StringBuilder validationErrors = new StringBuilder();
        validationErrors.append(exception.getMessage());
        String error = String.valueOf(validationErrors);
        ResponseVO<Object> response = new ResponseVO<>();
        response.setMessage(error);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
