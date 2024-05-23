package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.CommonUtils;
import utils.ConfigReader;

public class DriverFactory {

	static WebDriver driver =null;

	public static WebDriver initializeBrowser(String browserName) {
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\Govind data\\chromedrivers\\chromedriver-win64\\chromedriver.exe");
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			 driver=new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			 driver=new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		return driver;

	}

	public static WebDriver getDriver()
	{
		return driver;
	}
}
