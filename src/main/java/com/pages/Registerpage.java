package com.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

import org.openqa.selenium.WebElement;

public class Registerpage extends TestBase {
	@FindBy(id="reg_billing_first_name")
	private WebElement reg_firstname;

	@FindBy(id="reg_billing_last_name")
	private WebElement reg_lastname;

	@FindBy(id ="reg_email")
	private WebElement reg_email;

	@FindBy(id="reg_password")
	private WebElement reg_password;

	@FindBy(name="register")
	private WebElement regbtn;

	@FindBy(linkText ="Become a Vendor")
	private WebElement vendor_link;

	@FindBy(id="user_email")
	private WebElement vendor_email;

	@FindBy(id="store_name")
	private WebElement StoreNme;

	@FindBy(id="passoword")
	private WebElement password;

	@FindBy(id="confirm_pwd")
	private WebElement confirm_pwd;

	@FindBy(name="save-data")
	private WebElement Regvenbtn;

  public Registerpage()
  {
	  PageFactory.initElements(driver,this);
  }
  
  public void vaildregisterData(String FirstName,String Lastname,String Email,String Password)
  {
  reg_firstname.sendKeys(FirstName);
  reg_lastname.sendKeys(Lastname);
  reg_email.sendKeys(Email);
  reg_password.sendKeys(Password);
  }
  public void Become_vendor(){
  vendor_link.click();
  }

  public void invaildregisterData(String FirstName,String Lastname,String Email,String Password)
  {
  reg_firstname.sendKeys(FirstName);
  reg_lastname.sendKeys(Lastname);
  reg_email.sendKeys(Email);
  reg_password.sendKeys(Password);
  }


  public void Vendor_ValidRegistration(String Email,String Storename,String Password,String ConfirmPassword){
        Become_vendor();
	  vendor_email.sendKeys(Email);
  StoreNme.sendKeys(Storename);
  password.sendKeys(Password);
  confirm_pwd.sendKeys(ConfirmPassword);
  Regvenbtn.click();

  }

  public void Vendor_inValidRegistration(String Email,String Storename,String Password,String ConfirmPassword){
	  Become_vendor();
	  vendor_email.sendKeys(Email);
  StoreNme.sendKeys(Storename);
  password.sendKeys(Password);
  confirm_pwd.sendKeys(ConfirmPassword);
  Regvenbtn.click();

  }



}
