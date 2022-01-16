package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base

{
	public static Logger log = LogManager.getLogger(base.class.getName());

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException

	{

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		// String browserName = prop.getProperty("browser");//it will check in the file

		// mvn test -Dbrowser=chrome

		String browserName = System.getProperty("browser");// it will check mvn cmd if ant property defined with browser

		if (browserName.contains("chrome"))

		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			
			if(browserName.contains("headless"))
				
			{
			option.addArguments("headless");
			}

			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox"))

		{
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else if (browserName.equals("Edge"))

		{
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenshotpath(String testcaseName, WebDriver driver) throws IOException

	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destnationFile = System.getProperty("user.dir") + "\\reports\\" + testcaseName + ".png";

		FileUtils.copyFile(source, new File(destnationFile));
		// FileUtils.copyFile(source, new File(destinationFile));
		return destnationFile;
	}

}
