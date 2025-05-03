package com.example.Ministry.Records.Management.System.repositery;

import com.example.Ministry.Records.Management.System.modal.Department;
import com.example.Ministry.Records.Management.System.modal.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.UUID;

public interface DepartmentRepositery extends JpaRepository<Department, UUID> {
//    @Query("select d from Department ")
//    Page<Department> getDepartmentPage(Pageable pageable);

    @Query("select d from Department d where d.departmentCode=:code")
    Department getDocumentByDepartmentCode(@Param("code")String code);
}
