package com.example.Ministry.Records.Management.System.controller;

import com.example.Ministry.Records.Management.System.service.DocumentService;
import com.example.Ministry.Records.Management.System.vo.DepartmentVO;
import com.example.Ministry.Records.Management.System.vo.DocumentVO;
import com.example.Ministry.Records.Management.System.vo.PaginatedRepositeryVOAndCount;
import com.example.Ministry.Records.Management.System.vo.ResponseVO;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;
    @GetMapping("/search")
    public ResponseEntity<ResponseVO<DocumentVO>> list(
            @RequestParam(value = "offset", required = false, defaultValue = "1") Integer offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
            @RequestParam(value = "title", required = false) String title) {
        ResponseVO<DocumentVO> response = new ResponseVO<>();
        PaginatedRepositeryVOAndCount<DocumentVO> paginatedResponseVOAndCount = documentService.listDevices(offset, limit, title);
        response.paginationDataList(paginatedResponseVOAndCount.getData(), paginatedResponseVOAndCount.getTotalCount());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}


