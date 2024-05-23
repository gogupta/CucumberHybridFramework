package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}

	@FindBy(id="input-email")
	private WebElement emailfield;

	@FindBy(id="input-password")
	private WebElement passwordField;

	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath="//div[contains(@class,'alert alert-danger alert-dismissible')]")
	private WebElement warningMessage;

	public void enterEmailAddress(String emailText)
	{
		elementUtils.typeTextIntoElement(emailfield,emailText, 30);
	}
	
	public void enterPassword(String passwordText)
	{
		elementUtils.typeTextIntoElement(passwordField,passwordText, 30);
	}

	public AccountPage clickOnLoginbutton()
	{
		elementUtils.clickOnElement(loginButton, 30);
		return new AccountPage(driver);
	}
	
	public String getWarningMessageText()
	{
		return elementUtils.getTextFromElement(warningMessage, 30);
	}
	
}
