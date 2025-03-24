package tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.PropertyUtility;
import utils.ReportUtils;

public class Baseclass {

	public static WebDriver driver;
    public static Properties prop;
	public static ExtentSparkReporter sparkReport;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeSuite
	public void setup() throws Throwable {
		System.out.println("****************STARTING SETUP**********************");
		driver = new ChromeDriver();
		new PropertyUtility();
		ReportUtils r = new ReportUtils();
		r.generateReports(prop.getProperty("filepath"),prop.getProperty("testtype"));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterSuite
	public void teardown() {
		report.flush();
		driver.quit();
		System.out.println("***************EXECUTION ENDS************************");
	}
}
