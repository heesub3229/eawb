package com.aact.eAWB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import com.aact.eAWB.Service.ScheduleService;

@SpringBootApplication
public class EAwbApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EAwbApplication.class, args);
	}

}
