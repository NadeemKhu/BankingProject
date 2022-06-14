package test_Classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base_Classes.Base_Class_1;
import listeners_Classes.Listener_Class;
import pom_Classes.Fund_Page;
import pom_Classes.Home_Page;
import pom_Classes.Login_Page;

@Listeners(Listener_Class.class)

public class VerifyUserCanAddAmount {
	
	WebDriver driver;
	Login_Page lp;
	Home_Page hp;
	Fund_Page fp;
	
	ExtentHtmlReporter reporter;
	ExtentReports report;
	ExtentTest test;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String k)
	{
		reporter = Base_Class_1.getHtmlReporter();
		report = Base_Class_1.getExtentReports();
		report.attachReporter(reporter);
		test = Base_Class_1.getTestForReporter("VerifyUserCanAddAmount");
		
		driver = Base_Class_1.getDriver(k);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		lp = new Login_Page(driver);
		hp = new Home_Page(driver);
		fp = new Fund_Page(driver);
	}
	
	@Test
	public void verifyUserCanLogin() throws IOException, InterruptedException
	{
		lp.clickLoginButton();
		lp.putEmail();
		lp.clickContinueButton();
		lp.putPassword();
		lp.clickSubmitButton();
		lp.putPin();
		Thread.sleep(3000);
		Assert.assertTrue(hp.verfyUser());
	}
	
	@Test
	public void verifyUserCanOpenFundPage() throws EncryptedDocumentException, IOException
	{
		hp.clickFundButton();
		Assert.assertTrue(fp.verifyFundPageLoaded());
	}
	
	@Test
	public void verifyUserCanAddAmount()
	{
		Assert.assertTrue(fp.enterDepositAmount());
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test is Passed" + result.getName());
		}
		else
		{
			String path = lp.getScreenshot(driver, result.getName());
			test.log(Status.FAIL, "Test is failed" + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
	
	@AfterClass
	public void afterClass()
	{
		report.flush();
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
