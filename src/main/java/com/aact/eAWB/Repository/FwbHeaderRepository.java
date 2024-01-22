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

	@Query("SELECT new com.aact.eAWB.Dto.FwbDto(h,r) "
			+ "FROM FwbHeaderEntity h "
			+ "JOIN FwbRtdEntity r "
			+ "ON h.masterAirWayBillSid = r.id.masterAirWayBillSid "
			+ "WHERE h.awbSerialNumber = :awbNo "
			+ "AND h.airlinePrefix = :prefix "
			+ "AND h.usableFlag = 'Y'")
	List<FwbDto> findByAwb(@Param("prefix")String prefix,@Param("awbNo")String awbNo);
	
	
	
	
}
