package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.LogOutPage;

public class LogOutTestCase extends Baseclass {

	
@Test
public void logout() {
	LogOutPage pg = new LogOutPage(Baseclass.driver);
	try {
		pg.logoutbutton();
		test.log(Status.PASS, "Logout successfull");
	} catch (Exception e) {
		System.out.println(e.getMessage());
		test.log(Status.FAIL, "Logout failed");
	}
	
	
}
}
