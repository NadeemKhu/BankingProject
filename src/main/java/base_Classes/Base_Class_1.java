package base_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class_1 {
	
	static ExtentHtmlReporter htmlReporter;
	
	static ExtentReports report;
	static ExtentTest test;
	
	public static WebDriver getDriver(String browser)
	{
		WebDriver driver;
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			
			driver = new EdgeDriver();
		}
		
		driver.get("https://groww.in/");
		
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static ExtentHtmlReporter getHtmlReporter()
	{
		if(htmlReporter == null)
		{
			htmlReporter = new ExtentHtmlReporter("ExtentReporter.html");
		}
		
		return htmlReporter;
	}
	
	public static ExtentReports getExtentReports()
	{
		if(report == null)
		{
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
		}
		
		return report;
	}
	
	public static ExtentTest getTestForReporter(String useCase)
	{
		return test = report.createTest(useCase);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
