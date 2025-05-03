package com.example.Ministry.Records.Management.System.vo;

import lombok.*;

import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentVO {


    private UUID id;

    private String departmentCode;


    private String departmentName;


    private String description;


    private Boolean activeStatus;
}
