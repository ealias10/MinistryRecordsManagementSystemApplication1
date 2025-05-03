package com.example.Ministry.Records.Management.System.repositery;

import com.example.Ministry.Records.Management.System.modal.Approval;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApprovalRepositery extends JpaRepository<Approval, UUID> {
}
