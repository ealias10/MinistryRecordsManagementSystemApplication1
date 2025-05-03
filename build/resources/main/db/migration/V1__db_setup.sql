CREATE TABLE department (
  id UUID NOT NULL,
   department_code VARCHAR(255),
   department_name VARCHAR(255),
   description VARCHAR(255),
   active_status BOOLEAN,
   CONSTRAINT pk_department PRIMARY KEY (id)
);

ALTER TABLE department ADD CONSTRAINT uc_department_department_code UNIQUE (department_code);

CREATE TABLE document (
  id UUID NOT NULL,
   document_number VARCHAR(255),
   title VARCHAR(255),
   description VARCHAR(255),
   creation_date VARCHAR(255),
   owner_department UUID,
   document_type VARCHAR(255),
   security_classification VARCHAR(255),
   digital_file_location VARCHAR(255),
   version VARCHAR(255),
   CONSTRAINT pk_document PRIMARY KEY (id)
);

ALTER TABLE document ADD CONSTRAINT uc_document_document_number UNIQUE (document_number);

ALTER TABLE document ADD CONSTRAINT FK_DOCUMENT_ON_OWNER_DEPARTMENT FOREIGN KEY (owner_department) REFERENCES department (id);

CREATE TABLE document_workflow (
  id UUID NOT NULL,
   document UUID,
   current_state VARCHAR(255),
   last_modified_date BIGINT,
   last_modified_by UUID,
   comments VARCHAR(255),
   CONSTRAINT pk_documentworkflow PRIMARY KEY (id)
);

ALTER TABLE document_workflow ADD CONSTRAINT FK_DOCUMENTWORKFLOW_ON_DOCUMENT FOREIGN KEY (document) REFERENCES document (id);


CREATE TABLE approval (
  id UUID NOT NULL,
   document_workflow UUID,
   approver_department UUID,
   approval_status VARCHAR(255),
   approval_date VARCHAR(255),
   approver_id VARCHAR(255),
   CONSTRAINT pk_approval PRIMARY KEY (id)
);

ALTER TABLE approval ADD CONSTRAINT FK_APPROVAL_ON_APPROVER_DEPARTMENT FOREIGN KEY (approver_department) REFERENCES department (id);

ALTER TABLE approval ADD CONSTRAINT FK_APPROVAL_ON_DOCUMENT_WORKFLOW FOREIGN KEY (document_workflow) REFERENCES document (id);