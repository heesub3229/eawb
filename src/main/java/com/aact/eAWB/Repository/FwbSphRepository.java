package com.aact.eAWB.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aact.eAWB.Entity.FwbSphEntity;
import com.aact.eAWB.Entity.FwbSphEntityId;

@Repository
public interface FwbSphRepository extends JpaRepository<FwbSphEntity, FwbSphEntityId> {

	
	List<FwbSphEntity> findByIdMasterAirWayBillSid(BigInteger masterAirWayBillSid);
	
}
