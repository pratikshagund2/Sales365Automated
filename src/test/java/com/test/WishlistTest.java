package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.WishlistPage;
import com.testbase.TestBase;

public class WishlistTest extends TestBase {
	WishlistPage wp;
	public WishlistTest()
	{
		super();
	}

	@BeforeMethod
	public void Setup()
	{
		initialization();
		wp = new WishlistPage();
	}
	
	@Test(priority=2)
	public void Check_title()
	{
		String title =wp.check_wishlist_product();
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	@Test(priority=3)
	public void Check_table_list_wishlist_product() throws Exception
	{
		//wp.Element_added_wishlist();
	 wp.checktable_visible();
	Assert.assertEquals(driver.getTitle(), "Wishlist – Best Deals For Online Shopping");
	}
	
	@AfterMethod
	public void  TearDown()
	{
		driver.quit();
	}
}
