package com.aact.eAWB.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aact.eAWB.Dto.FwbDto;
import com.aact.eAWB.Entity.FwbHeaderEntity;

@Repository
public interface FwbHeaderRepository extends JpaRepository<FwbHeaderEntity, BigInteger> {

	@Query("SELECT new com.aact.eAWB.Dto.FwbDto(h,r,s) "
			+ "FROM FwbHeaderEntity h "
			+ "JOIN FwbRtdEntity r "
			+ "ON h.masterAirWayBillSid = r.masterAirWayBillSid "
			+ "LEFT JOIN FwbSphEntity s "
			+ "ON s.masterAirWayBillSid = h.masterAirWayBillSid "
			+ "AND s.sequenceNo = 1"
			+ "WHERE h.awbSerialNumber = :awbNo "
			+ "AND h.airlinePrefix = :prefix")
	List<FwbDto> findByAwb(@Param("prefix")String prefix,@Param("awbNo")String awbNo);
	
}
