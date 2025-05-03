package com.example.Ministry.Records.Management.System.repositery;

import com.example.Ministry.Records.Management.System.modal.Department;
import com.example.Ministry.Records.Management.System.modal.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.UUID;

public interface DocumentRepositery extends JpaRepository<Document, UUID> {

//    @Query("select d from Document d where d.title=:title")
//    Page<Document> getDocumentPage(@Param("title") String title, Pageable pageable);

    @Query("select d from Document d ")
    Page<Document> getDocumentPage(org.springframework.data.domain.Pageable pageable);

}
