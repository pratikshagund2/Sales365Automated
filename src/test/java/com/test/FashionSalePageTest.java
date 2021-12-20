package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.FashionSalePage;
import com.pages.Navigation_pages;
import com.testbase.TestBase;

public class FashionSalePageTest extends TestBase {
  Navigation_pages np;
  FashionSalePage FSP;
	
	public FashionSalePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		initialization();
		np = new Navigation_pages();
		FSP = new FashionSalePage();
	}
	
	@Test(priority= 1, description = "check accsories link is cliakble and verify list of product is display or not",groups="unit")
	public void Acceesories_Clickandlistpfproduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.clickonaccessories();
		Assert.assertTrue(true);
	}
	
	@Test(priority= 2, description = "check clothaccsories link is cliakble and verify list of product is display or not",groups="unit")
	public void Cloth_Acceesories_Clickandlistpfproduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.clickoncloth();
		Assert.assertTrue(true);
	}
	
	@Test(priority= 3, description = "check womencloth link is cliakble and verify list of product is display or not",groups="unit")
	public void Women_Clickandlistpfproduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.clickonWomencloth();
		Assert.assertTrue(true);
	}
	
	@Test(priority= 4, description = "check Health&personal care link is cliakble and verify list of product is display or not",groups="unit")
	public void Healthpersonalcare_Clickandlistpfproduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.clickonHealthCare();
		Assert.assertTrue(true);
	}
	
	@Test(priority= 5, description = "check Demo Category link is cliakble and verify list of product is display or not",groups="unit")
	public void Democategory_Clickandlistpfproduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.clickonHealthCare();
		Assert.assertTrue(true);
	}
	
	@Test(priority= 6, description = "check Home and kitchen link is clickble and verify list of product is display or not",groups="unit")
	public void HomeKitchen_Clickandlistpfproduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.clickonHomeKitchen();
		Assert.assertTrue(true);
	}
	@Test(priority= 7, description = "check limitedoffer link is clickble and verify list of product is display or not",groups="unit")
	public void limited_Clickandlistpfproduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.clickonlimitedtimedeal();
		Assert.assertTrue(true);
	}
	
	@Test(priority= 8, description = "check list of product after adding filter low to high",groups="unit")
	public void SelectfilterLow_Checkandlistpfproduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.Select_filter_lowtohigh();
		Assert.assertTrue(true);
	}
	@Test(priority= 9, description = "check list of product after adding filter high to low",groups="unit")
	public void SelectfilterHigh_Checkandlistpfproduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.Select_filter_hightolow();
		Assert.assertTrue(true);
	}
	
	@Test(priority= 10, description = "check list of product after adding filter of popularity",groups="unit")
	public void SelectfilterPopularity_Checkandlistpfproduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.Select_filter_Sortbypopularity();
		Assert.assertTrue(true);
	}
	
	@Test(priority= 11, description = "check list of product after click on horizontal grid view",groups="unit")
	public void ClickHorizontalgridview_Checkandlistpfproduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.Check_Grid_view_product();
		Assert.assertTrue(true);
	}
	@Test(priority= 11, description = "check list of product after click on list view",groups="unit")
	public void Clicklistview_Checkandlistpfproduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.Check_Grid_view_product();
		Assert.assertTrue(true);
	}
	
	@Test(priority=12,description = "Verifying url After clicking on testing product link user to testing product page",groups="regression")
	public void checkTestProduct()
	{
		np.Check_fashoin_link_clickable();
		FSP.ClickOnTestingproductlink();
		Assert.assertEquals(driver.getCurrentUrl(),"https://sale365days.co.in/product/testing-product/");
	}
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}
