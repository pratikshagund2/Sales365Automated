package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.Registerpage;
import com.testbase.TestBase;
import com.utility.ExcelUtilsEx2Reg;

public class Regestration_Test extends TestBase{
	HomePage hm;
	Registerpage rp;
	public Regestration_Test()
	{
		super();
	}
	
	
	@BeforeMethod
	public void Setup()
	{
	initialization();
	hm = new HomePage();
	rp= new Registerpage();

	}

	@Test(priority=1)
	public void  check_valid_registration(){
	hm.click_myaccountlink();
	rp.vaildregisterData(prop.getProperty("RegFirstname"),prop.getProperty("RegLastname"),prop.getProperty("RegEmail"),prop.getProperty("RegPassword"));

}
	
	
	
	@Test(priority=2,dataProvider = "getRegisterdata")
	public void check_invalid_data(String FirstName,String Lastname,String Email,String Password)
	{
	hm.click_myaccountlink();
	rp.invaildregisterData(FirstName, Lastname, Email, Password);
	}

   @DataProvider
   public Object[][] getRegisterdata() throws Exception{
	Object[][] testdata = ExcelUtilsEx2Reg.getTableArray("C:mysheets//Login.xlsx","Sale365Register");
	return testdata;
	   
   }
   @Test(priority = 3)
	public void check_valid_vendor_regestration()
	{
		hm.click_myaccountlink();
		rp.Vendor_ValidRegistration(prop.getProperty("VendorEmail"), prop.getProperty("StoreName"), prop.getProperty("VendorPassword"), prop.getProperty("VendorConfirmpassword"));
	}
   
   @Test(dataProvider = "getvendorRegisterdata",priority= 4)
	public void check_invalid_vendor_regestration(String Email,String store,String pwd , String cnfmpwd)
	{
		hm.click_myaccountlink();
		rp.Vendor_inValidRegistration(Email, store, pwd, cnfmpwd);
	}
   @DataProvider
   public Object[][] getvendorRegisterdata() throws Exception{
	Object[][] testdata = ExcelUtilsEx2Reg.getTableArray("C:mysheets//Login.xlsx","Sale365VendorReg");
	return testdata;
	   
   }
   @AfterMethod
   public void TearDown()
   {
	   driver.quit();
   }
   
}