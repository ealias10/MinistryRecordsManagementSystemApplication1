package com.example.Ministry.Records.Management.System.vo;


import com.example.Ministry.Records.Management.System.modal.enu.DocumentType;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentVO {


    private UUID id;
    private String documentNumber;
    private String title;
    private String Description;
    private  String creationData;
    private DocumentType documentType;
    private String security_Classification;
    private String digitalFileLocation;
    private String version;
}
