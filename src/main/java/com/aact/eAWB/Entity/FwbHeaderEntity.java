package com.aact.eAWB.Entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TWM_FWB_HEADER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FwbHeaderEntity {

	@Id
	@Column(name="MASTER_AIR_WAY_BILL_SID")
	private BigInteger masterAirWayBillSid;
	@Column(name="AIRLINE_PREFIX")
	private String airlinePrefix;
	@Column(name="AWB_SERIAL_NUMBER")
	private String awbSerialNumber;
	@Column(name="ORIGIN_CODE")
	private String originCode;
	@Column(name="DESTINATION_CODE")
	private String destinationCode;
	@Column(name="SHIPMENT_DESCRIPTION_CODE")
	private String shipmentDescriptionCode;
	@Column(name="NO_OF_PIECES")
	private BigInteger numberOfPieces;
	@Column(name="WEIGHT_CODE")
	private String weightCode;
	@Column(name="WEIGHT")
	private BigDecimal weight;
	@Column(name="VOLUME_CODE")
	private String volumeCode;
	@Column(name="VOLUME_AMOUNT")
	private BigDecimal volumeAmount;
	@Column(name="DENSITY_GROUP_CODE")
	private String densityGroupCode;
	@Column(name="SCHEDULE_SID")
	private BigInteger scheduleSid;
	@Column(name="CONSOL_FLAG")
	private String consolFlag;
	@Column(name="FLT_CARRIER_CODE")
	private String flightCarrierCode;
	@Column(name="FLT_FLIGHT_NUMBER")
	private String flightNumber;
	@Column(name="FLT_FLIGHT_DAY")
	private String flightDay;
	@Column(name="RTG_FIRST_DESTINATION")
	private String routingFirstDestination;
	@Column(name="RTG_FIRST_CARRIER_CODE")
	private String routingFirstCarrierCode;
	@Column(name="RTG_ONWARD_DESTINATION1")
	private String routingOnwardDestination1;
	@Column(name="RTG_ONWARD_CARRIER1_CODE")
	private String routingOnwardCarrier1Code;
	@Column(name="RTG_ONWARD_DESTINATION2")
	private String routingOnwardDestination2;
	@Column(name="RTG_ONWARD_CARRIER2_CODE")
	private String routingOnwardCarrier2Code;
	@Column(name="SHP_ACCOUNT_NO")
	private String shipperAccountNumber;
	@Column(name="SHP_COMPANY_NAME1")
	private String shipperCompanyName1;
	@Column(name="SHP_COMPANY_NAME2")
	private String shipperCompanyName2;
	@Column(name="SHP_STREET_ADDRESS1")
	private String shipperStreetAddress1;
	@Column(name="SHP_STREET_ADDRESS2")
	private String shipperStreetAddress2;
	@Column(name="SHP_PLACE_NAME")
	private String shipperPlaceName;
	@Column(name="SHP_STATE_PROVINCE_NAME")
	private String shipperStateProvinceName;
	@Column(name="SHP_COUNTRY_CODE")
	private String shipperCountryCode;
	@Column(name="SHP_POST_CODE")
	private String shipperPostCode;
	@Column(name="SHP_PHONE_NO")
	private String shipperPhoneNo;
	@Column(name="SHP_FAX_NO")
	private String shipperFaxNo;
	@Column(name="SHP_TELEX_NO")
	private String shipperTelexNo;
	@Column(name="CNE_ACCOUNT_NO")
	private String consigneeAccountNumber;
	@Column(name="CNE_COMPANY_NAME1")
	private String consigneeCompanyName1;
	@Column(name="CNE_COMPANY_NAME2")
	private String consigneeCompanyName2;
	@Column(name="CNE_STREET_ADDRESS1")
	private String consigneeStreetAddress1;
	@Column(name="CNE_STREET_ADDRESS2")
	private String consigneeStreetAddress2;
	@Column(name="CNE_PLACE_NAME")
	private String consigneePlaceName;
	@Column(name="CNE_STATE_PROVINCE_NAME")
	private String consigneeStateProvinceName;
	@Column(name="CNE_COUNTRY_CODE")
	private String consigneeCountryCode;
	@Column(name="CNE_POST_CODE")
	private String consigneePostCode;
	@Column(name="CNE_PHONE_NO")
	private String consigneePhoneNo;
	@Column(name="CNE_FAX_NO")
	private String consigneeFaxNo;
	@Column(name="CNE_TELEX_NO")
	private String consigneeTelexNo;
	@Column(name="AGT_CUSTOMER_CODE")
	private String agentCustomerCode;
	@Column(name="AGT_ACCOUNT_NO")
	private String agentAccountNo;
	@Column(name="AGT_IATA_CODE")
	private String agentIataCode;
	@Column(name="AGT_CASS_ADDRESS")
	private String agentCassAddress;
	@Column(name="AGT_PARTICIPANT_ID")
	private String agentParticipantId;
	@Column(name="AGT_COMPANY_NAME")
	private String agentCompanyName;
	@Column(name="AGT_PLACE_NAME")
	private String agentPlaceName;
	@Column(name="SSR_SERVICE_REQUEST1")
	private String ssrServiceRequest1;
	@Column(name="SSR_SERVICE_REQUEST2")
	private String ssrServiceRequest2;
	@Column(name="SSR_SERVICE_REQUEST3")
	private String ssrServiceRequest3;
	@Column(name="NFY_COMPANY_NAME1")
	private String notifyCompanyName1;
	@Column(name="NFY_COMPANY_NAME2")
	private String notifyCompanyName2;
	@Column(name="NFY_STREET_ADDRESS1")
	private String notifyStreetAddress1;
	@Column(name="NFY_STREET_ADDRESS2")
	private String notifyStreetAddress2;
	@Column(name="NFY_PLACE_NAME")
	private String notifyPlaceName;
	@Column(name="NFY_STATE_PROVINCE_NAME")
	private String notifyStateProvinceName;
	@Column(name="NFY_COUNTRY_CODE")
	private String notifyCountryCode;
	@Column(name="NFY_POST_CODE")
	private String notifyPostCode;
	@Column(name="NFY_PHONE_NO")
	private String notifyPhoneNo;
	@Column(name="NFY_FAX_NO")
	private String notifyFaxNo;
	@Column(name="NFY_TELEX_NO")
	private String notifyTelexNo;
	@Column(name="CVD_CURRENCY_CODE")
	private String cvdCurrencyCode;
	@Column(name="CVD_CHARGE_CODE")
	private String cvdChargeCode;
	@Column(name="CVD_PC_IND_WEIGHT")
	private String cvdPcIndWeight;
	@Column(name="CVD_PC_IND_OTHER")
	private String cvdPcIndOther;
	@Column(name="CVD_DECLARED_CARRIAGE")
	private BigDecimal cvdDeclaredCarriage;
	@Column(name="CVD_DECLARED_CUSTOMS")
	private BigDecimal cvdDeclaredCustoms;
	@Column(name="CVD_DECLARED_INSURANCE")
	private BigDecimal cvdDeclaredInsurance;
	@Column(name="OTH_PC_IND_OTHER")
	private String othPcIndOther;
	@Column(name="OTH_OTHER_CHARGE1_CODE")
	private String otherCharge1Code;
	@Column(name="OTH_ENTITLEMENT1_CODE")
	private String othEntitlement1Code;
	@Column(name="OTH_CHARGE1_AMOUNT")
	private String othCharge1Amount;
	@Column(name="OTH_OTHER_CHARGE2_CODE")
	private String othOtherCharge2Code;
	@Column(name="OTH_ENTITLEMENT2_CODE")
	private String othEntitlement2Code;
	@Column(name="OTH_CHARGE2_AMOUNT")
	private String othCharge2Amount;
	@Column(name="OTH_OTHER_CHARGE3_CODE")
	private String othOtherCharge3Code;
	@Column(name="OTH_ENTITLEMENT3_CODE")
	private String othEntitlement3Code;
	@Column(name="OTH_CHARGE3_AMOUNT")
	private String othCharge3Amount;
	@Column(name="PPD_WEIGHT_CHARGE")
	private BigDecimal prePaidWeightCharge;
	@Column(name="PPD_VALUATION_CHARGE")
	private BigDecimal prePaidValuationCharge;
	@Column(name="PPD_TAXES")
	private BigDecimal prePaidTaxes;
	@Column(name="PPD_OTHER_CHARGE_AGENT")
	private BigDecimal prePaidOtherChargeAgent;
	@Column(name="PPD_OTHER_CHARGE_CARRIER")
	private BigDecimal prePaidOtherChargeCarrier;
	@Column(name="PPD_TOTAL_CHARGE_SUMMARY")
	private BigDecimal prePaidTotalChargeSummary;
	@Column(name="COL_WEIGHT_CHARGE")
	private BigDecimal collectWeightCharge;
	@Column(name="COL_VALUATION_CHARGE")
	private BigDecimal collectValuationCharge;
	@Column(name="COL_TAXES")
	private BigDecimal collectTaxes;
	@Column(name="COL_OTHER_CHARGE_AGENT")
	private BigDecimal collectOtherChargeAgent;
	@Column(name="COL_OTHER_CHARGE_CARRIER")
	private BigDecimal collectOtherChargeCarrier;
	@Column(name="COL_TOTAL_CHARGE_SUMMARY")
	private BigDecimal collectTotalChargeSummary;
	@Column(name="CER_CERTIFICATION_SIGN")
	private String cerCertificationSign;
	@Column(name="ISU_AWB_ISSUE_DAY")
	private String isuAwbIssueDay;
	@Column(name="ISU_AWB_ISSUE_MONTH")
	private String isuAwbIssueMonth;
	@Column(name="ISU_AWB_ISSUE_YEAR")
	private String isuAwbIssueYear;
	@Column(name="ISU_AWB_ISSUE_PLACE_CODE")
	private String isuAwbIssuePlaceCode;
	@Column(name="ISU_AUTHORISATION_SIGN")
	private String isuAuthorizationSign;
	@Column(name="OSI_OTHER_INFORMATION1")
	private String osiOtherInformation1;
	@Column(name="OSI_OTHER_INFORMATION2")
	private String osiOtherInformation2;
	@Column(name="OSI_OTHER_INFORMATION3")
	private String osiOtherInformation3;
	@Column(name="CDC_DESTINATION_CURRENCY")
	private String cdcDestinationCurrency;
	@Column(name="CDC_RATE_OF_EXCHANGE")
	private BigDecimal cdcRateOfExchange;
	@Column(name="CDC_CC_CHARGE_AMOUNT")
	private BigDecimal cdcCcChargeAmount;
	@Column(name="CDC_CHARGES_AT_DESTINATION")
	private BigDecimal cdcChargesAtDestination;
	@Column(name="CDC_TOTAL_COLLECT_CHARGES")
	private BigDecimal cdcTotalCollectCharges;
	@Column(name="REF_SENDER_AIRPORT")
	private String refSenderAirportReference;
	@Column(name="REF_SENDER_FUNCTION")
	private String refSenderFunctionReference;
	@Column(name="REF_SENDER_COMPANY")
	private String refSenderCompanyReference;
	@Column(name="REF_FILE_REFERENCE")
	private String refFileReference;
	@Column(name="REF_PARTICIPANT_ID")
	private String refParticipantIdReference;
	@Column(name="REF_PARTICIPANT_CODE")
	private String refParticipantCodeReference;
	@Column(name="REF_PARTICIPANT_AIRPORT")
	private String refParticipantAirportReference;
	@Column(name="COR_CUSTOMS_ORIGIN_CODE")
	private String corCustomsOriginCode;
	@Column(name="COI_NO_COMMISSION_IND")
	private String coiNoCommissionIndicator;
	@Column(name="COI_COMMISSION_AMOUNT")
	private BigInteger coiCommissionAmount;
	@Column(name="COI_COMMISSION_PERCENTAGE")
	private BigInteger coiCommissionPercentage;
	@Column(name="SII_SALES_INCENTIVE_DETAIL")
	private BigDecimal siiSalesIncentiveDetail;
	@Column(name="SII_SALES_INCENTIVE_IND")
	private String siiSalesIncentiveIndicator;
	@Column(name="ARD_AGENT_FILE_REFERENCE")
	private String ardAgentFileReference;
	@Column(name="NOM_NOMINATED_PARTY_NAME")
	private String nomNominatedPartyName;
	@Column(name="NOM_NOMINATED_PLACE")
	private String nomNominatedPlace;
	@Column(name="SRI_SHIPMENT_REFERENCE_NO")
	private String sriShipmentReferenceNo;
	@Column(name="SRI_SHIPMENT_INFORMATION1")
	private String sriShipmentInformation1;
	@Column(name="SRI_SHIPMENT_INFORMATION2")
	private String sriShipmentInformation2;
	@Column(name="FWB_WORK_NO_OF_PACKAGE")
	private BigInteger fwbWorkNumberOfPackages;
	@Column(name="FWB_WORK_WEIGHT")
	private BigDecimal fwbWorkWeight;
	@Column(name="WORK_ULD_NO")
	private String workUldNumber;
	@Column(name="USABLE_FLAG")
	private String usableFlag;
	@Column(name="CREATED_USER_ID")
	private String createdUserId;
	@Column(name="CREATED_PROGRAM_ID")
	private String createdProgramId;
	@Column(name="CREATED_TIME")
	private String createdTime;
	@Column(name="UPDATED_USER_ID")
	private String updatedUserId;
	@Column(name="UPDATED_PROGRAM_ID")
	private String updatedProgramId;
	@Column(name="UPDATED_TIME")
	private String updatedTime;
	@Column(name="PROGRESS_GUID")
	private String progressGuid;
	@Column(name="PROCESS_GUID")
	private String processGuid;
	@Column(name="FLT_CARRIER_CODE2")
	private String fltFlightCarrierCode2;
	@Column(name="FLT_FLIGHT_NUMBER2")
	private String fltFlightNumber2;
	@Column(name="FLT_FLIGHT_DAY2")
	private String fltFlightDay2;
	@Column(name="FLT_CARRIER_CODE3")
	private String flightCarrierCode3;
	@Column(name="FLT_FLIGHT_NUMBER3")
	private String fltFlightNumber3;
	@Column(name="FLT_FLIGHT_DAY3")
	private String fltFlightDay3;
	@Column(name="OTH_OTHER_CHARGE4_CODE")
	private String othOtherCharge4Code;
	@Column(name="OTH_ENTITLEMENT4_CODE")
	private String othEntitlement4Code;
	@Column(name="OTH_CHARGE4_AMOUNT")
	private String othCharge4Amount;
	@Column(name="OTH_OTHER_CHARGE5_CODE")
	private String othOtherCharge5Code;
	@Column(name="OTH_ENTITLEMENT5_CODE")
	private String othEntitlement5Code;
	@Column(name="OTH_CHARGE5_AMOUNT")
	private String othCharge5Amount;
	@Column(name="OTH_OTHER_CHARGE6_CODE")
	private String othOtherCharge6Code;
	@Column(name="OTH_ENTITLEMENT6_CODE")
	private String othEntitlement6Code;
	@Column(name="OTH_CHARGE6_AMOUNT")
	private String othCharge6Amount;

}
