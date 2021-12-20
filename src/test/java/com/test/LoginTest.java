package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.loginpage;
import com.testbase.TestBase;
import com.utility.ExcelUtilsEx;

public class LoginTest extends TestBase {
    HomePage hm;
    loginpage lp;

    	public LoginTest() {
    		super();
    	}

      @BeforeMethod
       public void Setup()
         {
	  initialization();
	  hm = new HomePage();
	  lp= new loginpage();
          }
       @Test(priority=1 , description = "check login fuctionality by fetching valid data from properties file ")
       public void validloginCredentials()
       {
    	   hm.Click_myAccount();
    	String title=   lp.validlogincredentials(prop.getProperty("username"),prop.getProperty("password"));
    	Assert.assertEquals(title,"My Account – Best Deals For Online Shopping");
	
       }
       
       @Test(priority=2 , description = "check the login fuctinality by entering invalid credentials",dataProvider = "getlogindata")
       public void invalidlogincredentilas(String Usename, String Password)
       {
    	   hm.Click_myAccount();
    	   lp.invalidLogindetail(Usename, Password);
       }
       
       @DataProvider
       public Object[][] getlogindata() throws Exception
       {
    	  Object[][] logindata = ExcelUtilsEx.getTableArray("C:mysheets//Login.xlsx","login1");
    	  return logindata;
       }
       
       @Test(priority= 3, description="check the lost password link is present on loginpage")
       public void checklostpasswordlinkavailable() {
    	   hm.Click_myAccount();
    	   boolean linkdisplay = lp.checklostpasswordlink();
    	   Assert.assertTrue(linkdisplay);
       }
       
       @Test(priority =4 , description="verify user goes to reset page after click on lostpassword link by verifying title")
        public void checklostpassordlinkisopenornot()  {
    	   
    	   hm.Click_myAccount();
    	String title =   lp.Check_lost_password_functionality();
    	Assert.assertEquals(title, "My Account – Best Deals For Online Shopping");
       }
       
       @Test(priority=5,description = "check Reset password functionality")
       public void check_reset_functinality_valid_Email() {
    	   hm.Click_myAccount();
    	  String Title = lp.ResetPasswordFuctionality(prop.getProperty("sukanyabankar27@gmail.com"));
    	  Assert.assertEquals(Title, "My Account – Best Deals For Online Shopping");
       }
       
       @AfterMethod
       public void TearDown()
       {
    	   driver.quit();
       }
	}