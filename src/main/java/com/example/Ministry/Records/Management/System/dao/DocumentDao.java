package com.example.Ministry.Records.Management.System.dao;

import com.example.Ministry.Records.Management.System.modal.Department;
import com.example.Ministry.Records.Management.System.modal.Document;
import com.example.Ministry.Records.Management.System.repositery.DocumentRepositery;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public class DocumentDao {

    @Autowired
    private DocumentRepositery documentRepositery;

//    public Page<Document> getDocumentPage(Pageable pageable, String title)
//    {
//        return documentRepositery.getDocumentPage(pageable);
//    }

    public Page<Document> getDocumentPage(org.springframework.data.domain.Pageable pageable,String a)
    {
        return documentRepositery.getDocumentPage(pageable);
    }
}
