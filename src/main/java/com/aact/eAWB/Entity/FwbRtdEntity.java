package com.aact.eAWB.Entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "TWM_FWB_RTD_INFO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FwbRtdEntity {
	
	@EmbeddedId
	private FwbSphEntityId id;
	@Column(name="NO_OF_PIECES")
	private BigInteger numberOfPieces;
	@Column(name="WEIGHT_CODE")
	private String weightCode;
	@Column(name="WEIGHT")
	private BigDecimal weight;
	@Column(name="RATE_CLASS_CODE")
	private String rateClassCode;
	@Column(name="COMMODITY_ITEM_NO_DETAILS")
	private String commodityItemNoDetails;
	@Column(name="CHARGEABLE_WEIGHT_DETAILS")
	private BigDecimal chargeableWeightDetails;
	@Column(name="RATE_CHARGE_DETAILS")
	private BigDecimal rateChargeDetails;
	@Column(name="TOTAL_DETAILS")
	private BigDecimal totalDetails;
	@Column(name="GOODS_DESCRIPTION")
	private String goodsDescription;
	@Column(name="CONSOLIDATION")
	private String consolidation;
	@Column(name="DIM_WEIGHT_CODE")
	private String dimWeightCode;
	@Column(name="DIM_WEIGHT")
	private BigDecimal dimWeight;
	@Column(name="DIM_MEASUREMENT_UNIT_CODE")
	private String dimMeasurementUnitCode;
	@Column(name="DIM_LENGTH")
	private BigInteger dimLength;
	@Column(name="DIM_WIDTH")
	private BigInteger dimWidth;
	@Column(name="DIM_HEIGHT")
	private BigInteger dimHeight;
	@Column(name="DIM_NO_OF_PACKAGE")
	private BigInteger dimNumberOfPackages;
	@Column(name="VOLUME_CODE")
	private String volumeCode;
	@Column(name="VOLUME_AMOUNT")
	private BigDecimal volumeAmount;
	@Column(name="ULD_TYPE_CODE")
	private String uldTypeCode;
	@Column(name="ULD_SERIAL_NO")
	private String uldSerialNo;
	@Column(name="ULD_OWNER_CODE")
	private String uldOwnerCode;
	@Column(name="SHIPPERS_LOAD_AND_COUNT")
	private String shippersLoadAndCount;
	@Column(name="HARMONISED_COMMODITY_CODE")
	private String harmonizedCommodityCode;
	@Column(name="COUNTRY_OF_ORIGIN_GOODS")
	private String countryOfOriginGoods;
	@Column(name="SERVICE_CODE_DETAILS")
	private String serviceCodeDetails;
	@Column(name="USABLE_FLAG")
	private String usableFlag;
	@Column(name="CREATED_USER_ID")
	private String createdUserId;
	@Column(name="CREATED_PROGRAM_ID")
	private String createdProgramId;
	@Column(name="CREATED_TIME")
	private Date createdTime;
	@Column(name="UPDATED_USER_ID")
	private String updatedUserId;
	@Column(name="UPDATED_PROGRAM_ID")
	private String updatedProgramId;
	@Column(name="UPDATED_TIME")
	private Date updatedTime;
	@Column(name="PROGRESS_GUID")
	private String progressGuid;
	@Column(name="PROCESS_GUID")
	private String processGuid;

}
