package com.aact.eAWB.Dto;

import java.math.BigInteger;

import com.aact.eAWB.Entity.FwbHeaderEntity;
import com.aact.eAWB.Entity.FwbRtdEntity;
import com.aact.eAWB.Entity.FwbSphEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FwbDto {
	private FwbHeaderEntity header;
	private FwbRtdEntity rtd;
	private FwbSphEntity sph;
	
}
