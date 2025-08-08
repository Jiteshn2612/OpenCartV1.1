package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	public void varifyLogin() throws InterruptedException
	{
		
		try
		{
			logger.info("*** Test started ***");
		
		
	//Homepage
		HomePage hp= new HomePage(driver);
		hp.clickMyAcount();
		hp.clickLogin();
	//LoginPage
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPwd(p.getProperty("password"));
		lp.btnLogin();
	//MyAccountPage
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetpage=map.isMyPageExists();
		
		Assert.assertTrue(targetpage, "Test Fail");
		
		logger.info("*** Test Finished TC002_LoginTest ***");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		Thread.sleep(4000);
		MyAccountPage myaccpg=new MyAccountPage(driver);
		myaccpg.clkLogout();

		
	}
	
	

}
