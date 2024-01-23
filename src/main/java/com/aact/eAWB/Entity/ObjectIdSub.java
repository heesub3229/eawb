package com.aact.eAWB.Entity;

import java.io.Serializable;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ObjectIdSub implements Serializable {

	@Column(name="OBJECT_SID")
	private BigInteger objectSid;
	@Column(name="LANGUAGE_CODE")
	private String languageCode;
}
