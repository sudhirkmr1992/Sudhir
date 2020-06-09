package BasicAutomation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsPopUpHandler {
 public static void main(String[] args) throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("//a[text()='Good PopUp #3']")).click();
		Thread.sleep(3000);
		Set<String> handle= driver.getWindowHandles();      
	  Iterator<String> it =handle.iterator();
	  
	  String parentwindow = (String)it.next();	
	 System.out.println("Parent window name:-" + parentwindow);
	   
	  String childwindow = (String)it.next();
	  System.out.println("Child window name:-" + childwindow);
	  	  
	 WebDriver s = driver.switchTo().window(childwindow);
	  System.out.println(s.getTitle());
	  s.close();
	  
	 WebDriver s1 =  driver.switchTo().window(parentwindow);
	  System.out.println(s1.getTitle());
	  s1.close();
 } 


}
