package com.aact.eAWB.FhlEntity;

import java.math.BigInteger;
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
@Table(name = "TIF_FHL_HEADER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class HeaderEntity {

	@EmbeddedId
	private FhlEntityId id;
	@Column(name="GROUP_NO")
	private String groupNo;
	@Column(name="MESSAGE_ID")
	private String messageId;
	@Column(name="MESSAGE_VERSION")
	private String messageVersion;
	@Column(name="EDI_FLAG")
	private String ediFlag;
	@Column(name="CREATED_TIME")
	private Date createdTime;
	@Column(name="SCHEDULE_SID")
	private BigInteger scheduleSid;
	
	
}
