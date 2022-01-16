package Academy.EndtoEndProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNg;
import resources.base;

public class Listeners extends base implements ITestListener

{
	ExtentTest test;
	ExtentReports extent = ExtentReportNg.getReportobject();
	ThreadLocal<ExtentTest> extentTest =  new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result)

	{

		ITestListener.super.onTestStart(result);

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result)

	{

		ITestListener.super.onTestSuccess(result);

		//test.log(Status.PASS, "Test passed");
		extentTest.get().log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result)

	{

		ITestListener.super.onTestFailure(result);
		
		//test.fail(result.getThrowable());
		extentTest.get().fail(result.getThrowable());

		WebDriver driver = null;

		String testMethodName = result.getMethod().getMethodName();

		try

		{
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		}

		catch (Exception e)

		{

		}

		try

		{
			// i want to attach the screenshot to extent Report
			extentTest.get().addScreenCaptureFromPath(getScreenshotpath(testMethodName, driver), result.getMethod().getMethodName());

			//getScreenshotpath(testMethodName, driver);
		}

		catch (IOException e)

		{

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result)

	{

		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)

	{

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)

	{
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context)

	{

		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context)

	{

		ITestListener.super.onFinish(context);
		extent.flush();
	}

}
