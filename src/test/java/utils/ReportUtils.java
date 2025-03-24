package utils;

import java.util.Base64;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import tests.Baseclass;

public class ReportUtils extends Baseclass {
	
	
	@Test
       public void generateReports(String Pathname,String testname){
    	   
    	   sparkReport = new ExtentSparkReporter(Pathname+"/demo.html");
    	   report = new ExtentReports();	
    	   report.attachReporter(sparkReport);
    	   
    	   test = report.createTest(testname);
    	   //test.log(Status.PASS, "Test executed successfully");
    	   
    	  
       }
}
 