package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	private RegisterPage registerpage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		driver=DriverFactory.getDriver();
		HomePage homePage =new HomePage(driver); 
		homePage.clickOnMyAccount();
		registerpage=homePage.selectRegisterOption();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String,String> datamap=dataTable.asMap(String.class,String.class);
		registerpage=new RegisterPage(driver);
		registerpage.enterFirstName(datamap.get("firstName"));
		registerpage.enterlastName(datamap.get("lastName"));
		commonUtils=new CommonUtils();
		registerpage.enterEmail(commonUtils.getEmailWithTimeStamp());
		registerpage.enterTelephone(datamap.get("telephone"));
		registerpage.enterPassword(datamap.get("password"));
		registerpage.enterConfirmPassword(datamap.get("password"));
	}

	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {

		Map<String,String> datamap=dataTable.asMap(String.class,String.class);
		registerpage=new RegisterPage(driver);
		registerpage.enterFirstName(datamap.get("firstName"));
		registerpage.enterlastName(datamap.get("lastName"));
		registerpage.enterEmail(datamap.get("email"));
		registerpage.enterTelephone(datamap.get("telephone"));
		registerpage.enterPassword(datamap.get("password"));
		registerpage.enterConfirmPassword(datamap.get("password"));
	}	
	
	@When("User selects privacy button")
	public void user_selects_privacy_button() {
		registerpage.selectPrivacyPolicy();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		accountSuccessPage=registerpage.clickOnContinueButton();
}

	@Then("User account should be created successfully")
	public void user_account_should_be_created_successfully() {
		Assert.assertEquals("Your Account Has Been Created!",accountSuccessPage.getPageHeading());
	}

	@When("User selects Yes for Newsletterm")
	public void user_selects_yes_for_newsletterm() 	{
		registerpage.selectYesNewsLetterOption();
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		Assert.assertTrue(registerpage.getWarningMesage().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enters any details into fields")
	public void user_dont_enters_any_details_into_fields() {
		registerpage.enterFirstName("");
		registerpage.enterlastName("");
		registerpage.enterEmail("");
		registerpage.enterTelephone("");
		registerpage.enterPassword("");
		registerpage.enterConfirmPassword("");

	}

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
	//	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
		Assert.assertTrue(registerpage.getWarningMesage().contains("Warning: You must agree to the Privacy Policy!"));
		
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.getFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.getPasswordWarning());
		
	}

	private String getEmailWithTimeStamp()
	{
		Date date=new Date();
		return "govind"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}
