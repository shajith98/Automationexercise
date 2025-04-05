package pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LogOutPage {
	public static WebDriver driver;

	public LogOutPage(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Logout")
	WebElement logout;

	public void logoutbutton() {
		try {
			logout.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
