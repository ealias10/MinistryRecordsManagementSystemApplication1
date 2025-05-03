package com.example.Ministry.Records.Management.System.modal;

import com.example.Ministry.Records.Management.System.modal.enu.WorkflowState;
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
public class DocumentWorkflow {
    @Id
    @Column(name = "id",updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "document",referencedColumnName = "id")
    @ToString.Exclude
    private Document document;


    @Enumerated(EnumType.STRING)
    @Column(name = "current_state")
    private WorkflowState currentState;

    @Column(name = "last_modified_date")
    private long lastModifiedDate;

    @Column(name = "last_modified_by")
    private UUID userId;

    @Column(name = "comments")
    private  String comments;
}
