package Academy.EndtoEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValiDateNavigationBar extends base

{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ValiDateNavigationBar.class.getName());

	@BeforeTest

	public void inililix() throws IOException

	{
		driver = initializeDriver();
	}

	@Test
	public void validateNavbar() throws IOException

	{

		driver.get(prop.getProperty("url"));

		LandingPage lp = new LandingPage(driver);
		// lp.getNavBar()
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("NavigationBar is Displayed");
		
		System.out.println("navigationbar is displayed");

	}

	@AfterTest

	public void tearDown()

	{
		driver.close();
	}
}
