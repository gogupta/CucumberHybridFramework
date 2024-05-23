package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnElement(WebElement element,long durationInSeconds)
	{
		WebElement webElement=	waitForElement(element,durationInSeconds);
		webElement.click();
	}
	
	public void typeTextIntoElement(WebElement element, String textToBeTyped,long duration)
	{
		WebElement webElement=waitForElement(element,duration);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds)
	{
		WebElement webElement=null;
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement= wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void selectOptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds)
	{
		WebElement webelement=waitForElement(element, durationInSeconds);
		Select select =new Select(webelement);
		select.selectByVisibleText(dropDownOption);
	}
	
	public void acceptAlert(long durationInSeconds)
	{
		Alert alert=waitForAlert(durationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds)
	{
		Alert alert=waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public Alert waitForAlert(long durationInSeconds)
	{
		Alert alert=null;
		try {
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert=wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void mouseHoverandClick(WebElement element,long durationinSeconds)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(durationinSeconds));
		WebElement webElement=wait.until(ExpectedConditions.visibilityOf(element));
		
		Actions actions=new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	
	public WebElement waitforvisibilityOfElements(WebElement element,long durationInSeconds)
	{
		WebElement webElement=null;
		try {
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			 webElement=wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void javaScriptClick(WebElement element, long durationInSeconds)
	{
		WebElement webElement=waitforvisibilityOfElements(element, durationInSeconds);
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("argument[0].click();", webElement);
	}

	public void javaScriptType(WebElement element, long durationInSeconds,String textToBeTyped)
	{
		WebElement webElement=waitforvisibilityOfElements(element, durationInSeconds);
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("argument[0].value='"+textToBeTyped+"'", webElement);
	}
	
	public String getTextFromElement(WebElement element, long durationInSeconds)
	{
		WebElement webElement=waitForElement(element, durationInSeconds);
		return webElement.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element, long DurationInSeconds)
	{
		try {
			WebElement webElement=waitforvisibilityOfElements(element, DurationInSeconds);
			webElement.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
