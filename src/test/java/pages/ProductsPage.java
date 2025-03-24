package pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.WebDriverUtils;

public class ProductsPage {
   public static WebDriver driver;
   public static WebDriverUtils webdriver;
   
   public  ProductsPage(WebDriver ldriver) {
	driver = ldriver;
	PageFactory.initElements(driver, this);
}
   
 @FindBy(xpath = "//*[@class='material-icons card_travel']")
 WebElement products;
 
 @FindBy(xpath = "//*[@href='/product_details/2']")
 WebElement tshirt;
  
 public void tests() {
	 System.out.println("Add the products");
 }
   public void navigateToProducts() {
	   
	try {
		products.click();
	} catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
	}
   }
   
   public void tshirt() {
	   try {
		tshirt.click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		Assert.fail();
	}
   }
   
   
}
