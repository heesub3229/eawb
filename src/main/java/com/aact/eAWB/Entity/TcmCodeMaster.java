package com.aact.eAWB.Entity;

import java.math.BigDecimal;
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
@Table(name = "TCM_CODE_MASTER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TcmCodeMaster {

	@Id
	@Column(name="CODE_SID")
	private BigInteger codeSid;
	@Column(name="CLASS_SID")
	private BigInteger classSid;
	@Column(name="CLASS_CODE")
	private String classCode;
	@Column(name="CODE_CODE")
	private String codeCode;
	@Column(name="ASIS_CODE")
	private String asisCode;
	@Column(name="CODE_NAME")
	private String codeName;
	@Column(name="CODE_DESCRIPTION")
	private String codeDescription;
	@Column(name="VALUE1_CHAR")
	private String value1Char;
	@Column(name="VALUE2_CHAR")
	private String value2Char;
	@Column(name="VALUE3_CHAR")
	private String value3Char;
	@Column(name="VALUE4_CHAR")
	private String value4Char;
	@Column(name="VALUE5_CHAR")
	private String value5Char;
	@Column(name="VALUE1_NUMBER")
	private BigDecimal value1Number;
	@Column(name="VALUE2_NUMBER")
	private BigDecimal value2Number;
	@Column(name="VALUE3_NUMBER")
	private BigDecimal value3Number;
	@Column(name="VALUE4_NUMBER")
	private BigDecimal value4Number;
	@Column(name="VALUE5_NUMBER")
	private BigDecimal value5Number;
	@Column(name="ORDER_SEQ")
	private BigInteger orderSeq;
	@Column(name="USABLE_FLAG")
	private String usableFlag;
	@Column(name="CREATED_USER_ID")
	private String createdUserId;
	@Column(name="CREATED_PROGRAM_ID")
	private String createdProgramID;
	@Column(name="CREATED_TIME")
	private String createdTime;
	@Column(name="UPDATED_USER_ID")
	private String updateUserID;
	@Column(name="UPDATED_PROGRAM_ID")
	private String updatedProgramId;
	@Column(name="UPDATED_TIME")
	private String updatedTime;
	@Column(name="PROGRESS_GUID")
	private String progressGuid;
	@Column(name="PROCESS_GUID")
	private String processGuid;
	@Column(name="VALUE6_CHAR")
	private String value6Char;
	@Column(name="VALUE7_CHAR")
	private String value7Char;
	@Column(name="VALUE8_CHAR")
	private String value8Char;
	@Column(name="VALUE9_CHAR")
	private String value9Char;
	@Column(name="VALUE6_NUMBER")
	private BigDecimal value6Number;
	@Column(name="VALUE7_NUMBER")
	private BigDecimal value7Number;
	@Column(name="VALUE8_NUMBER")
	private BigDecimal value8Number ;
	@Column(name="VALUE9_NUMBER")
	private BigDecimal value9Number;

}
