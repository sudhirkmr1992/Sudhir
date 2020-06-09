package BasicAutomation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JavaExcelCode.Xls_Reader;

public class DataProvider {

	static WebDriver driver;
	static  Xls_Reader data;
	 
	 @BeforeMethod
	 public static void Basic() {
		 System.setProperty("webdriver.chrome.driver", "D:\\\\Software\\\\Selenium\\\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://en-gb.facebook.com/r.php");
		 
	 }
	 
//	@DataProvider
	 public static Iterator<Object[]> requiredData() {
		ArrayList<Object[]> testinput = GetTestData.CsvData();
		 return testinput.iterator();
	 }
	 
	 @Test(dataProvider="requiredData")
	 public void Test1(String firstname,String lastname,String adrs,String phno) {
		 driver.findElement(By.xpath("//input[@name ='firstname']")).clear();;
		    driver.findElement(By.xpath("//input[@name ='firstname']")).sendKeys(firstname);
		    driver.findElement(By.xpath("//input[@name ='lastname']")).clear();
		    driver.findElement(By.xpath("//input[@name ='lastname']")).sendKeys(lastname);
		    driver.findElement(By.xpath("//input[@name ='reg_email__']")).clear();
		    driver.findElement(By.xpath("//input[@name ='reg_email__']")).sendKeys(phno);
		    driver.findElement(By.xpath("//input[@name='reg_passwd__']")).clear();
		    driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(adrs);
		    driver.findElement(By.xpath("//input[@id='u_0_7']")).click();
	 }
	 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
	 
}


class GetTestData{
	static Xls_Reader data1 ;
	
	public static  ArrayList<Object[]> CsvData() {
		ArrayList<Object[]> data =  new ArrayList<Object[]>();
	try {
		Xls_Reader data1 = new Xls_Reader("D:\\WorkSpace\\SeleniumAutomation\\src\\CSVdata\\Ebaydata.xlsx");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	for (int rowno=2;rowno<= data1.getRowCount("Ebaydata");rowno++) {
		String firstname = data1.getCellData("Ebaydata", "FirstName", rowno);
		String lastname = data1.getCellData("Ebaydata","LastName", rowno);
		String adrs = data1.getCellData("Ebaydata", "Address1", rowno);
		String phno = data1.getCellData("Ebaydata", "PhoneNumber", rowno);
		Object[] obj = new Object[] {firstname,lastname,adrs,phno};
		data.add(obj);
	}
	return data;
 	}
}
