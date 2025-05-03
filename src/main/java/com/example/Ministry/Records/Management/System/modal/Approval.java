package com.example.Ministry.Records.Management.System.modal;

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
public class Approval {

    @Id
    @Column(name = "id",updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "document_workflow",referencedColumnName = "id")
    @ToString.Exclude
    private Document documentWorkflow;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "approver_department",referencedColumnName = "id")
    @ToString.Exclude
    private Department approverDepartment;

    @Column(name = "approval_status")
    private String approvalStatus;

    @Column(name = "approval_date")
    private String approvalDate;

    @Column(name = "approver_id")
    private String approverId;
}
