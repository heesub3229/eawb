package com.aact.eAWB.Dto;

import com.aact.eAWB.Entity.FwbHeaderEntity;
import com.aact.eAWB.Entity.FwbRtdEntity;
import com.aact.eAWB.Entity.TcmCodeMaster;
import com.aact.eAWB.Entity.TcmObjectLanguage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CodeDto {
	private TcmCodeMaster codeMaster;
	private TcmObjectLanguage objectLanguage;
}
