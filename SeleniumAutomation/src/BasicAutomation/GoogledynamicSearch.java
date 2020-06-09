package BasicAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogledynamicSearch {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.google.com/");
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys("java");
			Thread.sleep(2000);
		List<WebElement> element = 	driver.findElements(By.xpath("//ul[@class='erkvQe']/descendant::span"));
		
		System.out.println(element.size());
		for (int i =0;i<element.size();i++) {
			System.out.println(element.get(i).getText());
			 
				
			 }
		
		for (int i =0;i<element.size();i++) {
			String s = element.get(i).getText();
			if(s.contains("javascript")) {
				element.get(i).click();
				break;
			}
			 
				
			 }
		
		driver.quit();
		
			
		}
		
		
		
		

	}


