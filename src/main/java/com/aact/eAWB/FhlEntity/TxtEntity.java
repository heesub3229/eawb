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
@Table(name = "TIF_FHL_TXT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TxtEntity {
	
	@EmbeddedId
	private FhlEntityId id;
	@Column(name="GROUP_NO")
	private String groupNo;
	@Column(name="LINE_ID")
	private String lineId;
	@Column(name="FREE_TEXT")
	private String freeTxt;
	@Column(name="EDI_FLAG")
	private String ediFlag;
	@Column(name="CREATED_TIME")
	private Date createdTime;
}
