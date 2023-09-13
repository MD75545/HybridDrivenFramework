package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import UtilityPackage.Property;

@Test
public class Base {
	public WebDriver driver;
@BeforeMethod
	public void Launching() {
		
		Property pro= new Property();
		String Browser=pro.getsBrowzer();
		if (Browser.equals("ChromeBrowzer")) {
			Reporter.log("To launch the browzer");
			 driver=new ChromeDriver();
			driver.get(pro.getUrl());
			
		}
		
		
	}
	
@AfterMethod
	public void TearDown() {
	Reporter.log("To close the browzer");
		driver.close();
		
	}
}
