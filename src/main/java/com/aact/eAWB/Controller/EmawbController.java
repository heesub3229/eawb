package com.aact.eAWB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aact.eAWB.Service.EMawbService;

@RestController
@RequestMapping("eawb")
public class EmawbController {
	
	@Autowired
	EMawbService eMawbService;
	
	@GetMapping("mawb")
	public void test(@RequestParam("bl")String mawb) {
		eMawbService.getPdfEMAWB(mawb);
	}
}
