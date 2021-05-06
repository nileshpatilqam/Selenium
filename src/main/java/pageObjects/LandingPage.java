package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	
	public LandingPage(WebDriver driver) {
		//generate constructor stub
		this.driver= driver;
	}
	
	public WebElement getSignin()
	{
		return driver.findElement(signin);
	}

	
	
}
