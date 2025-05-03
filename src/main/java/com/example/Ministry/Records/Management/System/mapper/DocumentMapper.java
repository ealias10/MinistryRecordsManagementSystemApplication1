package com.example.Ministry.Records.Management.System.mapper;

import com.example.Ministry.Records.Management.System.modal.Department;
import com.example.Ministry.Records.Management.System.modal.Document;
import com.example.Ministry.Records.Management.System.vo.DepartmentVO;
import com.example.Ministry.Records.Management.System.vo.DocumentVO;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentMapper {
    public static List<DocumentVO> getAllDepartmentListVO(List<Document> list)
    {
        return list.stream()
                .map(
                        departmen ->
                                new DocumentVO(
                                        departmen.getId(),
                                        departmen.getDocumentNumber(),
                                        departmen.getTitle(),
                                        departmen.getDescription(),
                                        departmen.getCreationData(),
                                        departmen.getDocumentType(),
                                        departmen.getSecurity_Classification(),
                                        departmen.getDigitalFileLocation(),
                                        departmen.getDocumentNumber()
                                ))
                .collect(Collectors.toList());
    }
}
