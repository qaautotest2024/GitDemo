package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;


public class ErrorValidations extends BaseTest{
	
	
	@Test(groups= {"ErrorHandling"}, retryAnalyzer=rahulshettyacademy.TestComponents.Retry.class)
	public void LoginErrorValidation() throws InterruptedException, IOException
	{
	String productName ="ZARA COAT 3";
	LandingPage landingPage = new LandingPage(driver);
	ProductCatalogue productCatalogue =landingPage.loginApplication("shetty@gmail.com", "Iamking@000");
	Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());	
	System.out.println("2024 new upgrade");
	System.out.println("new develop branch codes");
	System.out.println("new develop branch codes part2");
	System.out.println("america");
	System.out.println("america8787");
	System.out.println("america2022609");

}
	
	@Test
	public void ProductErrorValidation() throws InterruptedException, IOException
	{
	String productName ="ZARA COAT 3";
	LandingPage landingPage = new LandingPage(driver);
	ProductCatalogue productCatalogue =landingPage.loginApplication("anshika@gmail.com", "Iamking@00");
	List<WebElement> products =productCatalogue.getProductList1();
	productCatalogue.addProductToCart(productName);
	CartPage cartPage =productCatalogue.goToCartPage();		
	Boolean match =cartPage.VerifyProductDisplay("ZARA COAT 33");
	Assert.assertFalse(match);
	
}
}





