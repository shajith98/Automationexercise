package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.AcceptPendingException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.AccountInformation;
import pages.ConfirmationPage;
import pages.SignUpPage;

public class SignUpTestCase extends Baseclass {

	public static WebDriver driver;

	@Test
	public void signup() throws Throwable {
		SignUpPage sp = new SignUpPage(Baseclass.driver);
		

		try {
			sp.enterSignUpDetails(prop.getProperty("username"), prop.getProperty("email"));
			sp.clickOnSignUpButton(); 	
			
			if (sp.isErrorMessageDisplayed()) {
				test.log(Status.FAIL, "Signup Failed: Duplicate email error message displayed");
				Assert.fail("Test Failed: Duplicate email error message displayed!"); // Assert handled here
			} else {
				test.log(Status.PASS, "Signup successful");
			}
		}
		    catch (Exception e) {
		    	test.log(Status.FAIL, "Sign Up Failed");

		}

		try {
			AccountInformation ac = new AccountInformation(Baseclass.driver);
			ac.validateTheFields();
			ac.fillTheForm();
			ac.clickOnCreateAcc();
			test.log(Status.PASS, "Account Information page is completed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Account Information Page is Failed");
		}

		try {
			ConfirmationPage cp = new ConfirmationPage(Baseclass.driver);
			cp.verifyAccountCreation();
			cp.clickOnContinue();
			test.log(Status.PASS, "Confirmation Page Completed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Confirmation Page Failed");
		}

	}

}
