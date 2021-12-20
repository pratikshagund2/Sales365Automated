package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class loginpage  extends TestBase{
	
	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id="password")
	private WebElement password;

	@FindBy(name = "login")
	private WebElement loginbtn;

	@FindBy(xpath="//a[@href='https://sale365days.co.in/my-account/lost-password/']")
	private WebElement lostPasswordlink;

   @FindBy(name="user_login")
   private WebElement Reco_email;
   
   @FindBy(xpath = "//button[@class=\"woocommerce-Button button btn-lg pt-right\"]")
   private WebElement reset_btn;
   
   public loginpage()
   {
	   PageFactory.initElements(driver, this);
   }
   
   public void Enterusername(String Username)
   {
	  username.sendKeys(Username);
   }
   
   public void EnterPassword(String Password)
   {
	   password.sendKeys(Password);
   }
   public void click_login()
   {
	   loginbtn.click();
   }
   
   public String validlogincredentials(String Username ,String Password){
	   Enterusername(Username);
	   EnterPassword(Password);
	   click_login();
	return driver.getTitle();
   }
  
   public void invalidLogindetail(String Username , String Password) {
	   Enterusername(Username);
	   EnterPassword(Password);
	   click_login();
   }
   
   public boolean checklostpasswordlink()
   {
	   return lostPasswordlink.isDisplayed();
   }
   
   public String Check_lost_password_functionality()
   {
	   lostPasswordlink.click();
	   return driver.getTitle();
   }
   
   public String ResetPasswordFuctionality(String Username)
   {
	   lostPasswordlink.click();
	   Reco_email.sendKeys(Username);
	   reset_btn.click();
	   return driver.getTitle();
   }
   
   
}
