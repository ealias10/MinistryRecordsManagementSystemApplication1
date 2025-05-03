package com.example.Ministry.Records.Management.System.repositery;

import com.example.Ministry.Records.Management.System.modal.DocumentWorkflow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentWorkflowRepositery extends JpaRepository<DocumentWorkflow, UUID> {
}
