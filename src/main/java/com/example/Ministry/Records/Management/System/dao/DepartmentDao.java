package com.example.Ministry.Records.Management.System.dao;

import com.example.Ministry.Records.Management.System.modal.Department;
import com.example.Ministry.Records.Management.System.repositery.DepartmentRepositery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public class DepartmentDao {

    @Autowired
    private DepartmentRepositery departmentRepositery;

    public Department saveDepartment(Department department)
    {
        return departmentRepositery.save(department);
    }

//    public Page<Department> getDepartmentPage(Pageable pageable,String title)
//    {
//        return departmentRepositery.getDepartmentPage(pageable);
//    }
    public Department getDepartmentByDepartmentCode(String code)
    {
        return departmentRepositery.getDocumentByDepartmentCode(code);
    }

}
