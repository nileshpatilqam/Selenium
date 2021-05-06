package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base{
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver intializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\niles\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		System.out.println("browser");
		if(browserName.equals("chrome"))
		{
			//chrome 
			System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");   
			driver=new ChromeDriver();
		}
		else 
		{
			//Edge
			//System.setProperty("webdriver.Edge.driver", "C:\\work\\Edgedriver.exe");   
			//driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		//driver.get("https://google.com"); // hit url on browser
	}
}
