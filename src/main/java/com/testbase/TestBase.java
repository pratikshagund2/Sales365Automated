package com.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;




public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	//public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/configure" +"/configure.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C://Driver//chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C://Driver//geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		
	/*	e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	 public static String capture(String screenshotName) throws IOException {
		 File source =( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       
	        String dest = System.getProperty("user.dir") + "/ErrorScreenshot/"+ screenshotName + ".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);
	        return dest;
	    }
	
	

}
