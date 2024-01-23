package com.aact.eAWB.Entity;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TWM_FWB_OCI_INFO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TwmFwbOciInfo {

	@Id
	@Column(name="MASTER_AIR_WAY_BILL_SID")
	private BigInteger mawbBillSid;
	@Column(name="SEQUENCE_NO")
	private BigInteger sequenceNo;
	@Column(name="COUNTRY_CODE")
	private String countryCode;
	@Column(name="INFORMATION_IDENTIFIER")
	private String informIdentifier;
	@Column(name="CONTROL_IDENTIFIER")
	private String cntrlIdentifier;
	@Column(name="CONTROL_INFORMATION")
	private String cntrlInform;
	@Column(name="USABLE_FLAG")
	private String usableFlag;
	@Column(name="CREATED_USER_ID")
	private String createdUserId;
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
