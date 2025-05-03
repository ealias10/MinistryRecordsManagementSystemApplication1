package com.example.Ministry.Records.Management.System.service;

import com.example.Ministry.Records.Management.System.dao.DocumentDao;
import com.example.Ministry.Records.Management.System.mapper.DepartmentMapper;
import com.example.Ministry.Records.Management.System.mapper.DocumentMapper;
import com.example.Ministry.Records.Management.System.modal.Department;
import com.example.Ministry.Records.Management.System.modal.Document;
import com.example.Ministry.Records.Management.System.vo.DepartmentVO;
import com.example.Ministry.Records.Management.System.vo.DocumentVO;
import com.example.Ministry.Records.Management.System.vo.PaginatedRepositeryVOAndCount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
@Slf4j
public class DocumentService {

    @Autowired
    private DocumentDao documentDao;


    public PaginatedRepositeryVOAndCount<DocumentVO>  listDevices(Integer offset, Integer limit, String filter) {
        try {
            org.springframework.data.domain.Pageable pageable = PageRequest.of(offset - 1, limit);
            Page<Document> devicesList;
            if (filter == null || filter.trim() == "")
                devicesList= documentDao.getDocumentPage(pageable,filter);
            else
                devicesList= documentDao.getDocumentPage(pageable,filter);
            log.info("Retrieved register list successfully");
            var allDevicesListVO = DocumentMapper.getAllDepartmentListVO(devicesList.toList());
            return new PaginatedRepositeryVOAndCount<>(
                    devicesList.getTotalElements(), allDevicesListVO);
        } catch (Exception e) {
            log.error("Error while Retrieved register list");
            throw e;
        }
    }

}
