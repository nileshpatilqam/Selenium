package Academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

//Inheritance 
public class Homepage extends Base{
	
@BeforeTest
	
	public void initialize() throws IOException
	{
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
@Test(dataProvider="getData")
	
	public void basePageNavigation(String username, String password) throws IOException
	{
		//create object to invoke method
		
		//Landing page
		LandingPage l =new LandingPage(driver);
		l.getSignin().click();
		
		//Login page
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		//System.out.println(text);
		lp.getLogin().click();
	}

@DataProvider

	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		//0th row
		data[0][0]="nru@gmail.com";
		data[0][1]="123456";
		//data[0][2]="Non Restricted Users";
		//1st row
		/*data[1][0]="nru@gmail.com";
		data[1][1]="456789";*/
		//data[1][2]="Restricted Users";
		
		return data;
	}
	
@AfterTest

	public void teardown()
	{
		driver.close();
	}
		

}

