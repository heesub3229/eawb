package com.aact.eAWB.FhlEntity;

import java.math.BigInteger;

import com.aact.eAWB.Entity.FwbSphEntityId;

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
public class FhlEntityId {
	
	@Column(name = "EDI_GUID")
    private String ediGuid;

    @Column(name = "ROW_SEQ_NO")
    private BigInteger sequenceNo;
}
