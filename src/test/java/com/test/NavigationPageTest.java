package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Navigation_pages;
import com.testbase.TestBase;

public class NavigationPageTest extends TestBase{
	Navigation_pages np ;
	public NavigationPageTest()
	{
	   super();
	}
       @BeforeMethod
	   public void Setup()
	   {
		   initialization();
		   np = new Navigation_pages() ;
	   }
       
       @Test(description = "check home is clickable or not by verifying title of page",priority=1,groups="regression")
       public void check_home_link()
       {
    	   np.Click_on_Home_page();
    	   Assert.assertEquals(driver.getTitle(),"Best Deals For Online Shopping – Sale 365 Days | India");
       }
       @Test(description =" check fashionlink is clickable or not",priority = 2)
       public void check_FashionSale()
       {
    	   np.Check_fashoin_link_clickable();
    	 Assert.assertEquals(driver.getTitle(),"Cloths & Accessories – Best Deals For Online Shopping");
       }
       
       @Test(description =" check sportlink is clickable or not",priority = 3,groups="regression")
       public boolean check_sport_details()
       {
    	  return np.Check_sportlink_is_clickable();
    	 
       }
       @Test(description = "check my wallet page is open or not",priority=4,groups="regression")
       public void Check_my_wallet()
       {
    	   np.Check_mywalletlink_is_clickable();
    	   Assert.assertEquals(driver.getTitle(), "My wallet – Best Deals For Online Shopping");
    	   
       }
       @Test (description = "check Electonics page is open or not",priority=5,groups="regression")
	   public void Check_Elect()
	   {
    	   np.Check_eleclink_is_clickable();
    	   Assert.assertEquals(driver.getTitle(), "Electronics – Best Deals For Online Shopping");
	   }
       
       
       @AfterMethod
       public void tearDown()
       {
    	   driver.quit();
       }
}
