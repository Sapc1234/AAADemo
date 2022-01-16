package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword

{

	public WebDriver driver;

	By emailId = By.cssSelector("#user_email");
	By sendmeInstruction = By.cssSelector(".btn.btn-primary.btn-md.login-button");

	// .btn.btn-primary.btn-md.login-button

	

	public ForgotPassword(WebDriver driver) 
	
	{
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public WebElement clickonForgotpass()

	{
		return driver.findElement(emailId);
	}

	public WebElement sendmeInstructions()

	{
		return driver.findElement(sendmeInstruction);
	}

}
