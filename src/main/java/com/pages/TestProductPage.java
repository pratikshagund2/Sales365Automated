package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class TestProductPage extends TestBase{
	
	
	@FindBy (xpath= "//*[@id=\"product-3533\"]/div[1]/div/div[2]/form/div/button[2]")
	private WebElement buttonplus;
	
	@FindBy(xpath ="//*[@id=\"product-3533\"]/div[1]/div/div[2]/form/div/button[1]")
	private WebElement buttonminus;
	 
	@FindBy (xpath= "//input[@type='number']")
	private WebElement numberprodadded;
	
	@FindBy (xpath = "//*[@id=\"product-3533\"]/div[1]/div/div[2]/div[5]/a/span[2]")
	private WebElement AskQueslink;
	
	@FindBy (xpath = "//button[@class='single_add_to_cart_button button alt']")
	private WebElement addcartbtn;
	
	@FindBy (xpath = "//*[@id=\"main\"]/div/div[1]")
	private WebElement Successfuladdedmsg;
	
	@FindBy(xpath = "//i[@class='minicart-icon porto-icon-bag-2']")
	private WebElement Carticon;
	@FindBy(xpath= "//a[@class='pull-right']")
	WebElement viewcart;
	
	
   public TestProductPage()
   {
	   PageFactory.initElements(driver,this);
   }
   
   public String Check_TitleofTestprodPage()
   {
	   return driver.getTitle();
   }
   
   public void check_same_product_add()
   {
	   buttonplus.click();
	   System.out.println( numberprodadded.getText());
	   }
   
public void check_same_product_delete()
{
	   buttonminus.click();
	  System.out.println( numberprodadded.getText());
		
	
	   }


public boolean check_Askquestionclick_clikable()
{
	return AskQueslink.isEnabled();
}

public boolean Check_add_to_cart_functionality()
{
	addcartbtn.click();
	String sumsg= Successfuladdedmsg.getText();
  return Successfuladdedmsg.isDisplayed();
}

public ViewCartPage Click_View_cart()
{
	Carticon.click();
	viewcart.click();
	return new ViewCartPage();
}

}
