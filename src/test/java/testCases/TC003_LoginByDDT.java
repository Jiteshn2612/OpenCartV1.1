package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.Dataprovider;

public class TC003_LoginByDDT extends BaseClass {
	
	
	
	@Test(dataProvider="LoginData", dataProviderClass=Dataprovider.class)
	public void verify_LoginInDDT(String ussername, String password, String result) throws InterruptedException
{
	
	logger.info("***Test Started TC003_Login ByDDT***");
	try
	{
	//Home page
	HomePage hp=new HomePage(driver);
	hp.clickMyAcount();
	hp.clickLogin();
	
	//Login Page
	LoginPage lp= new LoginPage(driver);
	lp.setEmail(ussername);
	lp.setPwd(password);
	lp.btnLogin();
	
	//MyAccount Page
	MyAccountPage map=new MyAccountPage(driver);
	boolean target=map.isMyPageExists();
	
	/*Data is valid --> Login success - > Test passed - logout
	 * 				--> Login unsuccess-> Test Fail
	 *
	 * Data is invalid-> Login success - > Test Failed - logout
	 * 			   	--> Login unsuccess-> Test Passed 
	 */
	if(result.equalsIgnoreCase("Valid"))
	{
		 if(target==true)
		 {
			 map.clkLogout();

			 Assert.assertTrue(true);
		 }
		 else 
		 {
			 Assert.assertTrue(false);
		 } 
	}
	if(result.equalsIgnoreCase("Invalid"))
	{
		if(target==true)
		{
			map.clkLogout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true); 
		}
	}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("***Test Finished TC003_Login ByDDT***");

	
}
	

}
