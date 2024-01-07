package dataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderJavaC {
	// multiple set of data to our tests
	//array
	//5 sets of data as 5 arrays from data provider to your tests
	//then your test will run 5 times with 5 separates sets of data(array)
	
	DataFormatter formatter=new DataFormatter();
	
	
	@Test(dataProvider = "driveTest")
	public void testCaseData(String greeting, String communication, String id) {
		System.out.println("ID NO:"+id+" saying "+greeting+" "+communication+".");
	}
	@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException {
		//Object [][] dp= {{"hello","text","1"},{"bye","message","143"},{"solo","call","456"}};
		//return dp;
		// Instead of hard coding- we're going to drive from Excel
		// each is treated as an Array
			FileInputStream fis = new FileInputStream("D:\\IT Skill Up Zone - Practicals\\Rahul Shetty Academy 2\\excelDataProvider\\excelDriven.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheetAt(0);
			
			//no.of.rows
			int rowCount = sheet.getPhysicalNumberOfRows();
			
			
			//NO.OF.COLS
			//No direct method to get column
			XSSFRow row=sheet.getRow(0);
			int colCount = row.getLastCellNum();
			
			
			//creating multi dim array object - important
			Object[][] dp= new Object[rowCount-1][colCount];
			// dp[0][1]="hello";
			// LIVE DEMO ON INTEGRATING EXCEL INTO DATA PROVIDER to PARAMETERIZE DATA
			for (int i = 0; i < rowCount-1; i++) {
				row= sheet.getRow(1+i); // to avoid first row on Excel sheet
				for(int j=0; j<colCount;j++) {
					//System.out.println(row.getCell(j));
					XSSFCell  Cell= row.getCell(j);
					dp[i][j]=formatter.formatCellValue(Cell);
					
					//dp[i][j]=row.getCell(j);
					//System.out.println(dp[i][j]);
				}
			}
			return dp;
			
		}
}
