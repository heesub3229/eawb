package com.aact.eAWB.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aact.eAWB.AppConfig.JdbcConnet;
import com.aact.eAWB.AppConfig.Log;
import com.aact.eAWB.Dto.OraParam;
import com.aact.eAWB.Dto.ProcResDTO;
import com.aact.eAWB.Dto.RateDto;
import com.aact.eAWB.Dto.ResponseDTO;
import com.aact.eAWB.Enum.OraEnum;



@Service
public class UtilService {

	@Autowired
	Log log;
	
	@Autowired
	JdbcConnet jdbcConnet;
	
	//null값 걸러내기
	public String nullString(String data) {
		
		String ret = "";
		if(data==null) {
			
		}else {
			ret = data;
		}
		
		return ret;
	}
	
	
	
	
	public ProcResDTO getPclSettleSlipSelCalc(String rateType,
												BigInteger unitAmount,
												BigDecimal cargeableWeight,
												String cargoInTime,
												String cargoOutTime,
												BigInteger storageDays,
												BigInteger storageHours,
												RateDto rateDto
												) {
		ProcResDTO dto = new ProcResDTO();
		
		
		List<OraParam> pram = new ArrayList<OraParam>();
		
		OraParam pramDto = null;
		String procName = "WMSMAIN.USR_SETTLE_SLIP_M011.PCL_SETTLE_SLIP_M010_SEL_CALC";
		
		
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.Long);
		pramDto.setPramName("I_SETTLE_SLIP_SID");
		pramDto.setPramValue(0);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_CARGO_CONTROL_NO");
		pramDto.setPramValue("");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_INOUT_TYPE");
		pramDto.setPramValue("I");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_RATE_TYPE");
		pramDto.setPramValue(rateType);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_CARGO_IN_TIME");
		pramDto.setPramValue(cargoInTime);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_CARGO_OUT_TIME");
		pramDto.setPramValue(cargoOutTime);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigInteger);
		pramDto.setPramName("I_STORAGE_DAYS");
		pramDto.setPramValue(storageDays);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigInteger);
		pramDto.setPramName("I_STORAGE_HOURS");
		pramDto.setPramValue(storageHours);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_HOLD_TIME");
		pramDto.setPramValue("");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_RELEASE_TIME");
		pramDto.setPramValue("");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.Long);
		pramDto.setPramName("I_HOLD_DAYS");
		pramDto.setPramValue(0);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.Long);
		pramDto.setPramName("I_HOLD_HOURS");
		pramDto.setPramValue(0);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_BOSU_START_TIME");
		pramDto.setPramValue("");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_BOSU_END_TIME");
		pramDto.setPramValue("");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.Long);
		pramDto.setPramName("I_BOSU_HOURS");
		pramDto.setPramValue(0);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigInteger);
		pramDto.setPramName("I_UNIT_AMOUNT");
		pramDto.setPramValue(unitAmount);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigDecimal);
		pramDto.setPramName("I_CHARGEABLE_WEIGHT");
		pramDto.setPramValue(cargeableWeight);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigInteger);
		pramDto.setPramName("I_WHCA_BASE_AMOUNT");
		pramDto.setPramValue(rateDto.getWhcaBaseAmount());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigDecimal);
		pramDto.setPramName("I_WHCA_BASE_RATE");
		pramDto.setPramValue(rateDto.getWhcaBaseRate());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigDecimal);
		pramDto.setPramName("I_WHCA_ADD_RATE");
		pramDto.setPramValue(rateDto.getWhcaAddRate());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigInteger);
		pramDto.setPramName("I_WHCA_RATE_SID");
		pramDto.setPramValue(rateDto.getWhcaRateSid());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigInteger);
		pramDto.setPramName("I_WHCW_BASE_AMOUNT");
		pramDto.setPramValue(rateDto.getWhcwBaseAmount());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigDecimal);
		pramDto.setPramName("I_WHCW_BASE_RATE");
		pramDto.setPramValue(rateDto.getWhcwBaseRate());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigDecimal);
		pramDto.setPramName("I_WHCW_ADD_RATE");
		pramDto.setPramValue(rateDto.getWhcwAddRate());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigInteger);
		pramDto.setPramName("I_WHCW_RATE_SID");
		pramDto.setPramValue(rateDto.getWhcwRateSid());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigInteger);
		pramDto.setPramName("I_THC_BASE_AMOUNT");
		pramDto.setPramValue(rateDto.getThcBaseAmount());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigDecimal);
		pramDto.setPramName("I_THC_BASE_RATE");
		pramDto.setPramValue(rateDto.getThcBaseRate());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigDecimal);
		pramDto.setPramName("I_THC_ADD_RATE");
		pramDto.setPramValue(rateDto.getThcAddRate());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.BigInteger);
		pramDto.setPramName("I_THC_RATE_SID");
		pramDto.setPramValue(rateDto.getThcRateSid());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.Long);
		pramDto.setPramName("I_HOLD_BASE_AMOUNT");
		pramDto.setPramValue(0);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.Long);
		pramDto.setPramName("I_HOLD_BASE_RATE");
		pramDto.setPramValue(0);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.Long);
		pramDto.setPramName("I_HOLD_ADD_RATE");
		pramDto.setPramValue(0);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.Long);
		pramDto.setPramName("I_HOLD_RATE_SID");
		pramDto.setPramValue(0);
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_LANGUAGE_CODE");
		pramDto.setPramValue("KOR");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_PROGRESS_GUID");
		pramDto.setPramValue(getGuid());
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_REQUEST_USER_ID");
		pramDto.setPramValue("CUSTOMER");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_REQUEST_IP_ADDRESS");
		pramDto.setPramValue("1.1.1.1");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.String);
		pramDto.setPramName("I_REQUEST_PROGRAM_ID");
		pramDto.setPramValue("CUSTOMER_WEB");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.OutCursor);
		pramDto.setPramName("O_RESULT_CURSOR");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.OutString);
		pramDto.setPramName("O_ERROR_FLAG");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.OutString);
		pramDto.setPramName("O_RETURN_CODE");
		pram.add(pramDto);
		pramDto = new OraParam();
		pramDto.setPramtype(OraEnum.OutString);
		pramDto.setPramName("O_RETURN_MESSAGE");
		pram.add(pramDto);
		
		
		dto = jdbcConnet.oraCon(procName, pram);
		
		return dto;
	}
	
	
	public String getGuid() {
		UUID uuid = UUID.randomUUID();
		
		return uuid.toString();
	}
	
	//String null값체크
	public String strNull(Object value) {
		String ret = "";
		
		if(value == null) {
			
		}else {
			ret = value.toString();
		}
		
		return ret;
	}
	
	public ResponseDTO<String> setResponseData(Boolean flag,String data){
		
		List<String> dataArray = new ArrayList<String>();
		dataArray.add(data);
		
		ResponseDTO<String> dtos = ResponseDTO.<String>builder().error("Y").data(dataArray).build();
		
		return dtos;
		
		
		
	}
	
	
	
}
