package pom_Classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util_Classes.Util_Class;

public class Fund_Page extends Util_Class {
	
WebDriver driver;
	
	@FindBy(xpath="//div[text() = 'Balance available']")
	private WebElement amountText;
	
	@FindBy(xpath="//input[@id='wrs445Amount']")
	private WebElement amountField;
	
	@FindBy(xpath="//div[text() = 'More Options']")
	private WebElement moreOptionButton;
	
	@FindBy(xpath="//div[text() = 'Net Banking']")
	private WebElement netBanking;
	
	@FindBy(xpath="//span[text() = 'PAY VIA NETBANKING']")
	private WebElement netBankingButton;
	
	@FindBy(xpath="//div[@class='col l12 amupNew89PopupHeader absolute-center']")
	private WebElement amountConfirmText;
	
	
	
	public Fund_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean verifyFundPageLoaded() throws EncryptedDocumentException, IOException
	{
		WebElement element = explicitWait(driver, amountText);
		
		String textFromUi = element.getText();
		
		String textFromExcelSheet = getDataFromExcelSheet("Sheet1", 0, 0);
		
		if(textFromUi.equals(textFromExcelSheet))
		{
			return true;
		}
		return false;
	}
	
	public boolean enterDepositAmount()
	{
		amountField.clear();
		
		String amount = "200";
		
		amountField.sendKeys(amount);
		
		moreOptionButton.click();
		
		explicitWait(driver, netBanking);
		
		netBanking.click();
		
		explicitWait(driver, netBankingButton);
		
		netBankingButton.click();
		
		WebElement element = explicitWait(driver, amountConfirmText);
		
		double text = Double.parseDouble(element.getText().split("₹")[1]);
		
		int k = (int) text;
		
		System.out.println(k);
		
		if(amount.equals(String.valueOf(k)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
