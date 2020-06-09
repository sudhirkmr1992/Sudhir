package DataDrivenTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import JavaExcelCode.Xls_Reader;

public class Readdata {

	public static void main(String[] args) {
		Xls_Reader data = new Xls_Reader("D:\\WorkSpace\\SeleniumAutomation\\src\\CSVdata\\Ebaydata.xlsx");
		String firstname=data.getCellData("Ebaydata", "FirstName", 2);
		System.out.println(firstname);
		String lastname=data.getCellData("Ebaydata", "LastName", 2);
		System.out.println(lastname);
		String phonenumber=data.getCellData("Ebaydata", "PhoneNumber", 2);
		System.out.println(phonenumber);
		String address=data.getCellData("Ebaydata", "Address1", 2);
		System.out.println(address);
		 System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		    driver.get("https://en-gb.facebook.com/r.php");
		    driver.findElement(By.xpath("//input[@name ='firstname']")).sendKeys(firstname);
		    driver.findElement(By.xpath("//input[@name ='lastname']")).sendKeys(lastname);
		    driver.findElement(By.xpath("//input[@name ='reg_email__']")).sendKeys(phonenumber);
		    driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(address);
		    driver.findElement(By.xpath("//input[@id='u_0_7']")).click();
		  
		
		
	}

}
