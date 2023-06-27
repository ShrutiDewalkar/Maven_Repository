package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	//@AuthorName: Sanjay
		//This method is use to get Test data from excel.
		//need to pass 2 inputs: 1-rowIndex, 2-colIndex
		public static String getTestData(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException
		{
			FileInputStream file=new FileInputStream("C:\\Users\\Suraj\\eclipse-workspace\\Maven_Project_selenium\\TestData_OfProject\\Excel data fetching.xlsx");
			Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
			
			//String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
			String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
			return value;
		}
		
		public static void captureSS(WebDriver driver, int TCID) throws IOException 
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\Users\\Suraj\\eclipse-workspace\\Maven_Project_selenium\\FailedTestCases-SS\\TestCaseID"+TCID+".jpg");
			FileHandler.copy(src, dest);
			
		}
		
		
		public static String getPFData(String key) throws IOException 
		{
			FileInputStream file=new FileInputStream("C:\\Users\\Suraj\\eclipse-workspace\\Maven_Project_selenium\\PropertyFile.properties");
			
			Properties p=new Properties();
			p.load(file);
			
			String value = p.getProperty(key);
			
			return value;
		}
}
