package BasicAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Findelements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
	    List<WebElement> linklist = driver.findElements(By.tagName("a"));
	    System.out.println(linklist.size());
	    for (int i =0;i<linklist.size();i++)
	    {
	    	System.out.println(linklist.get(i).getText());
	    }

	}

}
