package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class Navigation_pages extends TestBase {
	
	@FindBy (linkText = "About Us")
	private WebElement aboutlink;
	
	@FindBy (xpath = "//*[@id=\"nav-menu-item-3272\"]/a")
	private WebElement fashsale;
	
	@FindBy(xpath = "//*[@id=\"nav-menu-item-3476\"]/a")
	private WebElement elect;
	
	@FindBy (xpath = "//*[@id=\"nav-menu-item-3477\"]/a")
	private WebElement sport;
	
	@FindBy(xpath = "//*[@id=\"nav-menu-item-3536\"]/a")
	private WebElement my_wallet;
	
	@FindBy(xpath="//*[@id=\"nav-menu-item-3184\"]/a")
	private WebElement home;
	
	
	public Navigation_pages()
	{
	PageFactory.initElements(driver,this);
	}
	
	
	public void check_all_aboutlink_is_clickable()
	{
		aboutlink.isDisplayed();
		aboutlink.isEnabled();
				
		home.isDisplayed();
		home.isEnabled();
		
			}
	
	public void Check_eleclink_is_clickable()
	{
		elect.isDisplayed();
		elect.isEnabled();
	}
	
	public boolean Check_sportlink_is_clickable()
	{
		sport.isDisplayed();
		 return sport.isEnabled();
		 
	}
	public void Check_mywalletlink_is_clickable()
	{
		my_wallet.isDisplayed();
		my_wallet.isEnabled();
	}
	public FashionSalePage Check_fashoin_link_clickable()
	{
		fashsale.click();
		return new FashionSalePage() ;
	}
	
	public HomePage Click_on_Home_page()
	{
		home.click();
		return new HomePage();
	
	}
	

	

}
