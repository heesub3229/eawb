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
public class FwbSphEntityId implements Serializable {

	@Column(name = "MASTER_AIR_WAY_BILL_SID")
    private BigInteger masterAirWayBillSid;

    @Column(name = "SEQUENCE_NO")
    private BigInteger sequenceNo;
}
