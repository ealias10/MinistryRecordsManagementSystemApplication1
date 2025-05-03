package com.example.Ministry.Records.Management.System.mapper;

import com.example.Ministry.Records.Management.System.modal.Department;
import com.example.Ministry.Records.Management.System.request.DepartmentRequest;
import com.example.Ministry.Records.Management.System.vo.DepartmentVO;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentMapper {

    public static Department getDepartment(DepartmentRequest request)
    {
        return Department.builder().activeStatus(true).departmentName(request.getDepartmentName()).description(request.getDescription()).departmentCode(request.getDepartmentCode()).build();
    }
    public static DepartmentVO getDepartementVO(Department department)
    {
        return DepartmentVO.builder().description(department.getDescription()).departmentCode(department.getDepartmentCode()).id(department.getId()).departmentName(department.getDepartmentName()).activeStatus(department.getActiveStatus()).build();
    }
    public static List<DepartmentVO> getAllDepartmentListVO(List<Department> list)
    {
        return list.stream()
                .map(
                        departmen ->
                                new DepartmentVO(
                                        departmen.getId(),
                                        departmen.getDepartmentCode(),
                                        departmen.getDepartmentName(),
                                        departmen.getDescription(),
                                        departmen.getActiveStatus()
                                ))
                .collect(Collectors.toList());
    }
}
