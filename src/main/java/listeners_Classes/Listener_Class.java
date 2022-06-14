package listeners_Classes;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener_Class implements ITestListener {
	
	  public void onTestStart(ITestResult result) 
	  {
		  System.out.println(result.getName() + " Test Started");  
	  }
  
	  public void onTestSuccess(ITestResult result) 
	  {
		  System.out.println(result.getName() + " Test Success");
	  }
  
	  public void onTestFailure(ITestResult result) 
	  {
		  System.out.println(result.getName() + " Test Fail");
	  }
	  
	  public void onTestSkipped(ITestResult result) 
	  {
		  System.out.println(result.getName() + " Test Skipped");
	  }

}
