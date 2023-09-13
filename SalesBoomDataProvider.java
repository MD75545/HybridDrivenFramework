package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SalesBoomDataProvider {
	public WebDriver driver;

	@Test(dataProvider = "ContainerA")
	public void testcontainer(String username, String password, String Datatype) {
	System.out.println("Username is "+username+"password is "+password+"datatype is "+Datatype);
		driver = new ChromeDriver();
	}
	@DataProvider(name="Container A")
	   public String[][] name() throws EncryptedDocumentException, IOException{
		   String path="C:\\Users\\hp\\Desktop\\InvalidData1.xlsx";
		   String sheetname="Invalid1";
		   XlUtility xl=new XlUtility(path, sheetname);
		   int Colcount=xl.getColumnCount(path, sheetname);
		  int RowCount =xl.getColumnCount(path, sheetname);
		  System.out.println("column Count is "+Colcount);
		  System.out.println("Row Count is "+RowCount);
		  String Data[][]=new String[RowCount][Colcount];
		  for(int i=1;i<=RowCount;i++) {
			  for(int j=1;j<=Colcount;j++)
			  {
				  Data[i-1][j]=xl.getCellValue(path, sheetname, i, j);
			  }
		  }
		return Data;
	   }
}
