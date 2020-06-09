package BasicAutomation;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bootstrap {
 public 	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.jquery-az.com/boots/demo.php?ex=6.0_6");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Nothing selected')]")).click();
		
		Thread.sleep(5000);
		List<WebElement> skg = driver.findElements(By.xpath("//ul[contains(@class,'dropdown-menu inner')]/descendant::span[@class='text']"));
		System.out.println(skg.size());

//			driver.findElement(By.xpath("//div[@class='qWuU9c']/descendant::span[2]")).click();
		for (int i = 0; i < skg.size(); i++) {
			String s = skg.get(i).getText();
			System.out.println(s);
		}
		for (int i = 0; i < skg.size(); i++) {
			 
			if (skg.get(i).getText().contains("Bootstrap")) {
				skg.get(i).click();
				//driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bootstrap");
				break;
	
			}
		}
		driver.quit();
	}}


