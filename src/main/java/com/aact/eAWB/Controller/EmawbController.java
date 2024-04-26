package com.aact.eAWB.Controller;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.aact.eAWB.AppConfig.JwtUtil;
import com.aact.eAWB.AppConfig.Log;
import com.aact.eAWB.Dto.CarrierDto;
import com.aact.eAWB.Dto.CodeDto;
import com.aact.eAWB.Dto.FlightSchDTO;
import com.aact.eAWB.Dto.GetSettleSelCalcDTO;
import com.aact.eAWB.Dto.InqueryPdfDTO;
import com.aact.eAWB.Dto.JwtResponseDTO;
import com.aact.eAWB.Dto.RateDto;
import com.aact.eAWB.Dto.ResponseDTO;
import com.aact.eAWB.Dto.TraceResult2DTO;
import com.aact.eAWB.FhlEntity.FhlEntityId;
import com.aact.eAWB.FhlEntity.HbsEntity;
import com.aact.eAWB.MainEntity.CargoMasterEntity;
import com.aact.eAWB.Service.EMawbService;
import com.aact.eAWB.Service.FhlEMawbService;
import com.aact.eAWB.Service.InqueryService;
import com.aact.eAWB.Service.ScheduleService;
import com.aact.eAWB.Service.TraceService;
import com.aact.eAWB.Service.UtilService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("eawb")
public class EmawbController {

	@Autowired
	EMawbService eMawbService;
	@Autowired
	FhlEMawbService fhlEMawbService;
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	InqueryService inqueryService;
	@Autowired
	TraceService traceService;
	
	@Autowired
	UtilService utilService;

	@Autowired
	Log log;
	
	@Autowired
	JwtUtil jwtUtil;

	
	@PostMapping("generateToken")
	public ResponseEntity<String> generateToken(@RequestParam("username") String username,HttpServletRequest request) {
	    String token = jwtUtil.generateToken(username);
	    
	    return ResponseEntity.ok(token);
	}
	

