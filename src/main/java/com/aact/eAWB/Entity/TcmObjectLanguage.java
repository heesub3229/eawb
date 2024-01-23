package com.aact.eAWB.Entity;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TCM_OBJECT_LANGUAGE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TcmObjectLanguage {

	@EmbeddedId
	private ObjectIdSub id;
	@Column(name="OBJECT_NAME")
	private String onjectName;
	@Column(name="REMARKS")
	private String remarks;
	@Column(name="USABLE_FLAG")
	private String usableFlag;
	@Column(name="CREATED_USER_ID")
	private String createdUserID;
	@Column(name="CREATED_PROGRAM_ID")
	private String createdProgramID;
	@Column(name="CREATED_TIME")
	private String createdTime;
	@Column(name="UPDATED_USER_ID")
	private String updatedUserId;
	@Column(name="UPDATED_PROGRAM_ID")
	private String updatedProgramId;
	@Column(name="UPDATED_TIME")
	private String updatedTime;
	@Column(name="PROGRESS_GUID")
	private String progressGuid;
	@Column(name="PROCESS_GUID")
	private String processGuid;
}
