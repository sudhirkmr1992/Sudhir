package BasicAutomation;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Config {

	public static void main(String[] args) throws IOException, InterruptedException {
		Properties prop = new Properties();
		FileInputStream  skg = new FileInputStream("D:\\WorkSpace\\SeleniumAutomation\\src\\BasicAutomation\\config.properties");
		prop.load(skg);
		//System.out.println(prop.getProperty("Email"));
		//System.out.println(prop.getProperty("password"));
	 	String BrowserName = prop.getProperty("browser_name");
	if (BrowserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
        driver.findElement(By.xpath(prop.getProperty("email-xpath"))).sendKeys(prop.getProperty("Email"));
        driver.findElement(By.xpath(prop.getProperty("next-click-email"))).click();
        Thread.sleep(3000);
        driver.findElement(By.name(prop.getProperty("Enter-password"))).sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath(prop.getProperty("next-click-password"))).click();
     
	}
	else {
		System.out.println(prop.getProperty("other_browser"));
	}
	
	}

}
