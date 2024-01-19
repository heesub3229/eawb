package com.aact.eAWB.AppConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Log {

	@Value("${log.path}")
	private String logFilePath;
	
	private SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
	
	private static final Logger logger = Logger.getLogger(Log.class.getName());
	
	 public void logTemp(String msg, String type) {
	        try {
	            File logDirectory = new File(logFilePath + format1.format(new Date()).substring(0, 8));
	            if (!logDirectory.exists()) {
	                logDirectory.mkdirs();
	            }

	            File logFile = new File(logDirectory.getPath() + File.separator + type + format1.format(new Date()) + ".txt");

	            // 파일이 존재하지 않으면 핸들러 추가
	            if (!logFile.exists()) {
	                FileHandler fileHandler = new FileHandler(logFile.getPath(), true);
	                fileHandler.setFormatter(new SimpleFormatter());

	                // Logger에 FileHandler 추가
	                logger.addHandler(fileHandler);
	                logger.setLevel(Level.ALL);
	            }

	            // 로그 기록
	            logger.info(msg);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