	@PostMapping("settleCal")
	public ResponseEntity<?> settleCal(@RequestBody GetSettleSelCalcDTO dto,HttpServletRequest request) {
		try {
			  JwtResponseDTO validate = jwtUtil.validateToken(request);
				if(validate.getFlag()) {
					ResponseDTO<?> ret = inqueryService.calcSet(dto);
					return new ResponseEntity<>(ret,HttpStatus.OK);
				}else {
					ResponseDTO<String> dtos = utilService.setResponseData(validate.getFlag(), validate.getData());
					
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos.getData().get(0));
				}
			
		}catch (Exception e) {
			// TODO: handle exception
			log.logTemp(e.getMessage(), "settleCal");
			ResponseDTO<String> dtos = ResponseDTO.<String>builder()
					.error("ERROR : " + e.getMessage()).build();
			return ResponseEntity.badRequest().body(dtos);
		}
	}
	
	@GetMapping("rate")
	public ResponseEntity<?> getRate(HttpServletRequest request,@RequestParam("inDate")String inDate,@RequestParam("outDate")String outDate,@RequestParam("rate")String rate) {
		try {
			 JwtResponseDTO validate = jwtUtil.validateToken(request);
				if(validate.getFlag()) {
					RateDto dto = inqueryService.rateSet(inDate, outDate, rate);
					return new ResponseEntity<>(dto, HttpStatus.OK);
				}else {
					ResponseDTO<String> dtos = utilService.setResponseData(validate.getFlag(), validate.getData());
					
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos.getData().get(0));
				}
			
		}catch (Exception e) {
			// TODO: handle exception
			log.logTemp(e.getMessage(), "getRate");
			ResponseDTO<String> dtos = ResponseDTO.<String>builder()
					.error("ERROR : " + e.getMessage()).build();
			return ResponseEntity.badRequest().body(dtos);
		}
	}
	
	@GetMapping("cmbRate")
	public ResponseEntity<?> getCmbRate(HttpServletRequest request){
		try {
			JwtResponseDTO validate = jwtUtil.validateToken(request);
			if(validate.getFlag()) {
				List<CodeDto> dto = inqueryService.getCmbRateType();
				
				return new ResponseEntity<>(dto, HttpStatus.OK);
			}else {
				ResponseDTO<String> dtos = utilService.setResponseData(validate.getFlag(), validate.getData());
				
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos.getData().get(0));
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			log.logTemp(e.getMessage(), "cmbRate");
			ResponseDTO<String> dtos = ResponseDTO.<String>builder()
					.error("ERROR : " + e.getMessage()).build();
			return ResponseEntity.badRequest().body(dtos);
		}
	}
	
	@GetMapping("mawb")
	public ResponseEntity<?> getPdfMAWB(@RequestParam("bl") String mawb,HttpServletRequest request) {
		try {
			JwtResponseDTO validate = jwtUtil.validateToken(request);
			if(validate.getFlag()) {
				byte[] pdfByte = eMawbService.getPdfEMAWB(mawb);
				String yyyymmddHHmmssfff = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
	
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_PDF);
				headers.setContentDispositionFormData("inline", yyyymmddHHmmssfff + "MAWB.pdf");
	
				return new ResponseEntity<>(pdfByte, headers, HttpStatus.OK);
			}else {
				ResponseDTO<String> dtos = utilService.setResponseData(validate.getFlag(), validate.getData());
				
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos.getData().get(0));
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.logTemp(e.getMessage(), "getPdfEMAWB");
			ResponseDTO<String> dtos = ResponseDTO.<String>builder()
					.error("MAWB : " + mawb + " ERROR : " + e.getMessage()).build();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos.getError());
		}

	}
	
	@GetMapping("getfhl")
	public ResponseEntity<?> getPdfFhl(@RequestParam("mawb")String mawb,@RequestParam("hawb")String hawb,HttpServletRequest request) {
		try {
			JwtResponseDTO validate = jwtUtil.validateToken(request);
			if(validate.getFlag()) {
				byte[] pdfByte = fhlEMawbService.getFhlMain(mawb,hawb);
				String yyyymmddHHmmssfff = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
	
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_PDF);
				headers.setContentDispositionFormData("inline", yyyymmddHHmmssfff + "MAWB.pdf");
	
				return new ResponseEntity<>(pdfByte, headers, HttpStatus.OK);
			}else {
				ResponseDTO<String> dtos = utilService.setResponseData(validate.getFlag(), validate.getData());
				
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos.getData().get(0));
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.logTemp(e.getMessage(), "getPdfFhl");
			ResponseDTO<String> dtos = ResponseDTO.<String>builder()
					.error(e.getMessage()).build();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos.getError());
		}

	}
	
	@GetMapping("getsch")
	public ResponseEntity<?> getSch(@RequestParam("inoutFlag")String inoutFlag,@RequestParam("carrierCode")String carrierCode,
			@RequestParam("fltDate")String fltDate,HttpServletRequest request) {
		
		try {
			
			  JwtResponseDTO validate = jwtUtil.validateToken(request);
				if(validate.getFlag()) {
					List<FlightSchDTO> dtos = scheduleService.getSch(inoutFlag,fltDate, carrierCode);
					return new ResponseEntity<>(dtos,HttpStatus.OK);
				}else {
					ResponseDTO<String> dtos = utilService.setResponseData(validate.getFlag(), validate.getData());
					
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos.getData().get(0));
				}
			
		}catch (Exception e) {
			// TODO: handle exception
			log.logTemp(e.getMessage(), "getSch");
			ResponseDTO<String> dto = ResponseDTO.<String>builder()
					.error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(dto);
		}
		
	}
	
	@GetMapping("getCarrier")
	public ResponseEntity<?> getCarrierCode(HttpServletRequest request){
		try {
			JwtResponseDTO validate = jwtUtil.validateToken(request);
			if(validate.getFlag()) {
				List<CarrierDto> dtos = scheduleService.getCarrierCode();
				
				return new ResponseEntity<>(dtos,HttpStatus.OK);
			}else {
				ResponseDTO<String> dtos = utilService.setResponseData(validate.getFlag(), validate.getData());
				
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			log.logTemp(e.getMessage(), "getCarrierCode");
			ResponseDTO<String> dto = ResponseDTO.<String>builder()
					.error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(dto);
		}
	}
	
	@PostMapping("getInquery")
	public ResponseEntity<?> getPdfInquery(@RequestBody InqueryPdfDTO dto,HttpServletRequest request){
		try {
			 JwtResponseDTO validate = jwtUtil.validateToken(request);
				if(validate.getFlag()) {
					byte[] pdfByte = inqueryService.getpdfInquery(dto);
					String yyyymmddHHmmssfff = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_PDF);
					headers.setContentDispositionFormData("inline", yyyymmddHHmmssfff + "Inquery.pdf");
					return new ResponseEntity<>(pdfByte, headers, HttpStatus.OK);
				}else {
					ResponseDTO<String> dtos = utilService.setResponseData(validate.getFlag(), validate.getData());
					
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos.getData().get(0));
				}
			
		}catch (Exception e) {
			// TODO: handle exception
			ResponseDTO<String> dtos = ResponseDTO.<String>builder()
					.error(" ERROR : " + e.getMessage()).build();
			return ResponseEntity.badRequest().body(dtos);
		}
	}
	
	@GetMapping("getTraceList")
	public ResponseEntity<?> getCargoTraceList(@RequestParam("bl")String bl,HttpServletRequest request){
		try {
			JwtResponseDTO validate = jwtUtil.validateToken(request);
			if(validate.getFlag()) {
				ResponseDTO<CargoMasterEntity> dto = new ResponseDTO<CargoMasterEntity>();
				List<CargoMasterEntity> entities = traceService.getCargoTraceList(bl.toUpperCase());
				if(entities.size()>0) {
					dto.setError("N");
					dto.setData(entities);
					return new ResponseEntity<>(dto,HttpStatus.OK);
				}else {
					ResponseDTO<String> dtos = utilService.setResponseData(false, "B/L정보가 없습니다.");
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos.getData().get(0));
				}
			}else {
				ResponseDTO<String> dtos = utilService.setResponseData(validate.getFlag(), validate.getData());
				
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos.getData().get(0));
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			ResponseDTO<String> dtos = ResponseDTO.<String>builder()
					.error(" ERROR : " + e.getMessage()).build();
			return ResponseEntity.badRequest().body(dtos);
		}
	}
	
	@GetMapping("getStatusLog")
	public ResponseEntity<?> getStatusLog(@RequestParam("cargoSid")BigInteger cargoSid,HttpServletRequest request) {
		try {
			JwtResponseDTO validate = jwtUtil.validateToken(request);
			if(validate.getFlag()) {
				ResponseDTO<TraceResult2DTO> dto = new ResponseDTO<TraceResult2DTO>();
				TraceResult2DTO entities = traceService.getStatusLog(cargoSid);
				List<TraceResult2DTO> entitiesArray = new ArrayList<TraceResult2DTO>();
				entitiesArray.add(entities);
				
				dto.setError("N");
				dto.setData(entitiesArray);
				return new ResponseEntity<>(dto,HttpStatus.OK);
			}else {
				ResponseDTO<String> dtos = utilService.setResponseData(validate.getFlag(), validate.getData());
				
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dtos.getData().get(0));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			ResponseDTO<String> dtos = ResponseDTO.<String>builder()
					.error(" ERROR : " + e.getMessage()).build();
			return ResponseEntity.badRequest().body(dtos);
		}
	}
	
}
