package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.FashionSalePage;
import com.pages.Navigation_pages;
import com.pages.TestProductPage;
import com.pages.ViewCartPage;
import com.testbase.TestBase;

public class ViewCartTest extends TestBase{
	Navigation_pages Np;
	FashionSalePage FSP;
	TestProductPage TSP;
	ViewCartPage  VCP;
	
	
	
	public ViewCartTest() {
		super();
	}
	@BeforeMethod
	public void Setup()
	{
		initialization();
		Np = new Navigation_pages();
		FSP = new FashionSalePage();
		TSP = new TestProductPage();
		VCP = new ViewCartPage();
		
	}
	
	@Test(priority=1,description = "check View cart table is visible or not",groups="Component")
	public void check_Cart_functionality() throws Exception {
		Np.Check_fashoin_link_clickable();
		FSP.clickonDemoCateg();
		FSP.ClickOnTestingproductlink();
		TSP.Check_add_to_cart_functionality();
		TSP.Click_View_cart();
	boolean tbale=  VCP.check_table_of_cart();
	Assert.assertTrue(tbale);
	}
		@Test(priority=2,description = "check user go to testing product page after click on cart image")
		public void check_viewcart_product_image_clikable()
		{
			Np.Check_fashoin_link_clickable();
			FSP.clickonDemoCateg();
			FSP.ClickOnTestingproductlink();
			TSP.Check_add_to_cart_functionality();
			TSP.Click_View_cart();
			String exp=VCP.Check_Test_Product_image();
			Assert.assertEquals(exp,"Testing Product – Best Deals For Online Shopping");
		}
		
		@Test(priority=3,description = "check user go to testing product page after click on inside the cart link")
		public void check_viewcart_TestingProd_clikable()
		{
			Np.Check_fashoin_link_clickable();
			FSP.clickonDemoCateg();
			FSP.ClickOnTestingproductlink();
			TSP.Check_add_to_cart_functionality();
			TSP.Click_View_cart();
			String exp=VCP.Check_Test_Product_link();
			Assert.assertEquals(exp,"Testing Product – Best Deals For Online Shopping");
		}
		
		
		@Test(priority=4,description = "check user go to productpage after click on continue shoping inside the cart link")
		public void check_viewcart_ContinueShoping_clikable()
		{
			Np.Check_fashoin_link_clickable();
			FSP.clickonDemoCateg();
			FSP.ClickOnTestingproductlink();
			TSP.Check_add_to_cart_functionality();
			TSP.Click_View_cart();
			String exp=VCP.check_link_continue_shoping();
			Assert.assertEquals(exp,"Products – Best Deals For Online Shopping");
		}
		
		@Test(priority=5,description = "check  after click on updatecart inside the cart link")
		public void check_viewcart_UpdateCart_clikable()
		{
			Np.Check_fashoin_link_clickable();
			FSP.clickonDemoCateg();
			FSP.ClickOnTestingproductlink();
			TSP.Check_add_to_cart_functionality();
			TSP.Click_View_cart();
			boolean exp=VCP.Check_link_Update_cart();
			Assert.assertTrue(exp);
		}
		
		@Test(priority=6 ,description = "Check functionality of Coponcode",groups="component")
		public void Discount_code_functionality()
		{
			Np.Check_fashoin_link_clickable();
			FSP.clickonDemoCateg();
			FSP.ClickOnTestingproductlink();
			TSP.Check_add_to_cart_functionality();
			TSP.Click_View_cart();
		String exp=	VCP.check_coupon_code_accepted(prop.getProperty("coponcode"));
			Assert.assertEquals(exp, "Coupon \"abc@123\" is accepted");
		}
		@Test(priority=7 ,description = "Check user goto chekout if he/she click on proceed to checkout",groups="component")
		public void Proceed_To_Checkout()
		{
			Np.Check_fashoin_link_clickable();
			FSP.clickonDemoCateg();
			FSP.ClickOnTestingproductlink();
			TSP.Check_add_to_cart_functionality();
			TSP.Click_View_cart();
		String Text=	VCP.check_proceed_to_checkout();
	
			Assert.assertEquals(Text, "Checkout – Best Deals For Online Shopping");
		}
					
		
		@AfterMethod
		public void TearDown()
		{
			driver.quit();
		}
		
	

}
