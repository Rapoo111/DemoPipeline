package com.bk_automation_testNG_prototype.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.bk_automation_testNG_prototype.helper.browserconfiguration.config.ObjectReader;
import com.bk_automation_testNG_prototype.helper.resource.ResourceHelper;

/**
 * 
 * @author Rishabh Jain
 *
 */
public class ExtentManager {

	private static ExtentReports extent;
	static DateFormat dateFormatFile = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	static Date date = new Date();
	static String TimeStamp = dateFormatFile.format(date);

	public static ExtentReports getInstance() {
		if (extent == null) {
			String location = ResourceHelper.getResourcePath("test-output/extent_report/BehaviorallyAutomationReport" + TimeStamp + ".html");
			return createInstance(location);
		} else {
			return extent;
		}
	}
	 
	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
		
		htmlReporter.viewConfigurer()
	    .viewOrder()
	    .as(new ViewName[] { 
		   ViewName.DASHBOARD, 
		   ViewName.TEST, 
		  
		   ViewName.EXCEPTION, 
		   ViewName.LOG 
		})
	  .apply();
		htmlReporter.config().setTheme(Theme.STANDARD);
	
		htmlReporter.config().setDocumentTitle("Pipeline Execution Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Pipeline Execution Report");
		extent = new ExtentReports();
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser", ObjectReader.reader.getBrowserType()+"");
		extent.setSystemInfo("Base URL", ObjectReader.reader.getUrl());
		extent.setSystemInfo("Environment", "Staging");
		extent.attachReporter(htmlReporter);
		return extent;
	}

}
