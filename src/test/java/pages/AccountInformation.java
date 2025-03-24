package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.ExcelUtils;
import utils.WebDriverUtils;

public class AccountInformation {

	public static WebDriver localdriver;
	public static WebDriverUtils webdriver;

	public AccountInformation(WebDriver driver) {
		localdriver = driver;
		PageFactory.initElements(localdriver, this);
		webdriver = new WebDriverUtils();
	}
	
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement gender;
	
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy(id="years")
	WebElement years;
	
	@FindBy(id="password")
	WebElement pass;
	
	@FindBy(id="first_name")
	WebElement first;
	
	@FindBy(id="last_name")
	WebElement last;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement address;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="city")
	WebElement cityy;
	
	@FindBy(id="zipcode")
	WebElement zip;
	
	@FindBy(id="mobile_number")
	WebElement mobilenumber;
	
	@FindBy(xpath="(//*[@class='btn btn-default'])[1]")
	WebElement button;
	
	public void validateTheFields() throws Throwable {
		
		
		Assert.assertTrue(gender.isDisplayed(),"Gender is not displayed");
		
		Assert.assertTrue(days.isDisplayed(), "days is not displayed");
		
		Assert.assertTrue(months.isDisplayed(), "months is not displayed");
		
		Assert.assertTrue(years.isDisplayed(), "years is not displayed");
		
		WebDriverUtils.captureScreenShot("fieldvalidation");
	}

	public void fillTheForm() throws Throwable {
        
		ExcelUtils excel = new ExcelUtils();
		XSSFSheet sheet=excel.readSheet("userdetails");
		
		gender.click();
		
		webdriver.selectTheDropdownUsingVisibleText(days,"5");
		
		webdriver.selectTheDropdownUsingvalue(months, "9");
		
		webdriver.selectTheDropdownUsingvalue(years, "2008");

		pass.sendKeys(excel.readData(sheet,0,0));

		first.sendKeys(excel.readData(sheet,1,0));
	
		last.sendKeys(excel.readData(sheet,2,0));
		
		company.sendKeys(excel.readData(sheet,3,0));

		address.sendKeys(excel.readData(sheet,4,0));

		Select s3 = new Select(country);
		s3.selectByVisibleText(excel.readData(sheet,9,0));
		
		state.sendKeys(excel.readData(sheet,5,0));
		
		cityy.sendKeys(excel.readData(sheet,6,0));
				
		zip.sendKeys(excel.readData(sheet, 7, 0));

		mobilenumber.sendKeys(excel.readData(sheet, 8, 0));
		
		WebDriverUtils.captureScreenShot("dataEntry");
	}
	 
	public void clickOnCreateAcc() throws Throwable {

		button.click();
        WebDriverUtils.captureScreenShot("formsubmission");
	}
}
