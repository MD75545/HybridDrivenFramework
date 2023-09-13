package TestCases;

import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.Base;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.XlUtility;
import UtilityPackage.Property;

public class LoginFunctionality extends Base {
	public LoginPage login;
	public Homepage home;
	Property pro = new Property();
	
	
	public void LoginWithValid() {
		login = new LoginPage(driver);
		Reporter.log("1)Launch the browzwer");
		login.UsernameSendkey(pro.getUsername());
		Reporter.log("2)Enter Username");
		login.Passwordsendkeys(pro.getPassword());
		Reporter.log("3)Enter password");
		home = login.ClickonLoginButton();
		Reporter.log("4)Click on loginbuton");
		
		Reporter.log("5)Get Title");
		String title = home.getTitle();
		System.out.println("Home Page Title is " + title);
		
		String ExpectedTitle="Salesboom.com - Home";
		Assert.assertEquals(ExpectedTitle, title);
		
		Reporter.log("6)Get Url");
		String url = home.getUrl();
		System.out.println("Home page URL is" + url);
		
		String ExpectedUrl="https://secure4.salesboom.com/servlet/content";
		Assert.assertEquals(ExpectedUrl, url);
	
		
			
		}
	@Test(dataProvider = "containA")
	public void loginWithInvalidData(String username,String password,String value) {
		System.out.println("Enter the username");
		login = new LoginPage(driver);
		Reporter.log("1)Launch the browzwer");
		login.UsernameSendkey(username);
		Reporter.log("2)Enter Username");
		login.Passwordsendkeys(password);
		Reporter.log("3)Enter password");
		home = login.ClickonLoginButton();
		Reporter.log("4)Click on loginbuton");
	}
	
	@DataProvider(name = "containA")
	@Test
	public String[][] container() throws EncryptedDocumentException, IOException {
		
		
		  String path="C:\\Users\\hp\\Desktop\\InvalidData1.xlsx";
		   String sheetname="Invalid1";
		   XlUtility xl=new XlUtility(path, sheetname);
		   int Colcount=xl.getColumnCount(path, sheetname);
		  int RowCount =xl.getColumnCount(path, sheetname);
		  System.out.println("column Count is "+Colcount);
		  System.out.println("Row Count is "+RowCount);
		  String Data[][]=new String[RowCount][Colcount];
		  for(int i=1;i<=RowCount;i++) {
			  for(int j=0;j<Colcount;j++)
			  {
				  Data[i-1][j]=xl.getCellValue(path, sheetname, i, j);
			  }
		  }
		return Data;
	}

}
