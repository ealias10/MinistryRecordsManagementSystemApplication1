package com.example.Ministry.Records.Management.System.modal;

import com.example.Ministry.Records.Management.System.modal.enu.DocumentType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity
public class Document {
    @Id
    @Column(name = "id",updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "document_number",unique = true)
    private String documentNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String Description;


    @Column(name = "creation_date")
    private  String creationData;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_department",referencedColumnName = "id")
    @ToString.Exclude
    private Department ownerDepartment;


    @Enumerated(EnumType.STRING)
    @Column(name = "document_Type")
    private DocumentType documentType;


    @Column(name = "security_classification")
    private String security_Classification;

    @Column(name = "digital_file_location")
    private String digitalFileLocation;

    @Column(name = "version")
    private String version;


}
