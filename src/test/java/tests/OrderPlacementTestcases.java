package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.CartsPage;
import pages.ProductsPage;

public class OrderPlacementTestcases extends Baseclass{

	
@Test
	public void placeOrder() {
	ProductsPage pg = new ProductsPage(Baseclass.driver);
	CartsPage cp = new CartsPage(Baseclass.driver);
		try {
			
			pg.navigateToProducts();
			test.log(Status.PASS,"Navigated to the products page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			test.log(Status.FAIL, "Products page cannot be reached");
		}	
		
		
		try {
			pg.tshirt();
			test.log(Status.PASS,"Tshirt is selected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			test.log(Status.FAIL, "Tshirt is not selected");
		}
	
		try {
			cp.addToCart();
			test.log(Status.PASS, "Product is added to the carts");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			test.log(Status.FAIL, "Product is not added to the carts");
		}
		
		try {
			cp.continueshopping();
		    test.log(Status.PASS, "Continue Shopping button is clicked");
		} catch (Exception e) {
		      System.out.println(e.getMessage());
		      test.log(Status.FAIL, "Continue shopping button is not clicked");
		}
		
		
		
		
	}
    
     
        

    
}
