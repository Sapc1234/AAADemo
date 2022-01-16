package Academy.EndtoEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base

{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest

	public void inililix() throws IOException

	{
		driver = initializeDriver();
		log.info("Driver is Initialized");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String Password) throws IOException

	{

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");

		LandingPage lp = new LandingPage(driver);
	//	lp.getLogin().click();
		
		LoginPage lo= lp.getLogin();
		//LoginPage lo = new LoginPage(driver);
		lo.getuserName().sendKeys(userName);
		lo.getPassword().sendKeys(Password);
		lo.login().click();
		ForgotPassword fp = lo.clickonForgotpass();
		fp.clickonForgotpass().sendKeys("sharanpadashetty637@gmail.com");
		fp.sendmeInstructions().click();
	}

	@DataProvider()

	public Object[][] getData()

	{
		Object[][] data = new Object[2][2];
		data[0][0] = "sharan123";
		data[0][1] = "123456";

		data[1][0] = "pada123";
		data[1][1] = "123456789";

		return data;

	}

	@AfterTest

	public void tearDown()

	{
		driver.close();
	}

}
