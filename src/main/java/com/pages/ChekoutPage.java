package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.testbase.TestBase;

public class ChekoutPage extends TestBase {
	
	@FindBy (xpath = "//a[@class=\"accordion-toggle collapsed\"]")
	private WebElement discountcode;
	
	@FindBy (id = "coupon_code")
	private WebElement couponcode;
	
	@FindBy (xpath = "//button[@class=\"btn btn-default\"]")
	private WebElement appybtn;
	
	@FindBy (className = "woocommerce-error")
	private WebElement couponsmsg;
	
	@FindBy(id = "billing_first_name")
	private WebElement firstname;
	
	@FindBy(id = "billing_last_name")
	private WebElement lastname ;
	
	@FindBy(id = "billing_company")
	private WebElement billing_company;
	
	@FindBy(id = "billing_address_1")
	private WebElement billing_address_1;
	
	@FindBy(id = "billing_address_2")
	private WebElement billing_address_2;
	
	@FindBy(id = "billing_city")
	private WebElement billing_city;
		
	@FindBy(id = "billing_state")
	private WebElement State1;
	
	@FindBy(id = "billing_postcode")
	private WebElement billing_postcode;
	
	@FindBy(id = "billing_phone")
	private WebElement billing_phone;
	
	@FindBy(id = "billing_email")
	private WebElement billing_email;
	
	@FindBy (id="place_order")
	private WebElement placeorder;
	
	
	@FindBy(xpath="//ul[@class=\"woocommerce-error\"]")
	private WebElement successmessage;
	
	public ChekoutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void SelectState(String text)
	{
		State1.click();
		Select s= new Select(State1);
		s.deselectAll();
		s.selectByVisibleText(text);
	}
	
	public PlaceOrderPage Enter_valid_details_Proceed(String FirstName , String LastName, String Compname , String Add1,String Add2 , String City,String State , String pin ,String phone , String Email)
	{
		firstname.sendKeys(FirstName);
		lastname.sendKeys(LastName);
		billing_company.sendKeys(Compname);
		billing_address_1.sendKeys(Add1);
		billing_address_2.sendKeys(Add2);
		billing_city.sendKeys(City);
		//State.clear();
		Select s= new Select(State1);
		s.deselectAll();
		s.selectByValue(State);
		billing_postcode.sendKeys(pin);
		billing_phone.sendKeys(phone);
		billing_email.sendKeys(Email);
		placeorder.click();
		return new PlaceOrderPage();
	}
	
	public String check_placeholder_button(String FirstName , String LastName, String Compname , String Add1,String Add2 , String City,String State , String pin ,String phone , String Email)
	{
		firstname.sendKeys(FirstName);
		lastname.sendKeys(LastName);
		billing_company.sendKeys(Compname);
		billing_address_1.sendKeys(Add1);
		billing_address_2.sendKeys(Add2);
		billing_city.sendKeys(City);
		Actions a = new Actions(driver);
	    Action Element = a.moveToElement(State1).click().build();
	    Element.perform();
	    Select s = new Select(State1);
	    s.selectByVisibleText(State);
	    
		//SelectState(state);
		billing_postcode.sendKeys(pin);
		billing_phone.sendKeys(phone);
		billing_email.sendKeys(Email);
		placeorder.click();
		return successmessage.getText();
	}
	
	public void invalid_deatils_to_proceed(String FirstName , String LastName, String Compname , String Add1,String Add2 , String City,String state , String pin ,String phone , String Email)
	{
		firstname.sendKeys(FirstName);
		lastname.sendKeys(LastName);
		billing_company.sendKeys(Compname);
		billing_address_1.sendKeys(Add1);
		billing_address_2.sendKeys(Add2);
		billing_city.sendKeys(City);
		SelectState(state);
		billing_postcode.sendKeys(pin);
		billing_phone.sendKeys(phone);
		billing_email.sendKeys(Email);
		placeorder.click();
		
	}
	public String check_coupon_code_accepted(String coponcode)
	{
		discountcode.click();
		couponcode.sendKeys(coponcode);
		appybtn.click();
		return couponsmsg.getText();
	}
	
}


