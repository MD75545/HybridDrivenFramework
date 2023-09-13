package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XlUtility {
	public String path;
	public String sheetname;
	
	public XlUtility(String path,String sheetname) {
		this.path=path;
		this.sheetname=sheetname;
	}
	public int getColumnCount(String path,String sheetname) throws EncryptedDocumentException, IOException {
		File F1=new File(path);
		FileInputStream input=new FileInputStream(F1);
		Workbook wb=WorkbookFactory.create(input);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(0);
		int columncount=rw.getLastCellNum();
		return columncount;
		
	}
	public int getRowCount(String path,String sheetname) throws EncryptedDocumentException, IOException {
		File F1=new File(path);
		FileInputStream input=new FileInputStream(F1);
		Workbook wb=WorkbookFactory.create(input);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(0);
		int rowcount=rw.getRowNum();
		return rowcount; 

	}
	public String getCellValue(String path,String sheetname,int row,int column) throws EncryptedDocumentException, IOException {
		File F1=new File(path);
		FileInputStream input=new FileInputStream(F1);
		Workbook wb=WorkbookFactory.create(input);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(row);
		Cell cl=rw.getCell(column);
		int rowcount=rw.getRowNum();
		String Data="";
		try {
			DataFormatter formatter=new DataFormatter();
			Data=formatter.formatCellValue(cl);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Data;
	}
}