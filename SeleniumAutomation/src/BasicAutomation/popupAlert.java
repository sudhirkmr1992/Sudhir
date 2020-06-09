package BasicAutomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class popupAlert {
	public WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		new popupAlert().m2();
		
	}
	
	
		
		popupAlert() throws InterruptedException{
		 
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		}
		void m2() throws InterruptedException{
		driver.findElement(By.xpath("//label[text()='Multicity']")).click();
		
		driver.findElement(By.xpath("//a[text()='Ok']")).click();
		Thread.sleep(5000);
		 
		//driver.findElement(By.xpath("//div[@class='MultiCityContent']")).getText();
		driver.findElement(By.xpath("//div[@class='paxinfo']")).click();
	Select select =  new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']")));
    select.selectByVisibleText("2");
    Select select1 =  new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Child']")));
    select1.selectByVisibleText("3");
    Select select2 =  new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Infant']")));
    select2.selectByVisibleText("4");
    Alert alert = driver.switchTo().alert();
    Thread.sleep(2000);
    String message=alert.getText();
    System.out.println(message);
    alert.accept();
    driver.quit();
		}
	}


