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

public class ValiDateTittle extends base

{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ValiDateTittle.class.getName());
	@BeforeTest

	public void inililix() throws IOException

	{
		driver = initializeDriver();
		System.out.println("driver is Initialized");
	}

	@Test
	public void validateApptittle() throws IOException

	{

		driver.get(prop.getProperty("url"));

		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTittle().getText(), "FEATURED COURSES");
		// lp.getTittle().getText()
		log.info("tittle is Validated");
		System.out.println("tittle is validated");
		System.out.println("tittle is validated1");
		System.out.println("tittle is validated2");

	}

	@AfterTest

	public void tearDown()

	{
		driver.close();
	}
}
