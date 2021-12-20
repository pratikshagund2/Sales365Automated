package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.testbase.TestBase;

public class FashionSalePage extends TestBase{
	
	@FindBy (xpath= "//*[@id=\"woocommerce_product_categories-2\"]/ul/li[1]/a")
	private WebElement Accessories;
	
	@FindBy(xpath = "//*[@id=\"woocommerce_product_categories-2\"]/ul/li[1]/a")
	private WebElement ClothAcc;
	
	
	@FindBy(xpath="//*[@id=\"woocommerce_product_categories-2\"]/ul/li[2]/ul/li/a")
	private WebElement womencloth;
	
	@FindBy(xpath="//*[@id=\"woocommerce_product_categories-2\"]/ul/li[3]/a")
	private WebElement Demo_catg;
	
	@FindBy(xpath="//h3[@class=\"woocommerce-loop-product__title\"]")
	private WebElement TestingProd;
	
	
	
	@FindBy (xpath = "//*[@id=\"woocommerce_product_categories-2\"]/ul/li[4]/a")
	private WebElement Health_personal_care;
	
	@FindBy (xpath="//*[@id=\"woocommerce_product_categories-2\"]/ul/li[5]/a")
	private WebElement Home_kitchen;
	
	@FindBy (xpath="//*[@id=\"woocommerce_product_categories-2\"]/ul/li[6]/a")
	private WebElement limitedoffter;
	
	@FindBy (xpath ="//*[@id=\"content\"]/div[2]/form/select")
	private WebElement SortBy;
	
	@FindBy (id="grid")
	private WebElement Horizontal_view;
	
	@FindBy(id= "list")
	private WebElement listview; 
	
	
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div/ul")
	private List<WebElement> listofacc;
	
	/*@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/ul")
        private	WebElement listcloth;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/ul")
	 private WebElement listwomencloth;
	 
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div/ul")
	private WebElement listDemocat;
	
	@FindBy(xpath= "//*[@id=\"content\"]/div[3]/div/ul")
	private WebElement listHealth;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/ul")
	private WebElement listhome;*/
	
	
	public FashionSalePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean clickonaccessories()
	{
		Accessories.click();
		listofacc.size();
		for(WebElement lista : listofacc)
		{
			String listprint = lista.getText();
			System.out.println(listprint);
		}
		return Accessories.isDisplayed();
	}
	public boolean clickoncloth()
	{
		ClothAcc.click();
		listofacc.size();
		for(WebElement lista : listofacc)
		{
			String listprint = lista.getText();
			System.out.println(listprint);
		}
	
		return ClothAcc.isDisplayed();
	}
	public boolean clickonWomencloth()
	{
		womencloth.click();
		listofacc.size();
		for(WebElement lista : listofacc)
		{
			String listprint = lista.getText();
			System.out.println(listprint);
		}
		return womencloth.isEnabled();
		
	}
	
	public boolean clickonDemoCateg()
	{
		Demo_catg.click();
		listofacc.size();
		for(WebElement lista : listofacc)
		{
			String listprint = lista.getText();
			System.out.println(listprint);
		}
		return Demo_catg.isEnabled();
		
	}
	
	public boolean clickonHealthCare()
	{
		Health_personal_care.click();
		listofacc.size();
		for(WebElement lista : listofacc)
		{
			String listprint = lista.getText();
			System.out.println(listprint);
		}
		return Health_personal_care.isEnabled();
		
	}
	
	public boolean clickonHomeKitchen()
	{
		Home_kitchen.click();
		listofacc.size();
		for(WebElement lista : listofacc)
		{
			String listprint = lista.getText();
			System.out.println(listprint);
		}
		return Home_kitchen.isEnabled();
		
	}
	public boolean clickonlimitedtimedeal()
	{
		limitedoffter.click();
		listofacc.size();
		for(WebElement lista : listofacc)
		{
			String listprint = lista.getText();
			System.out.println(listprint);
		}
		return limitedoffter.isEnabled();
		
	}
	
	public boolean Select_filter_lowtohigh()
	{
		Accessories.click();
		SortBy.click();
		Select s = new Select(SortBy);
		s.selectByVisibleText("Sort by price: low to high");
		listofacc.size();
		for(WebElement lista : listofacc)
		{
			String listprint = lista.getText();
			System.out.println(listprint);
		}
		return SortBy.isSelected();
		
	}
	
	public boolean Select_filter_hightolow()
	{
		Accessories.click();
		SortBy.click();
		Select s = new Select(SortBy);
		s.selectByVisibleText("Sort by price: high to low");
		listofacc.size();
		for(WebElement lista : listofacc)
		{
			String listprint = lista.getText();
			System.out.println(listprint);
		}
		return SortBy.isSelected();
		
	}
	
	public boolean Select_filter_Sortbypopularity()
	{
		Accessories.click();
		SortBy.click();
		Select s = new Select(SortBy);
		s.selectByVisibleText("Sort by popularity");
		listofacc.size();
		for(WebElement lista : listofacc)
		{
			String listprint = lista.getText();
			System.out.println(listprint);
		}
		return SortBy.isSelected();
		
	}
	
	public boolean Check_Grid_view_product()
	{
		Horizontal_view.click();
		listofacc.size();
		for(WebElement lista : listofacc)
		{
			String listprint = lista.getText();
			System.out.println(listprint);
		}
		return Horizontal_view.isDisplayed();
		
	}
	public boolean Check_List_view_product()
	{
		listview.click();
		listofacc.size();
		for(WebElement lista : listofacc)
		{
			String listprint = lista.getText();
			System.out.println(listprint);
		}
		return listview.isDisplayed();
		
	}
	
	
	public  TestProductPage ClickOnTestingproductlink()
	{
		TestingProd.click();
		return new TestProductPage();
	}
}
