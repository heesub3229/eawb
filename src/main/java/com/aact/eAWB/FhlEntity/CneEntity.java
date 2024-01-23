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
@Table(name = "TIF_FHL_CNE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CneEntity {
	
	@EmbeddedId
	private FhlEntityId id;
	@Column(name="GROUP_NO")
	private String groupNo;
	@Column(name="LINE_ID")
	private String lineId;
	@Column(name="NAME")
	private String name;
	@Column(name="ADDR")
	private String addr;
	@Column(name="PLACE")
	private String place;
	@Column(name="STATE")
	private String state;
	@Column(name="COUNTRY_CODE")
	private String countryCode;
	@Column(name="POST_CODE")
	private String postCode;
	@Column(name="CONTACT_ID")
	private String contactId;
	@Column(name="CONTACT_NO")
	private String contactNo;
	@Column(name="EDI_FLAG")
	private String ediFlag;
	@Column(name="CREATED_TIME")
	private Date createdTime;
	

}
