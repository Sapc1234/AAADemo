package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage

{

	public WebDriver driver;

	By signin = By.cssSelector("a[href*='sign_in']");
	By tittle = By.xpath("//div[@class='text-center']/h2");
	By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");

	public LandingPage(WebDriver driver)

	{
		this.driver = driver;
	}

	public LoginPage getLogin()

	{
		driver.findElement(signin).click();
		LoginPage lo = new LoginPage(driver);
		return lo;
	}

	public WebElement getTittle()

	{
		return driver.findElement(tittle);
	}

	public WebElement getNavBar()

	{
		return driver.findElement(navBar);
	}

}
