package excelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public ArrayList<String> getData(String testCaseName) throws IOException {
		//-2
		ArrayList<String> a=new ArrayList<String>();
		
		
		//Identifying Testcases column by Scanning the entire first row
		//Once column is identified then scan entire testcase coluumn to identify purchase testcase row
		//after you grab purchase testcase row pull all the data of the row and 
		
		
		
		//STEP 1 - CREATE OBJECT TO XSSFWORKBOOK CLASS
		// 1.1 CREATE FileInputStream argument
		
		FileInputStream fis=new FileInputStream("D:\\IT Skill Up Zone - Practicals\\Rahul Shetty Academy 2\\excelDriven\\testData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);   //create a method using a class
		
		int sheets= workbook.getNumberOfSheets();
		
		//STEP 2 - Identifying Testcases column by Scanning the entire first row
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testData")) {
				XSSFSheet sheet= workbook.getSheetAt(i);
				
				//Identifying Testcases column by Scanning the entire first row
				Iterator<Row> rows= sheet.iterator();  //sheet is collection of rows
				
				Row firstRow= rows.next();
				
				Iterator<Cell> ce = firstRow.cellIterator();  //row is collection of cell
				
				int k=0;
				int column = 0;
				while(ce.hasNext()) {
					Cell value= ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						//desired column
						column=k;
					}
					k++;
					
				}
				System.out.println(column);
				
				//STEP 3 - Once column is identified then scan entire testcase coluumn to identify purchase testcase row
				//if first row present go next
				while(rows.hasNext()){
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						//after you grab purchase testcase row pull all the data of the row 
						Iterator<Cell> cv=r.cellIterator();
						while(cv.hasNext()) {
							//cv.next().getStringCellValue();
							//System.out.println(cv.next().getStringCellValue());
							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING) {
								a.add(c.getStringCellValue());
							}else {
								//NumberToTextConverter.toText(c.getNumericCellValue());
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								// a.add(c.getNumericCellValue());
							}
						
							//a.add(cv.next().getStringCellValue());							
						}
					}				
				}				
			}				
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
	}

}
