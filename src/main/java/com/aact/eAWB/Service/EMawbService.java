package com.aact.eAWB.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aact.eAWB.AppConfig.Log;
import com.aact.eAWB.Dto.CodeDto;
import com.aact.eAWB.Dto.FwbDto;
import com.aact.eAWB.Entity.FwbSphEntity;
import com.aact.eAWB.Entity.FwbSphEntityId;
import com.aact.eAWB.Entity.TwmFwbOciInfo;
import com.aact.eAWB.Repository.CodeMasterRepository;
import com.aact.eAWB.Repository.FwbHeaderRepository;
import com.aact.eAWB.Repository.FwbOciRepository;
import com.aact.eAWB.Repository.FwbSphRepository;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class EMawbService {
	
	@Autowired
	Log log;
	@Autowired
	FwbHeaderRepository fwbHeaderRepository;
	
	@Autowired
	FwbSphRepository fwbSphRepository;
	
	@Autowired
	CodeMasterRepository codeMasterRepository;
	
	@Autowired
	FwbOciRepository fwbOciRepository;
	
	@Autowired
	UtilService utilService;
	
	private String localPath = System.getProperty("user.dir");
	
	public void getPdfEMAWB(String mawb) {
		try {
		String[] awb = mawb.split("-");
			
		List<FwbDto> entities = fwbHeaderRepository.findByAwb(awb[0],awb[1]);
		
		
		String reportPath = localPath+"\\mawb.jasper";
		JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile(reportPath);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("imgUrl",localPath+"\\image.jpg");
		parameters.put("shpCompanyName1", utilService.nullString(entities.get(0).getHeader().getShipperCompanyName1()));
		parameters.put("prefix", utilService.nullString(entities.get(0).getHeader().getAirlinePrefix()));
		parameters.put("originCode", utilService.nullString(entities.get(0).getHeader().getOriginCode()));
		parameters.put("awbNumber", utilService.nullString(entities.get(0).getHeader().getAwbSerialNumber()));
		parameters.put("shpAccountNo", utilService.nullString(entities.get(0).getHeader().getShipperAccountNumber()));
		parameters.put("shpStreetAddress1", utilService.nullString(entities.get(0).getHeader().getShipperStreetAddress1()));
		parameters.put("shpPlaceName", utilService.nullString(entities.get(0).getHeader().getShipperPlaceName()));
		List<CodeDto> crrDto = codeMasterRepository.getCodeDto("CRRCD",utilService.nullString(entities.get(0).getHeader().getFlightCarrierCode()));
		if(crrDto.size()>0 && entities.get(0).getHeader().getFlightCarrierCode() != null) {
			if(crrDto.get(0).getObjectLanguage()==null || crrDto.get(0).getObjectLanguage().getOnjectName()==null)
			{
				if(crrDto.get(0).getCodeMaster().getCodeName() == null)
				{
					parameters.put("carrierName", utilService.nullString(entities.get(0).getHeader().getFlightCarrierCode()));
				}else {
					parameters.put("carrierName", crrDto.get(0).getCodeMaster().getCodeName());
				}
			}else {
				parameters.put("carrierName", crrDto.get(0).getObjectLanguage().getOnjectName());
			}
		}else {
			parameters.put("carrierName", "");
		}
		
		parameters.put("cneAccountNo", utilService.nullString(entities.get(0).getHeader().getConsigneeAccountNumber()));
		parameters.put("cneCompanyName1", utilService.nullString(entities.get(0).getHeader().getConsigneeCompanyName1()));
		parameters.put("cneStreetAddress1", utilService.nullString(entities.get(0).getHeader().getConsigneeStreetAddress1()));
		parameters.put("cnePlaceName", utilService.nullString(entities.get(0).getHeader().getConsigneePlaceName()));
		parameters.put("agtCompanyName", utilService.nullString(entities.get(0).getHeader().getAgentCompanyName()));
		parameters.put("agtIataCode", utilService.nullString(entities.get(0).getHeader().getAgentIataCode()));
		
		parameters.put("agtAccountNo", utilService.nullString(entities.get(0).getHeader().getAgentAccountNo()));
		parameters.put("agtPlaceName", utilService.nullString(entities.get(0).getHeader().getAgentPlaceName()));
		
		
		List<CodeDto> apoDto = codeMasterRepository.getCodeDto("APORT",utilService.nullString(entities.get(0).getHeader().getOriginCode()));
		if(apoDto.size()>0 && entities.get(0).getHeader().getOriginCode() != null) {
			if(apoDto.get(0).getObjectLanguage()==null || apoDto.get(0).getObjectLanguage().getOnjectName()==null)
			{
				if(apoDto.get(0).getCodeMaster().getCodeName() == null)
				{
					parameters.put("originName", utilService.nullString(entities.get(0).getHeader().getOriginCode()));
				}else {
					parameters.put("originName", apoDto.get(0).getCodeMaster().getCodeName());
				}
			}else {
				parameters.put("originName", apoDto.get(0).getObjectLanguage().getOnjectName());
			}
		}else {
			parameters.put("originName", "");
		}
		
		
		parameters.put("destCode", utilService.nullString(entities.get(0).getHeader().getDestinationCode()));
		
		parameters.put("rtgOnwDest1", utilService.nullString(entities.get(0).getHeader().getRoutingOnwardDestination1()));
		parameters.put("rtgOnwCarrierCode1", utilService.nullString(entities.get(0).getHeader().getRoutingOnwardCarrier1Code()));
		parameters.put("rtgFirstDest", utilService.nullString(entities.get(0).getHeader().getRoutingFirstDestination()));
		
		parameters.put("rtgFirstCarrierCode", utilService.nullString(entities.get(0).getHeader().getRoutingFirstCarrierCode()));
		parameters.put("cvdCurrencyCode", utilService.nullString(entities.get(0).getHeader().getCvdCurrencyCode()));
		
		if(entities.get(0).getHeader().getCvdDeclaredCarriage() == null || entities.get(0).getHeader().getCvdDeclaredCarriage().compareTo(BigDecimal.ZERO)==0) {
			parameters.put("cvdDeclaredCarriage", "NVD");
		}else {
			parameters.put("cvdDeclaredCarriage", entities.get(0).getHeader().getCvdDeclaredCarriage().toString());
		}
		
		if(entities.get(0).getHeader().getCvdDeclaredCustoms() == null || entities.get(0).getHeader().getCvdDeclaredCustoms().compareTo(BigDecimal.ZERO)==0) {
			parameters.put("cvdDeclaredCustoms", "NCV");
		}else {
			parameters.put("cvdDeclaredCustoms", entities.get(0).getHeader().getCvdDeclaredCustoms().toString());
		}
		
		
		List<CodeDto> destDto = codeMasterRepository.getCodeDto("APORT",utilService.nullString(entities.get(0).getHeader().getDestinationCode()));
		if(destDto.size()>0 && entities.get(0).getHeader().getDestinationCode() != null) {
			if(destDto.get(0).getObjectLanguage() == null || destDto.get(0).getObjectLanguage().getOnjectName()==null)
			{
				if(destDto.get(0).getCodeMaster().getCodeName() == null)
				{
					parameters.put("destName", utilService.nullString(entities.get(0).getHeader().getDestinationCode()));
				}else {
					parameters.put("destName", destDto.get(0).getCodeMaster().getCodeName());
				}
			}else {
				parameters.put("destName", destDto.get(0).getObjectLanguage().getOnjectName());
			}
		}else {
			parameters.put("destName", "");
		}
		
		parameters.put("fltNo", utilService.nullString(entities.get(0).getHeader().getFlightCarrierCode()+entities.get(0).getHeader().getFlightNumber()));
		parameters.put("fltDate", utilService.nullString(entities.get(0).getHeader().getFlightDay()));
		
		if(entities.get(0).getHeader().getCvdDeclaredInsurance() == null || entities.get(0).getHeader().getCvdDeclaredInsurance().compareTo(BigDecimal.ZERO)==0) {
			parameters.put("cvdDeclaredInsurance", "XXX");
		}else {
			parameters.put("cvdDeclaredInsurance", entities.get(0).getHeader().getCvdDeclaredInsurance().toString());
		}
		
		parameters.put("noOfPieces", utilService.nullString(entities.get(0).getHeader().getNumberOfPieces().toString()));
		parameters.put("weight", utilService.nullString(entities.get(0).getHeader().getWeight().toString()));
		parameters.put("rateClassCode", utilService.nullString(entities.get(0).getRtd().getRateClassCode().toString()));
		parameters.put("chargeableWeightDetails", utilService.nullString(entities.get(0).getRtd().getChargeableWeightDetails().toString()));
		parameters.put("rateChargeDetails", utilService.nullString(entities.get(0).getRtd().getRateChargeDetails().toString()));
		parameters.put("totalDetails", utilService.nullString(entities.get(0).getRtd().getTotalDetails().toString()));
		parameters.put("goodsDescription", utilService.nullString(entities.get(0).getRtd().getGoodsDescription()));
		parameters.put("ppdWeightCharge", utilService.nullString(entities.get(0).getHeader().getPrePaidWeightCharge().toString()));
		parameters.put("ppdValuationCharge", utilService.nullString(entities.get(0).getHeader().getPrePaidValuationCharge().toString()));
		parameters.put("ppdTaxes", utilService.nullString(entities.get(0).getHeader().getPrePaidTaxes().toString()));
		parameters.put("ppdOtherChargeAgent", utilService.nullString(entities.get(0).getHeader().getPrePaidOtherChargeAgent().toString()));
		parameters.put("ppdOtherChargeCarrier", utilService.nullString(entities.get(0).getHeader().getPrePaidOtherChargeCarrier().toString()));
		parameters.put("ppdTotalChargeSummary", utilService.nullString(entities.get(0).getHeader().getPrePaidTotalChargeSummary().toString()));
		parameters.put("colTotalChargeSummary", utilService.nullString(entities.get(0).getHeader().getCollectTotalChargeSummary().toString()));
		parameters.put("colOtherChargeCarrier", utilService.nullString(entities.get(0).getHeader().getCollectOtherChargeCarrier().toString()));
		parameters.put("colOtherChargeAgent", utilService.nullString(entities.get(0).getHeader().getCollectOtherChargeAgent().toString()));
		parameters.put("colTaxes", utilService.nullString(entities.get(0).getHeader().getCollectTaxes().toString()));
		
		parameters.put("colValuationCharge",utilService.nullString(entities.get(0).getHeader().getCollectValuationCharge().toString()));
		parameters.put("colWeightCharge", utilService.nullString(entities.get(0).getHeader().getCollectWeightCharge().toString()));
		parameters.put("othOtherChargeCode1", utilService.nullString(entities.get(0).getHeader().getOtherCharge1Code()));
		parameters.put("othEntitlementCode1", utilService.nullString(entities.get(0).getHeader().getOthEntitlement1Code()));
		parameters.put("othEntitlementCode2", utilService.nullString(entities.get(0).getHeader().getOthEntitlement2Code()));
		parameters.put("othOtherChargeCode2", utilService.nullString(entities.get(0).getHeader().getOthOtherCharge2Code()));
		parameters.put("othEntitlementCode3", utilService.nullString(entities.get(0).getHeader().getOthEntitlement3Code()));
		parameters.put("othOtherChargeCode3", utilService.nullString(entities.get(0).getHeader().getOthOtherCharge3Code()));
		parameters.put("othChargeAmount1",utilService.nullString(entities.get(0).getHeader().getOthCharge1Amount()));
		parameters.put("othChargeAmount2", utilService.nullString(entities.get(0).getHeader().getOthCharge2Amount()));
		parameters.put("othChargeAmount3",utilService.nullString(entities.get(0).getHeader().getOthCharge3Amount()));
		parameters.put("osiOtherInfomation1", utilService.nullString(entities.get(0).getHeader().getOsiOtherInformation1()));
		parameters.put("osiOtherInfomation2", utilService.nullString(entities.get(0).getHeader().getOsiOtherInformation2()));
		parameters.put("osiOtherInfomation3", utilService.nullString(entities.get(0).getHeader().getOsiOtherInformation3()));
		if(entities.get(0).getHeader().getCerCertificationSign()==null) {
			parameters.put("cerCertificationSign",entities.get(0).getHeader().getAgentCompanyName());
		}else {
			parameters.put("cerCertificationSign",entities.get(0).getHeader().getCerCertificationSign());
		}
		
		parameters.put("isuAwbIssueDay", utilService.nullString(entities.get(0).getHeader().getIsuAwbIssueDay()));
		parameters.put("isuAwbIssueMonth", utilService.nullString(entities.get(0).getHeader().getIsuAwbIssueMonth()));
		parameters.put("isuAwbIssueYear", utilService.nullString(entities.get(0).getHeader().getIsuAwbIssueYear()));
		parameters.put("isuAuthorisationSign", utilService.nullString(entities.get(0).getHeader().getIsuAuthorizationSign()));
		
		List<TwmFwbOciInfo> ociEntities = fwbOciRepository.findByIdMasterAirWayBillSid(entities.get(0).getHeader().getMasterAirWayBillSid());
		
		if(ociEntities.size()>=6) {
			
		}else {
			int empty = 6-ociEntities.size();
			for(int i = 0;i<empty;i++) {
				TwmFwbOciInfo dtos = new TwmFwbOciInfo();
				FwbSphEntityId dtoId = new FwbSphEntityId();
				dtos.setId(dtoId);
				ociEntities.add(dtos);
			}
		}
		
		for(int i = 0;i<6;i++) {
			if(ociEntities.get(i).getId().getMasterAirWayBillSid()!=null && ociEntities.get(i).getId().getMasterAirWayBillSid().compareTo(BigInteger.ZERO)>0) {
				parameters.put("ociInfo"+(i+1), utilService.nullString(ociEntities.get(i).getCountryCode()+":")
						+ utilService.nullString(ociEntities.get(i).getInformIdentifier()+":")
						+ utilService.nullString(ociEntities.get(i).getCntrlIdentifier()+":")
						+ utilService.nullString(ociEntities.get(i).getCntrlInform()));
			}else {
				parameters.put("ociInfo"+(i+1), "");
			}
		}
		
		
		List<FwbSphEntity> sphEntities = fwbSphRepository.findByIdMasterAirWayBillSid(entities.get(0).getHeader().getMasterAirWayBillSid());
		
		if(sphEntities.size()>=6) {
			
		}else {
			int empty = 6-sphEntities.size();
			for(int i = 0;i<empty;i++) {
				FwbSphEntity dtos = new FwbSphEntity();
				FwbSphEntityId dtoId = new FwbSphEntityId();
				dtos.setId(dtoId);
				sphEntities.add(dtos);
			}
			
			
		}
		
		for(int i = 0;i<6;i++) {
			if(sphEntities.get(i).getSpecialHandlingCode() != null || !sphEntities.get(i).getSpecialHandlingCode().equals("")) {
				parameters.put("shc"+(i+1), sphEntities.get(i).getSpecialHandlingCode());
			}else {
				parameters.put("shc"+(i+1), "");
			}
		}
		
		if(utilService.nullString(entities.get(0).getHeader().getCvdPcIndWeight()).equals("P") ) {
			parameters.put("cvdPpdWeight","X");
			parameters.put("cvdCollWeight","");
		}else {
			parameters.put("cvdPpdWeight","");
			parameters.put("cvdCollWeight","X");
		}
		if(utilService.nullString(entities.get(0).getHeader().getCvdPcIndOther()).equals("P")) {
			parameters.put("cvdPpdOther","X");
			parameters.put("cvdCollOther","");
		}else {
			parameters.put("cvdPpdOther","");
			parameters.put("cvdCollOther","X");
		}
		parameters.put("cvdChargeCode",utilService.nullString(entities.get(0).getHeader().getCvdChargeCode()));
		
		
		

		

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,new JREmptyDataSource());
		
		JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\temp\\report3.pdf");
		
			
		
		}catch (Exception e) {
			// TODO: handle exception
			log.logTemp(e.getMessage(), "getPdfEMAWB");
		}

	}
}
