package pages;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignUpPage {

	public static WebDriver localdriver;	

	public SignUpPage(WebDriver driver) {
		localdriver = driver;
		PageFactory.initElements(localdriver, this);
	}

	@FindBy(name = "name")
	WebElement name;

	@FindBy(xpath = "(//*[@placeholder='Email Address'])[2]")
	WebElement email;

	@FindBy(xpath = "//*[text()='Signup']")
	WebElement button;

	@FindBy(xpath= "//*[text()='Email Address already exist!']")
	WebElement errormessage;
	
	public void enterSignUpDetails(String Uname, String pwd) {
		try {
			name.sendKeys(Uname);
			email.sendKeys(pwd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}

	}

	public void clickOnSignUpButton() {
		
			try {
				button.click();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
			
		} 
	public boolean isErrorMessageDisplayed() {
	    try {
	        WebDriverWait wait = new WebDriverWait(localdriver, Duration.ofSeconds(5));
	        return wait.until(ExpectedConditions.visibilityOf(errormessage)).isDisplayed();
	    } catch (Exception e) {
	        return false; }// Error message did not appear within 5 seconds
	}
	
    public String getErrorMessageText() {
        return errormessage.getText();
    }

	}


