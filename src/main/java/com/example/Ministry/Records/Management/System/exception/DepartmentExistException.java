package com.example.Ministry.Records.Management.System.exception;

import com.example.Ministry.Records.Management.System.Utility.Constents;
import org.springframework.http.HttpStatus;

public class DepartmentExistException extends MinistryRecordsManagementSystemApplicationException{

    public DepartmentExistException(String name)
    {
        super("This deppartmentCode already exist pls try another departmentCode :"+name, Constents.DOCUMENT_EXISTEXCEPTION, HttpStatus.CONFLICT);
    }
}
