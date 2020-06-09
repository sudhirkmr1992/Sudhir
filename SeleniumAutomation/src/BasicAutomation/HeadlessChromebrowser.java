package BasicAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromebrowser {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("windows.size=1400,800");
		option.addArguments("headless");
	    WebDriver driver = new ChromeDriver(option);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get("https://www.google.com/");
	    System.out.println(driver.getTitle());
	    Thread.sleep(2000);
	   driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]/center/input[2]")).click();
	 
	    
	    System.out.println(driver.getTitle());   
	    driver.quit();
	    
	    
	}

}
