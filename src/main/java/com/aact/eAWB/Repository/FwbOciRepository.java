package com.aact.eAWB.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aact.eAWB.Entity.FwbSphEntity;
import com.aact.eAWB.Entity.FwbSphEntityId;
import com.aact.eAWB.Entity.TwmFwbOciInfo;

@Repository
public interface FwbOciRepository extends JpaRepository<TwmFwbOciInfo, FwbSphEntityId> {

	List<TwmFwbOciInfo> findByIdMasterAirWayBillSid(BigInteger masterAirWayBillSid);
	
}
