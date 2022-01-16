package stepdefination;

import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
@RunWith(Cucumber.class)
public class Stepdefination extends base

{

	@Given("^Initialize the bowser with chrome$")
	public void initialize_the_bowser_with_chrome() throws Throwable

	{
		driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_something_site(String strArg1) throws Throwable

	{
		driver.get(prop.getProperty("url"));
	}

	@Given("^click on login page to land on secure login page$")
	public void click_on_login_page_to_land_on_secure_login_page() throws Throwable

	{
		LandingPage lp = new LandingPage(driver);

		LoginPage lo = lp.getLogin();
		lo.login().click();
	}

	@When("^user enters (.+)and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password) throws Throwable

	{
		LandingPage lp = new LandingPage(driver);
		LoginPage lo = lp.getLogin();
		lo.getuserName().sendKeys(username);
		lo.getPassword().sendKeys(password);
	}

	@Then("^verify that user is Successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable

	{

	}

}
