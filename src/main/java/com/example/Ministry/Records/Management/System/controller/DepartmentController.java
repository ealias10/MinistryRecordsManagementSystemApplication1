package com.example.Ministry.Records.Management.System.controller;


import com.example.Ministry.Records.Management.System.exception.DepartmentExistException;
import com.example.Ministry.Records.Management.System.request.DepartmentRequest;
import com.example.Ministry.Records.Management.System.service.DepartmentService;
import com.example.Ministry.Records.Management.System.vo.DepartmentVO;
import com.example.Ministry.Records.Management.System.vo.PaginatedRepositeryVOAndCount;
import com.example.Ministry.Records.Management.System.vo.ResponseVO;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<ResponseVO<Object>> createDepartment(@RequestBody(required = true) DepartmentRequest request) throws DepartmentExistException {
        ResponseVO responseVO = new ResponseVO<>();
        DepartmentVO departmentVO = departmentService.saveDepartmentVO(request);
        responseVO.addData(departmentVO);
        return new ResponseEntity<>(responseVO, HttpStatus.OK);

    }

//    @GetMapping("/search")
//    public ResponseEntity<ResponseVO<DepartmentVO>> list(
//            @RequestParam(value = "offset", required = false, defaultValue = "1") Integer offset,
//            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
//            @RequestParam(value = "title", required = false) String title) {
//        ResponseVO<DepartmentVO> response = new ResponseVO<>();
//        PaginatedRepositeryVOAndCount<DepartmentVO> paginatedResponseVOAndCount = departmentService.listDevices(offset, limit, title);
//        response.paginationDataList(paginatedResponseVOAndCount.getData(), paginatedResponseVOAndCount.getTotalCount());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
}




