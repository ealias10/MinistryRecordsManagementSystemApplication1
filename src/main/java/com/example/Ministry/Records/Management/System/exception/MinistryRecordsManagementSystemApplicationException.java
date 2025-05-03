package com.example.Ministry.Records.Management.System.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class MinistryRecordsManagementSystemApplicationException extends Exception{

    private String errorCode;
    public HttpStatus status;

    public MinistryRecordsManagementSystemApplicationException(String message,String errorCode,HttpStatus status)
    {
        super(message);
        this.errorCode=errorCode;
        this.status=status;
    }
}
