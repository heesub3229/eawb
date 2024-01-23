package com.aact.eAWB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aact.eAWB.AppConfig.Log;

@Service
public class UtilService {

	@Autowired
	Log log;
	
	//null값 걸러내기
	public String nullString(String data) {
		
		String ret = "";
		if(data==null) {
			
		}else {
			ret = data;
		}
		
		return ret;
	}
}
