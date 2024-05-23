package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {
	
	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;

	@Given("User opens the Application")
	public void user_opens_the_application() {
		driver=DriverFactory.getDriver();
	}

	@When("User enters a vaild product {string} into search box field")
	public void user_enters_a_vaild_product_into_search_box_field(String validProductText) {
		HomePage homePage=new HomePage(driver);
		homePage.enterValidProductIntoSearcBox(validProductText);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		homePage =new HomePage(driver);
		searchResultPage=homePage.clickOnSearchButton();
	}

	@Then("User should get a valid product displayed in search results")
	public void user_should_get_a_valid_product_displayed_in_search_results() {
		
		Assert.assertTrue(searchResultPage.displayStatusOfValidProduct());
	}
	
	@When("User enters a invaild product {string} into search box field")
	public void user_enters_a_invaild_product_into_search_box_field(String invalidProductText) {
		homePage =new HomePage(driver);
		homePage.enterValidProductIntoSearcBox(invalidProductText);	
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		Assert.assertEquals("There is no product that matches the search criteria.",searchResultPage.getMessageText());
	}

	@When("User dont enters any product {string} into search box field")
	public void user_dont_enters_any_product_into_search_box_field(String string) {
		homePage=new HomePage(driver);
	}
}
