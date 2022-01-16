package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage

{
	public WebDriver driver;

	By userName = By.id("user_email");
	@FindBy(css = "#user_password")
	WebElement password;

	@FindBy(css = ".btn.btn-primary.btn-md.login-button")
	WebElement clickonLogin;

	By forgottenPassword = By.cssSelector(".link-below-button");

	public LoginPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ForgotPassword clickonForgotpass()

	{
		driver.findElement(forgottenPassword).click();
		ForgotPassword fp = new ForgotPassword(driver);
		return fp;
	}

	public WebElement getuserName()

	{
		return driver.findElement(userName);
	}

	public WebElement getPassword()

	{
		return password;

	}

	public WebElement login()

	{
		return clickonLogin;
	}

}
