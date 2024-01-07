package excelDriven;

import java.io.IOException;
import java.util.ArrayList;

public class simpleTestClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		dataDriven dd=new dataDriven();
		// same for Selenium and Appium
		
		ArrayList data=dd.getData("AddProfile");
		
		for(int i=0;i<data.size();i++) {
			System.out.println(data.get(i));
		}
	}

}
