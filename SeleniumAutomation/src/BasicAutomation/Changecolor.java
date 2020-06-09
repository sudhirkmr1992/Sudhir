package BasicAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Changecolor {

 WebDriver driver ;

  public static void main(String[] args) throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.get("https://www.spicejet.com/");
   
    
    WebElement ele1 =  driver.findElement(By.xpath("//a[text()='DEALS']"));
    flash(ele1,driver);
    generateAlert(driver,"there is an isue in this test");
    
 
  }
 public static void flash(WebElement element , WebDriver driver) throws InterruptedException {
    
    String bgclr =  element.getCssValue("backgroundColor");
    for (int i=0;i<=5;i++)
    {
      changeColor("rgb(0, 10, 200)",element,driver);
      changeColor(bgclr,element,driver);
   
    }
  }

  public static void changeColor(String clr,WebElement element,WebDriver driver) {
    JavascriptExecutor js = ((JavascriptExecutor) driver) ;
    
    js.executeScript("arguments[0].style.backgroundColor = '"+clr+"'",element);
  
  try {
    Thread.sleep(1000);
  }catch(InterruptedException e) {
    
  } 
}
  public static  void generateAlert(WebDriver driver , String message) {
    JavascriptExecutor js = (JavascriptExecutor) driver ;
    js.executeScript("alert('"+message+"')");
  }
  
  
}
