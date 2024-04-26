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
@Table(name = "TIF_FHL_HBS",schema = "WMSEDI")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class HbsEntity {
	
	@EmbeddedId
	private FhlEntityId id;
	@Column(name="GROUP_NO")
	private String groupNo;
	@Column(name="LINE_ID")
	private String lineId;
	@Column(name="HAWB_SERIAL_NO")
	private String hawbSerialNo;
	@Column(name="ORG_AIRPORT_CODE")
	private String orgAirportCode;
	@Column(name="DEST_AIRPORT_CODE")
	private String destAirportCode;
	@Column(name="NO_OF_PIECES")
	private String noOfPieces;
	@Column(name="WEIGHT_CODE")
	private String weigtCode;
	@Column(name="WEIGHT")
	private String weight;
	@Column(name="SLAC")
	private String slac;
	@Column(name="MFST_DESC_GOODS")
	private String mfstDescGoods;
	@Column(name="EDI_FLAG")
	private String ediFlag;
	@Column(name="CREATED_TIME")
	private Date createdTime;
	

}
