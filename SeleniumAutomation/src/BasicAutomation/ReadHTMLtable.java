package BasicAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadHTMLtable {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
		   
	    ChromeOptions optn = new ChromeOptions();
	    optn.addArguments("headless");
	    WebDriver driver = new ChromeDriver(optn);
	    
	    driver.get("https://www.w3schools.com/html/html_tables.asp");
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='customers']/descendant::tr")));
	    List<WebElement> count = driver.findElements(By.xpath("//table[@id='customers']/descendant::tr"));
	    System.out.println(count.size());
	    String companyfirstpart= "//table[@id='customers']/tbody/tr[";
	    String companysecodpart = "]/td[1]";
	    
	    for (int i =2;i<=count.size() ;i++) {
	    	String	Actualxpath = companyfirstpart+i+companysecodpart;
	    	 String s = driver.findElement(By.xpath(Actualxpath)).getText();
	  	   System.out.println(s);
	    }
	 
	}

}
