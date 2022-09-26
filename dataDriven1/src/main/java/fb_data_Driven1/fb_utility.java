package fb_data_Driven1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fb_utility {

	public static String TestDataPath="C:\\Users\\user\\eclipse-workspace\\FB.Automation\\src\\main\\java\\FB\\TestData\\Facebook_Reg.xlsx";


	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;

	public static Object[][]getTestData(String SheetName) throws InvalidFormatException, IOException{
	    FileInputStream file=null;
	    try {
	        file=new FileInputStream(TestDataPath);
	    } catch (FileNotFoundException e) {        
	        e.printStackTrace();
	    }
	    book= WorkbookFactory.create(file);
//	    try {
//	        book= WorkbookFactory.create(file);
//	    } catch (EncryptedDocumentException | IOException e) {        
//	        e.printStackTrace();
	    
	    sheet = book.getSheet(SheetName);
	    Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	    for(int i=0; i<sheet.getLastRowNum();i++) {
	        for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
	            data[i][k] = sheet.getRow(i+1).getCell(k).toString();
	        }
	    }
	    return data;    
	}
}
