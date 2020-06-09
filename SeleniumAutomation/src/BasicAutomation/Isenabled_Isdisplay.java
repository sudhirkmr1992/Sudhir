package BasicAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Isenabled_Isdisplay {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		    driver.get("https://www.zoho.com/crm/lp/crm-software.html");
		    Boolean b1 = driver.findElement(By.xpath("//input[@id='signupbtn']")).isDisplayed();
		    System.out.println(b1);
		    Boolean b2 = driver.findElement(By.xpath("//input[@id='signupbtn']")).isEnabled();
		    System.out.println(b2);
		    Boolean b3 = driver.findElement(By.xpath("//span[@id='signup-termservice']")).isSelected();
		    System.out.println(b3);
		    
		    
		   
	}

}
