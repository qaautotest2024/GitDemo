package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	public OrderPage(WebDriver driver)
	{
	   super(driver);
	   this.driver=driver;	
	   PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//Pagefactory
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	
	
	
	public Boolean VerifyOrderDisplay(String productName) 
	{
		
		Boolean match = productNames.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		
		return match;
		
	}
	
	
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


