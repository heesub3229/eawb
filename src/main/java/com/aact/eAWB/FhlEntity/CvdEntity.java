package com.aact.eAWB.FhlEntity;

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
@Table(name = "TIF_FHL_CVD",schema = "WMSEDI")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CvdEntity {
	
	@EmbeddedId
	private FhlEntityId id;
	@Column(name="GROUP_NO")
	private String groupNo;
	@Column(name="LINE_ID")
	private String lineId;
	@Column(name="CURRENCY_CODE")
	private String currencyCode;
	@Column(name="PC_WGT_VAL")
	private String pcWgtVal;
	@Column(name="PC_OTH_CHG")
	private String pcOthChg;
	@Column(name="CARRIAGE_VALUE")
	private String carriageValue;
	@Column(name="CUSTOMS_VALUE")
	private String customsValue;
	@Column(name="INSURANCE_VALUE")
	private String insuranceValue;
	@Column(name="EDI_FLAG")
	private String ediFlag;
	@Column(name="CREATED_TIME")
	private Date createdTime;

}
