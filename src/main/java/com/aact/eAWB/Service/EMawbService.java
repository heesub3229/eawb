package com.aact.eAWB.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aact.eAWB.AppConfig.Log;
import com.aact.eAWB.Dto.FwbDto;
import com.aact.eAWB.Entity.FwbSphEntity;
import com.aact.eAWB.Repository.FwbHeaderRepository;
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
				parameters.put("carrierName", "");
				parameters.put("cneAccountNo", utilService.nullString(entities.get(0).getHeader().getConsigneeAccountNumber()));
				parameters.put("cneCompanyName1", utilService.nullString(entities.get(0).getHeader().getConsigneeCompanyName1()));
				parameters.put("cneStreetAddress1", utilService.nullString(entities.get(0).getHeader().getConsigneeStreetAddress1()));
				parameters.put("cnePlaceName", utilService.nullString(entities.get(0).getHeader().getConsigneePlaceName()));
				parameters.put("agtCompanyName", utilService.nullString(entities.get(0).getHeader().getAgentCompanyName()));
				parameters.put("agtIataCode", utilService.nullString(entities.get(0).getHeader().getAgentIataCode()));
				
				parameters.put("agtAccountNo", utilService.nullString(entities.get(0).getHeader().getAgentAccountNo()));
				parameters.put("agtPlaceName", utilService.nullString(entities.get(0).getHeader().getAgentPlaceName()));
				parameters.put("originName", "");
				parameters.put("destCode", utilService.nullString(entities.get(0).getHeader().getDestinationCode()));
				parameters.put("carrierName", "");
				
				parameters.put("rtgOnwDest1", utilService.nullString(entities.get(0).getHeader().getRoutingOnwardDestination1()));
				parameters.put("rtgOnwCarrierCode1", utilService.nullString(entities.get(0).getHeader().getRoutingOnwardCarrier1Code()));
				parameters.put("rtgFirstDest", utilService.nullString(entities.get(0).getHeader().getRoutingFirstDestination()));
				
				parameters.put("rtgFirstCarrierCode", utilService.nullString(entities.get(0).getHeader().getRoutingFirstCarrierCode()));
				parameters.put("cvdCurrencyCode", utilService.nullString(entities.get(0).getHeader().getCvdCurrencyCode()));
				parameters.put("cvdDeclaredCarriage", utilService.nullString(entities.get(0).getHeader().getCvdDeclaredCarriage().toString()));
				
				parameters.put("cvdDeclaredCustoms", utilService.nullString(entities.get(0).getHeader().getCvdDeclaredCustoms().toString()));
				parameters.put("destName", "");
				
				parameters.put("fltNo", utilService.nullString(entities.get(0).getHeader().getFlightCarrierCode()+entities.get(0).getHeader().getFlightNumber()));
				parameters.put("fltDate", utilService.nullString(entities.get(0).getHeader().getFlightDay()));
				parameters.put("cvdDeclaredInsurance", utilService.nullString(entities.get(0).getHeader().getCvdDeclaredInsurance().toString()));
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
				parameters.put("cerCertificationSign","");
				parameters.put("isuAwbIssueDay", utilService.nullString(entities.get(0).getHeader().getIsuAwbIssueDay()));
				parameters.put("isuAwbIssueMonth", utilService.nullString(entities.get(0).getHeader().getIsuAwbIssueMonth()));
				parameters.put("isuAwbIssueYear", utilService.nullString(entities.get(0).getHeader().getIsuAwbIssueYear()));
				parameters.put("isuAuthorisationSign", utilService.nullString(entities.get(0).getHeader().getIsuAuthorizationSign()));
				parameters.put("ociInfo1", "");
				parameters.put("ociInfo2", "");
				parameters.put("ociInfo3", "");
				parameters.put("ociInfo4", "");
				parameters.put("ociInfo5", "");
				parameters.put("ociInfo6", "");
				
				List<FwbSphEntity> sphEntities = fwbSphRepository.findByIdMasterAirWayBillSid(entities.get(0).getHeader().getMasterAirWayBillSid());
				
				if(sphEntities.size()>=6) {
					
				}else {
					int empty = 6-sphEntities.size();
					for(int i = 0;i<empty;i++) {
						FwbSphEntity dtos = new FwbSphEntity();
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
				
			
				parameters.put("cvdPpdWeight","");
				parameters.put("cvdCollWeight","");
				parameters.put("cvdPpdOther","");
				parameters.put("cvdCollOther","");
				parameters.put("cvdChargeCode","");
				
				
				
		
				
		
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,new JREmptyDataSource());
				
				JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\temp\\report3.pdf");
			
			
		
		}catch (Exception e) {
			// TODO: handle exception
			log.logTemp(e.getMessage(), "getPdfEMAWB");
		}

	}
}
