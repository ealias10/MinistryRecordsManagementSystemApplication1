package com.example.Ministry.Records.Management.System.service;

import com.example.Ministry.Records.Management.System.dao.DepartmentDao;
import com.example.Ministry.Records.Management.System.exception.DepartmentExistException;
import com.example.Ministry.Records.Management.System.mapper.DepartmentMapper;
import com.example.Ministry.Records.Management.System.modal.Department;
import com.example.Ministry.Records.Management.System.request.DepartmentRequest;
import com.example.Ministry.Records.Management.System.vo.DepartmentVO;
import com.example.Ministry.Records.Management.System.vo.PaginatedRepositeryVOAndCount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;


    public DepartmentVO saveDepartmentVO(DepartmentRequest request) throws DepartmentExistException {
        try
        {
            Department existDepartment=departmentDao.getDepartmentByDepartmentCode(request.getDepartmentCode());
            if(existDepartment!=null)
            {
                throw new DepartmentExistException(request.getDepartmentCode());
            }
            Department department= DepartmentMapper.getDepartment(request);
            Department saveDepartment=departmentDao.saveDepartment(department);
            log.info("Create Department successfully, Request: {}", request);
            return DepartmentMapper.getDepartementVO(saveDepartment);
        }
        catch (Exception e)
        {
            log.error("Error while creating Department,  Request: {}", request);
            throw e;
        }
    }
//    public PaginatedRepositeryVOAndCount<DepartmentVO> listDevices(Integer offset, Integer limit, String title) {
//        try {
//            Pageable pageable = (Pageable) PageRequest.of(offset - 1, limit);
//            Page<Department> departmentPage=departmentDao.getDepartmentPage(pageable,title);
//            log.info("Retrieved Department  list successfully");
//            var allDevicesListVO = DepartmentMapper.getAllDepartmentListVO(departmentPage.toList());
//            return new PaginatedRepositeryVOAndCount<>(
//                    departmentPage.getTotalElements(), allDevicesListVO);
//        } catch (Exception e) {
//            log.error("Error while Retrieved Department list");
//            throw e;
//        }
//    }






}
