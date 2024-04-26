package com.aact.eAWB.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "TWM_FWB_SPH_INFO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FwbSphEntity {
	
	
	@EmbeddedId
	private FwbSphEntityId id;
	
	@Column(name="DANGEROUS_CARGO_FLAG")
	private String dangerousCargoFlag;
	@Column(name="SPECIAL_HANDLING_CODE")
	private String SpecialHandlingCode;
	@Column(name="USABLE_FLAG")
	private String usableFalg;
	@Column(name="CREATED_USER_ID")
	private String createdUserId;
	@Column(name="CREATED_PROGRAM_ID")
	private String createdProgramId;
	@Column(name="CREATED_TIME")
	private Date createdTime;
	@Column(name="UPDATED_USER_ID")
	private String updatedUserId;
	@Column(name="UPDATED_PROGRAM_ID")
	private String updatedProgramId;
	@Column(name="UPDATED_TIME")
	private Date updatedTime;
	@Column(name="PROGRESS_GUID")
	private String prgressGuid;
	@Column(name="PROCESS_GUID")
	private String processGuid;
	
	
}
