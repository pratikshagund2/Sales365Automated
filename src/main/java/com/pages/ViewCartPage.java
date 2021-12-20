package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class ViewCartPage extends TestBase {
	
	@FindBy(xpath = "//i[@class='minicart-icon porto-icon-bag-2']")
	private WebElement Carticon;
	@FindBy(xpath= "//a[@class='pull-right']")
	WebElement viewcart;
	
	@FindBy (xpath ="//*[@id=\"content\"]/article/div/div/div[2]/div/div[1]/div/div/form/table")
	private WebElement carttable;
	
	@FindBy (tagName = "tr")
	private List<WebElement> row;
	
	@FindBy (tagName = "td")
	private List<WebElement> Col;
	
	@FindBy(xpath ="//td[@class=\"product-name\"]")
	private WebElement TestingProd;
	
	@FindBy(xpath ="//img[@src=\"https://sale365days.co.in/wp-content/uploads/2020/12/stand-modal-image-1-min-300x300.jpg\"]")
	private WebElement testprodimg;
	
	@FindBy(xpath="//a[@class=\"btn btn-default\"]")
	private WebElement continue_shopping;
	
	@FindBy (name =  "update_cart")
	private WebElement update_cart;
	
	@FindBy (xpath = "//a[@class=\"accordion-toggle collapsed\"]")
	private WebElement discount_coupon;
	
	@FindBy(id = "coupon_code")
	private WebElement coupon_code;
	
	@FindBy (name = "apply_coupon")
	private WebElement applycoupon;
	
	@FindBy (xpath= "//a[@class=\"btn btn-primary proceed-to-checkout\"]")
	private WebElement Proceed_checkout;
	
	@FindBy (className = "woocommerce-error")
	private WebElement Couponcodemsg;
	
	public ViewCartPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public boolean check_table_of_cart()
	{
		carttable.click();
		row.size();
		for(WebElement row1 : row ) {
			String rows = row1.getText();
			System.out.println(rows);
			Col.size();
			for(WebElement col1: Col)
			{
				String cols = col1.getText();
				System.out.println(cols);
			}
			
		}
		return carttable.isDisplayed();
		
		
		
	}
	
	public String check_link_continue_shoping()
	{
		continue_shopping.click();
		return driver.getTitle();
		
	}
	
	public boolean Check_link_Update_cart()
	{
		return update_cart.isEnabled();
		
	}
	
	public String Check_Test_Product_image()
	{
		testprodimg.click();
		return driver.getTitle();
	}
	
	

	public String Check_Test_Product_link()
	{
		TestingProd.click();
		return driver.getTitle();
	}
	
	public String check_coupon_code_accepted(String coponcode)
	{
		discount_coupon.click();
		coupon_code.sendKeys(coponcode);
		applycoupon.click();
		return Couponcodemsg.getText();
	}
	
	public String check_proceed_to_checkout()
	{
		Proceed_checkout.click();
		return driver.getTitle();
	}
	
	public ChekoutPage clicktocheckout()
	{
		Proceed_checkout.click();
		return new ChekoutPage(); 
	}
	
	
	
}
