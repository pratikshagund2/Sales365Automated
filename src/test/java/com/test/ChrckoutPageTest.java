package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.ChekoutPage;
import com.pages.FashionSalePage;
import com.pages.Navigation_pages;
import com.pages.TestProductPage;
import com.pages.ViewCartPage;
import com.testbase.TestBase;

public class ChrckoutPageTest extends TestBase {
	Navigation_pages np;
	FashionSalePage Fsp;
	TestProductPage tp;
	ViewCartPage vcp;
	ChekoutPage cp;

	public ChrckoutPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		np = new Navigation_pages();
		Fsp = new FashionSalePage();
		tp = new TestProductPage();
		vcp = new ViewCartPage();
		cp = new ChekoutPage();
	}
	
	@Test(priority=1)
	public void Checkdiscount_coupon()
	{
		Fsp=np.Check_fashoin_link_clickable();
		Fsp.clickonDemoCateg();
		Fsp.ClickOnTestingproductlink();
		tp.Check_add_to_cart_functionality();
		tp.Click_View_cart();
		vcp.check_proceed_to_checkout();
		String msg=cp.check_coupon_code_accepted(prop.getProperty("coponcode"));
		Assert.assertEquals(msg,"coponcode is accepted successfully");
	}
	
	@Test(priority=2)
	public void check_biilingdetails_click_to_proceed()
	{
		Fsp=np.Check_fashoin_link_clickable();
		Fsp.clickonDemoCateg();
		Fsp.ClickOnTestingproductlink();
        tp.Check_add_to_cart_functionality();
		tp.Click_View_cart();
		vcp.check_proceed_to_checkout();
		String msg= cp.check_placeholder_button(prop.getProperty("FirstName"),prop.getProperty("LastName"),prop.getProperty("Compname"),
				prop.getProperty("Add1"),prop.getProperty("Add2"),prop.getProperty("City"),
				prop.getProperty("State"),prop.getProperty("Pin"),prop.getProperty("Phone"),prop.getProperty("Email"));
		Assert.assertEquals(msg, "Successfully go to proceed");
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}
