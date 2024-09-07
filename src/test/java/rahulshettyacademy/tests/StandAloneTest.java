package rahulshettyacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class StandAloneTest extends BaseTest {
	
		// TODO Auto-generated method stub
	String productName ="ZARA COAT 3";
	
		@Test(dataProvider="getData", groups= {"Purchase"})
		public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException
		{
				
		LandingPage landingPage =launchApplication();
		ProductCatalogue productCatalogue =landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products =productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage =productCatalogue.goToCartPage();	
		
		Boolean match =cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();	
		checkoutPage.selectCountry("india");
		
		ConfirmationPage confirmationPage =checkoutPage.submitOrder();
		String confirmMessage =	confirmationPage.getCofirmationMessage();
		 
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
				

	}
		@Test(dependsOnMethods= {"submitOrder"})
		public void OrderHistoryTest()
		{
			LandingPage landingPage = new LandingPage(driver);
			ProductCatalogue productCatalogue =landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
			OrderPage ordersPage =productCatalogue.goToOrdersPage();
			Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
		}
		
	
		
		@DataProvider
		public Object[][] getData() throws IOException
		{

			List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)} };
			
//			//return new Object[] []   {{data.get(0)},{data.get(1)}  };
			
		}
	
	
	}

