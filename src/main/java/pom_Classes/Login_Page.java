package pom_Classes;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util_Classes.Util_Class;

public class Login_Page extends Util_Class {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text() = 'Login/Register']")
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@id='login_email1']")
	private WebElement emailInput;
	
	@FindBy(xpath="//span[text() = 'Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@id='login_password1']")
	private WebElement passwordInput;
	
	@FindBy(xpath="//div[@class='col l12 leps592LoginButton']")
	private WebElement submitButton;
	
	@FindBy(xpath="(//input[@type='number'])[1]")
	private WebElement pinField;
	
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void putEmail() throws IOException
	{
		explicitWait(driver, emailInput);
		emailInput.sendKeys(getDataFromPropertyFile("email"));
	}
	
	public void clickContinueButton()
	{
		continueButton.click();
	}
	
	public void putPassword() throws IOException
	{
		explicitWait(driver, passwordInput);
		passwordInput.sendKeys(getDataFromPropertyFile("password"));
	}
	
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	
	public void putPin() throws IOException
	{
		explicitWait(driver, pinField);
		
		String value = getDataFromPropertyFile("pin");
		
		char digits[] = value.toCharArray();
		
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='number']"));
		
		for(int i=0; i<digits.length; ++i)
		{
			list.get(i).sendKeys(String.valueOf(digits[i]));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
