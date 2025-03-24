package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.WebDriverUtils;

public class CartsPage {
    
	public static WebDriver driver;
	public static WebDriverUtils webdriver;
	
	public CartsPage(WebDriver ldriver) {
		driver= ldriver;
		PageFactory.initElements(driver,this);
	}
	
@FindBy(xpath= "//*[@class='btn btn-default cart']")
WebElement cart;

@FindBy(xpath = "//*[@class='btn btn-success close-modal btn-block']")
WebElement continuebtn;

	public void addToCart() {
		try {
			cart.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			Assert.fail();
		}		
	}
	
	public void continueshopping() {
		
		try {
			continuebtn.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
