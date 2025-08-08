package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div//input[@id='input-email']")
	WebElement txtEmailAddress;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtLoginPassword;
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnLogin;
	
	
	public void setEmail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	public void setPwd(String pwd)
	{
		txtLoginPassword.sendKeys(pwd);
	}
	public void btnLogin() throws InterruptedException
	{
		btnLogin.click(); 
	}

	
	
	
	
	

}
