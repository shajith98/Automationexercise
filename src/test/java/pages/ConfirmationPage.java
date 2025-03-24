package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
 
	    public static WebDriver driver;
	    
	    public ConfirmationPage(WebDriver ldriver) {
	    	driver =ldriver ;
	    	PageFactory.initElements(driver,this);
	    }

		@FindBy(xpath="//b[text()='Account Created!']")	
		WebElement verifyacc;
		
		@FindBy(xpath="//a[text()='Continue']")	
		WebElement continuebtn;
		
	public void verifyAccountCreation() {
	     
	     if(verifyacc.isDisplayed()) {
	           System.out.println("Account has been created successfully");
	     }
	}
	
	public void clickOnContinue() {
		continuebtn.click();
	}
}
