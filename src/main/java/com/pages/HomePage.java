package com.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(tagName = "a")
	private List<WebElement> linklist; 
	
	@FindBy(tagName =  "img")
	private List<WebElement> img;
	
	
	@FindBy(xpath="//a[@class=\"my-account\"]")
	private WebElement Myaccount;
	

	@FindBy(name = "your-email")
	private WebElement enter_subscribe_email;
	
	@FindBy(xpath  = "//*[@id=\"wpcf7-f1512-o1\"]/form/div[2]/div[2]/input")
	private WebElement subscribe_btn;
	
	@FindBy(className = "wpcf7-response-output")
	private WebElement Subscribe_msg;
	
	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	
	
	
	}
	
	public String Find_broken_links_URL()  {
		linklist.addAll(img);
		System.out.println("Size of Full link & images:"+ linklist.size());
		
		List<WebElement> activelink = new ArrayList<WebElement>();

		for(int i=0;i<linklist.size();i++) {
			System.out.println(linklist.get(i).getAttribute("href"));
			System.out.println(linklist.get(i).getAttribute("src"));
			
		
			if(linklist.get(i).getAttribute("href") != null && (!linklist.get(i).getAttribute("href").contains("javascript")))
					{
				
			
			activelink.add(linklist.get(i));
		
	}}
//
		//get size of all active links
		System.out.println("Size of active links and images------>"+activelink.size());
		///Check the href url with http connection 
		
		
		for(int j=0;j<activelink.size(); j++) {
	try {
	HttpURLConnection conn		=	(HttpURLConnection)	new URL(activelink.get(j).getAttribute("href")).openConnection();
	
			conn.connect();
		String response =	conn.getResponseMessage();
		conn.disconnect();
		System.out.println(activelink.get(j).getAttribute("href")+ "------------>"+response);
	
		}catch (Exception e) {
			// TODO: handle exception
		}
	
}
		return driver.getCurrentUrl();
	}
	
	public String Find_broken_imges_URL()  {
		
		System.out.println("Size of Full link & images:"+ img.size());
		
		List<WebElement> activelink = new ArrayList<WebElement>();

		for(int i=0;i<img.size();i++) {
			//System.out.println(img.get(i).getAttribute("href"));
			System.out.println(img.get(i).getAttribute("src"));
			
		
			if(img.get(i).getAttribute("src") != null && (!img.get(i).getAttribute("src").contains("javascript")))
					{
				
			
			activelink.add(img.get(i));
		
	}}
//
		//get size of all active links
		System.out.println("Size of active links and images------>"+activelink.size());
		///Check the href url with http connection 
		
		
		for(int j=0;j<activelink.size(); j++) {
	try {
	HttpURLConnection conn		=	(HttpURLConnection)	new URL(activelink.get(j).getAttribute("src")).openConnection();
	
			conn.connect();
		String response =	conn.getResponseMessage();
		conn.disconnect();
		System.out.println(activelink.get(j).getAttribute("src")+ "------------>"+response);
	
		}catch (Exception e) {
			// TODO: handle exception
		}
	
}
		return driver.getCurrentUrl();
	}
	
	
	
	public loginpage Click_myAccount() {
		Myaccount.click();
		return new loginpage();
	}
	
	public Registerpage click_myaccountlink()
	{
		Myaccount.click();
		return new Registerpage();
	}
	public String Check_newsletterSubscribe(String SubcribeEmail) {
		enter_subscribe_email.sendKeys(SubcribeEmail);
		subscribe_btn.click();
	return Subscribe_msg.getText();
	}
}
		
