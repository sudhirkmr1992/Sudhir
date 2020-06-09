package DataDrivenTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import JavaExcelCode.Xls_Reader;

public class Read_WriteHtmltable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
	   
	    ChromeOptions optn = new ChromeOptions();
	    optn.addArguments("headless");
	    WebDriver driver = new ChromeDriver(optn);
	    driver.get("https://www.w3schools.com/html/html_tables.asp");
	    Thread.sleep(3000);
	 // these are real xpath so we have to devide it for getting all row value 
	    //table[@id='customers']/tbody/tr[2]/td[1]
	  //table[@id='customers']/tbody/tr[3]/td[1]
	  //table[@id='customers']/tbody/tr[4]/td[1]
	    String companyfirstpart= "//table[@id='customers']/tbody/tr[";
	    String companysecodpart = "]/td[1]";
	    
	    String contactfirstpart= "//table[@id='customers']/tbody/tr[";
	    String contactsecodpart = "]/td[2]";
	    
	    String countryfirstpart= "//table[@id='customers']/tbody/tr[";
	    String countrysecodpart = "]/td[3]";
	    
	    //here I have given i<=7 hardcoded way if we want to make it generic check below
	    //for (int i=2;i<=7;i++)
	   List<WebElement> rowcount =driver.findElements(By.xpath("//table[@id='customers']/descendant::tr"));
	  // System.out.println(rowcount.size());
	   //here adding table and printing all html table data in csv Flipkart sheet
	   Xls_Reader data = new Xls_Reader("D:\\WorkSpace\\SeleniumAutomation\\src\\CSVdata\\Ebaydata.xlsx");
	   if (!data.isSheetExist("gunu")) {
	   data.addSheet("gunu");
	   data.addColumn("gunu", "Company");
	   data.addColumn("gunu", "Contact");
	   data.addColumn("gunu", "Country");}
	   else {
		   System.out.println("Same sheet already present");
	   }
	    for(int rowno=2;rowno<=rowcount.size();rowno++)
	    {
	    String	Actualxpath = companyfirstpart+rowno+companysecodpart;
	    
	    System.out.println("========================");
	  String company =  driver.findElement(By.xpath(Actualxpath)).getText();
	  System.out.println(company);
	  
	  String	Actualxpath1 = contactfirstpart+rowno+contactsecodpart;
	  String contact =  driver.findElement(By.xpath(Actualxpath1)).getText();
	  System.out.println(contact);
	  
	  String	Actualxpath2 = countryfirstpart+rowno+countrysecodpart;
	  String country =  driver.findElement(By.xpath(Actualxpath2)).getText();
	  System.out.println(country);
	 //adding values in excell sheet
	  data.setCellData("gunu", "Company", rowno, company);
	  data.setCellData("gunu", "Contact", rowno, contact);
	  data.setCellData("gunu", "Country", rowno, country);
	 

	}
	    }

}
