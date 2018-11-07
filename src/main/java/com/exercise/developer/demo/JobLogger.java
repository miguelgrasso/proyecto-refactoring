package com.exercise.developer.demo;


import java.io.File;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.exercise.developer.demo.logvalues.LogValues;
import com.exercise.developer.demo.service.LogValuesService;



public class JobLogger {
	private static boolean logToFile;
	private static boolean logToConsole;
	private static boolean logMessage;
	private static boolean logWarning;
	private static boolean logError;
	private static boolean logToDatabase;
	private static Logger logger;
	
	@Autowired
	LogValuesService logValuesService;
	
	public JobLogger(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam,
			boolean logMessageParam, boolean logWarningParam, boolean logErrorParam) {
		  
		logger = Logger.getLogger("MyLog");  
		logError = logErrorParam;
		logMessage = logMessageParam;
		logWarning = logWarningParam;
		logToDatabase = logToDatabaseParam;
		logToFile = logToFileParam;
		logToConsole = logToConsoleParam;
		
	}
	

	public void LogMessage(String messageText, boolean message, boolean warning, boolean error) throws Exception {
		messageText.trim();
		if (messageText == null || messageText.length() == 0) {
			return;
		}
		if (!logToConsole && !logToFile && !logToDatabase) {
			throw new Exception("Invalid configuration");
		}
		if ((!logError && !logMessage && !logWarning) || (!message && !warning && !error)) {
			throw new Exception("Error or Warning or Message must be specified");
		}

		int t = 0;
		if (message && logMessage) {
			t = 1;
		}

		if (error && logError) {
			t = 2;
		}

		if (warning && logWarning) {
			t = 3;
		}


		File logFile = new File("logFile.txt");
        if (!logFile.exists()) {
        	logFile.createNewFile();
        }
		
		FileHandler fh = new FileHandler("logFile.txt");
		ConsoleHandler ch = new ConsoleHandler();
		
		
		if(logToFile) {
			logger.addHandler(fh);
			logger.log(Level.SEVERE, messageText);
		}
		
		if(logToConsole) {
			logger.addHandler(ch);
			logger.log(Level.INFO, messageText);
		}
		
		if(logToDatabase) {
			LogValues logValues=new LogValues();
			logValues.setMessage(messageText);
			logValues.setType(t);
			logValuesService.saveOrUpdate(logValues);
		} 
	}
}
