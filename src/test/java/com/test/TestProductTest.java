package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.FashionSalePage;
import com.pages.Navigation_pages;
import com.pages.TestProductPage;
import com.testbase.TestBase;

public class TestProductTest extends TestBase{
	Navigation_pages np;
	FashionSalePage FSP;
	TestProductPage TSP;
	
	public TestProductTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
	initialization();
	np= new Navigation_pages();
	FSP = new FashionSalePage();
	TSP = new TestProductPage();
		
	}
	
	
	
	@Test(priority= 1, description = "check Testing Product link is clickable and verify user go to testingprod or not",groups="component")
	public void CheckTestProductLink()
	{
		np.Check_fashoin_link_clickable();
		FSP.clickonDemoCateg();
		FSP.ClickOnTestingproductlink();
		Assert.assertEquals(driver.getTitle(),"Testing Product – Best Deals For Online Shopping");
	}
	
	@Test(priority= 2, description = "check plus button  is clickable and verify product is added that much time",groups="component")
	public void Verify_addbtn_add_product()
	{
		np.Check_fashoin_link_clickable();
		FSP.clickonDemoCateg();
		FSP.ClickOnTestingproductlink();
		TSP.check_same_product_add();
		
		
	}
	@Test(priority= 3, description = "check minus button  is clickable and verify product is added that much time",groups="component")
	public void Verify_minusbtn_minusProd()
	{
		np.Check_fashoin_link_clickable();
		FSP.clickonDemoCateg();
		FSP.ClickOnTestingproductlink();
		TSP.check_same_product_delete();
		
	}
	
	@Test(priority= 4, description = "check add  to cart functionality",groups="component")
	public void check_addtocart_button()
	{
		np.Check_fashoin_link_clickable();
		FSP.clickonDemoCateg();
		FSP.ClickOnTestingproductlink();
	boolean sucessmessg =	TSP.Check_add_to_cart_functionality();
	System.out.println(sucessmessg);
		Assert.assertTrue(sucessmessg);
	}
	
	@Test(priority=5 , description = "check Ask question link is clikable and next page or content is open or not",groups="component")
	public void check_Askquestion_link()
	{
		np.Check_fashoin_link_clickable();
		FSP.clickonDemoCateg();
		FSP.ClickOnTestingproductlink();
	boolean link =	TSP.check_Askquestionclick_clikable();
	Assert.assertTrue(link);
	Assert.assertEquals(driver.getCurrentUrl(), "https://sale365days.co.in/AskMeQuestions/");
	}
	
	

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
