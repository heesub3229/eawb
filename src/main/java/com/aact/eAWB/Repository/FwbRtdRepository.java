package com.aact.eAWB.Repository;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aact.eAWB.Entity.FwbRtdEntity;
import com.aact.eAWB.Entity.FwbSphEntityId;

@Repository
public interface FwbRtdRepository extends JpaRepository<FwbRtdEntity, FwbSphEntityId> {

}
