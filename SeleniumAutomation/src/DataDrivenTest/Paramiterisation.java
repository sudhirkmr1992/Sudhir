package DataDrivenTest;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import JavaExcelCode.Xls_Reader;

public class Paramiterisation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get("https://en-gb.facebook.com/r.php");
	  
		
		Xls_Reader data = new Xls_Reader("D:\\WorkSpace\\SeleniumAutomation\\src\\CSVdata\\Ebaydata.xlsx");
		int rowcount = data.getRowCount("Ebaydata");
				System.out.println(rowcount);	
				for(int rowno=2;rowno<=rowcount;rowno++) {
				System.out.println("+++++++++++++++++");
		String firstname=data.getCellData("Ebaydata", "FirstName", rowno);
		System.out.println(firstname);
		String lastname=data.getCellData("Ebaydata", "LastName",rowno);
		System.out.println(lastname);
		String phonenumber=data.getCellData("Ebaydata", "PhoneNumber", rowno);
		System.out.println(phonenumber);
		String address=data.getCellData("Ebaydata", "Address1", rowno);
		System.out.println(address);
		
		// insert into element
		driver.findElement(By.xpath("//input[@name ='firstname']")).clear();;
	    driver.findElement(By.xpath("//input[@name ='firstname']")).sendKeys(firstname);
	    driver.findElement(By.xpath("//input[@name ='lastname']")).clear();
	    driver.findElement(By.xpath("//input[@name ='lastname']")).sendKeys(lastname);
	    driver.findElement(By.xpath("//input[@name ='reg_email__']")).clear();
	    driver.findElement(By.xpath("//input[@name ='reg_email__']")).sendKeys(phonenumber);
	    driver.findElement(By.xpath("//input[@name='reg_passwd__']")).clear();
	    driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(address);
	    driver.findElement(By.xpath("//input[@id='u_0_7']")).click();
				}
	}

}
