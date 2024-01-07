package dataBaseTesting1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException, InterruptedException {
		// TODO Auto-generated method stub
		String host="localhost";
		String port="3306";
		String databasename="qadbt";
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		Connection con = DriverManager.getConnection( "jdbc:mysql://" + host + ":" + port + "/"+databasename, "root", "Kamal98*");
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
		/* "jdbc:mysql://" + host + ":" + port + "/databasename";
		 * "jdbc:mysql://" + localhost + ":" + 3306 + "/qadbt";
		 */
		
		Statement s = con.createStatement();//statement is like a road
		ResultSet rs = s.executeQuery("select * from EmployeeInfo where name='sam';");
		while(rs.next()) {
			 String l1= rs.getString("location");
			 int a1= rs.getInt("age");
			 System.out.println(l1+"\n"+a1);
			 
			 driver.get("https://locations.dennys.com/search.html/");
			 Thread.sleep(3600);
			 driver.findElement(By.cssSelector("input#q")).sendKeys(rs.getString("location"));
			 
			 
		}

		
	}

}
