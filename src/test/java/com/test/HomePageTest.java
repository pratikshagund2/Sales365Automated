package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.testbase.TestBase;

public class HomePageTest extends TestBase {
HomePage hm;
	public HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void Setup()
	{
		initialization();
		hm = new HomePage();
	}
	
	@Test
	public void checkBrokenLinks() 
	{
		
	
		
		String URLin= hm.Find_broken_links_URL();

			// TODO Auto-generated catch block
			
	
			Assert.assertEquals( URLin, "https://sale365days.co.in/");
		
	}
	@Test
	public void checkBrokenImages() 
	{
		
	
		
		String URLin= hm.Find_broken_imges_URL();

			// TODO Auto-generated catch block
			
	
			Assert.assertEquals( URLin, "https://sale365days.co.in/");
		
	}
	
	@Test
	public void Check_Newslettersubsbribe_functionality() {
String sucessmsg =		hm.Check_newsletterSubscribe(prop.getProperty("SubcribeEmail"));
		Assert.assertEquals(sucessmsg,"Successfully subscribe email");
		
	}
	@Test
	public void TearDown()
	{
		driver.quit();
}
}