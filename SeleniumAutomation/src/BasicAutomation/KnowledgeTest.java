package BasicAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KnowledgeTest {
	static WebDriver driver;
	public static void main(String[] args) throws IOException,FileNotFoundException,NullPointerException, InterruptedException{
		System.setProperty("webdriver.chrome.driver","D:\\Software\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		System.out.println(ele.size());
		for(int i=1;i<ele.size();i++) {
			System.out.println(ele.get(i).getText());
		}
//		driver.findElement(By.xpath("//div[@class='RNNXgb']//div//div[2]//input[@title='Search']")).sendKeys("selenium");
//		Thread.sleep(2000);
//		List<WebElement> element =  driver.findElements(By.xpath("//ul[@class='erkvQe']//descendant::li[@class='sbct']"));
//		System.out.println(element.size());
//		for (int i=0; i<element.size();i++) {
//			String s = element.get(i).getText();
//			System.out.println(s);
//		}
//		
//		for (int i=0;i<element.size();i++) {
//			String s1 = element.get(i).getText();
//			if (s1.contains("selenium python")) {
//				element.get(i).click();
//				break;
//			}
//			
//		}
		
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("batchautomation");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@12345");
//		driver.findElement(By.xpath("//input[@value='Login']")).submit();
 
 
         //Explicit wait =================
// Wait(driver,driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")),20);
		//AlertMesage ================
 //generateAlertMessage(driver,"working fine");
		
		// boarder check ============
//drawBoarder(driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")),driver);
	//ALert ============	
// Thread.sleep(1000);
// Alert alert = driver.switchTo().alert();
// alert.accept();
//		Thread.sleep(2000);
//		List<WebElement> element = driver.findElements(By.tagName("frame"));
//		System.out.println(element.size());
//		for (int i =0;i<element.size();i++) {
//			String s = element.get(i).getText();
//			System.out.println(s);
		//}

 //driver.quit();
 
	}
	public static void Wait(WebDriver driver,WebElement element , int timeinsecs) {
		new WebDriverWait(driver,timeinsecs).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	public static void generateAlertMessage(WebDriver driver , String Message) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+Message+"')");
	}
	
	public static void drawBoarder(WebElement element,WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid green'", element);
	}
	

}


	
	

