package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
	   this.driver=driver;	
	   PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css ="[placeholder='Select Country']")
	WebElement country;	
	
	@FindBy(css =".action__submit")
	WebElement submit;	
	
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement SelectCountry;
	
	By results = By.cssSelector(".ta-results");
	

	
	
	public void selectCountry(String countryName) throws InterruptedException
	{
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));	
		Thread.sleep(2000);
		SelectCountry.click();
	
	}
	
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
		
		return new ConfirmationPage(driver);
	}
	
	
			
	

}
