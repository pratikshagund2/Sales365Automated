
package com.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class WishlistPage extends TestBase {
	
	
	
	@FindBy(xpath="//*[@id=\"nav-menu-item-3272\"]/a")
	private WebElement Fasale;
	
    @FindBy(xpath= "//img[@src=\"https://sale365days.co.in/wp-content/uploads/2020/11/mirchii-saree-3-min-300x300.jpg\"]")
    private WebElement producaddwhishlist;
    
    @FindBy(xpath="//img[@src=\"https://sale365days.co.in/wp-content/uploads/2020/11/Vrundavan-Ethics-Embroidered-Saree-3-300x300.jpg\"]")
    private WebElement addprodwish;
    @FindBy (xpath="//*[@id=\"product-3405\"]/div[1]/div/div[2]/div[5]/div/a")
    private WebElement wishlist;
    
    @FindBy(xpath= "//*[@id=\"product-3413\"]/div[1]/div/div[2]/div[5]/div/a")
    private WebElement wishlist1;
    
    @FindBy(xpath="//a[@href=\'https://sale365days.co.in/wishlist/\']")
    private WebElement wishlistsign;
    
  /*  @FindBy(className =  "shop_table cart wishlist_table wishlist_view traditional responsive")
    private WebElement tblewishlist;*/
    
    @FindBy(tagName = "tr")
    private List<WebElement> row;
    
    @FindBy(tagName = "th")
    private List<WebElement> col;
    
    
    public WishlistPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
   public void Element_added_wishlist()
    {
    	Fasale.click();
    	
    	producaddwhishlist.click();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("windows.scrollBy(0,250)", "");
    	
    	wishlist.click();
    	driver.navigate().back();
    	
    	addprodwish.click();
    	wishlist1.click();
    	
    }
    
    public String check_wishlist_product()
    {
    	wishlistsign.click();
    	return driver.getTitle();
    }
    
    public void checktable_visible() throws Exception
    {
           Fasale.click();
    	
    	/*producaddwhishlist.click();
    	Thread.sleep(1000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,150)", "");
    	wishlist.click();
    	driver.navigate().back();*/
    	Thread.sleep(1000);
    	addprodwish.click();
    	JavascriptExecutor js1 = (JavascriptExecutor) driver;
    	js1.executeScript("window.scrollBy(0,250)", "");
    	wishlist1.click();
    	Thread.sleep(3000);
    	wishlistsign.click();
    //	tblewishlist.click();
    	int x =row.size();
    	for(WebElement row1 : row)
    	{
    		
    		System.out.println(row1.getText());
    		col.size();
    		for(WebElement col1 : col) {
    			String x2 = col1.getText();
    			System.out.println(x2);
    		}
    	}
    	
    	
   
    }
    
}
