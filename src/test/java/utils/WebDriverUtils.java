package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.Baseclass;

public class WebDriverUtils extends Baseclass{

	public void selectTheDropdownUsingVisibleText(WebElement element , String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void selectTheDropdownUsingvalue(WebElement element , String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}	
	
	public void selectTheDropdownUsingIndex(WebElement element , int index) {
		Select s = new Select(element);
		s.selectByIndex(index);	
	}
	
	public void waitUntilSpecificElementisDisplayed(WebElement targetele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(targetele));
	}
	
	public static void captureScreenShot(String name) throws IOException {

		TakesScreenshot tk = (TakesScreenshot) driver; // Typecasting to convert the Higher datatype to the
														// Lowerdatatype
		File screenshotAs = tk.getScreenshotAs(OutputType.FILE);
		File destination = new File("src/test/resources/output" + name + ".png");
		FileUtils.copyFile(screenshotAs, destination);
	} 
	//iframe
	
	//window handling
	
	//alert
	
	//robot
	
	//explicit wait 
	
	//actions
}
