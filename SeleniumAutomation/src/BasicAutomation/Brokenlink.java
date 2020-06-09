package BasicAutomation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import com.sun.net.ssl.HttpsURLConnection;



public class Brokenlink {

	public static void main(String[] args) throws IOException, InterruptedException   {
		  WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
		  ChromeOptions opt = new ChromeOptions();
		  //opt.addArguments("window.size=1400,800");
		  opt.addArguments("headless");
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		    //driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			driver.get("https://spicejet.com/");
			Thread.sleep(4000);
			List<WebElement> element =  driver.findElements(By.tagName("a"));
			 
			  element.addAll(driver.findElements(By.tagName("img")));
			  System.out.println(element.size());
			  // for click on link text
				 for (int k=0;k<element.size();k++) {
			  
			  String linktext = element.get(k).getText();
			  System.out.println(linktext);
			  if(linktext.contains("Notices")) {
				  element.get(k).click();
				  break;
			  }
		  }
			  
//			  List<WebElement> element1 = new ArrayList<WebElement>();
//			  for(int i =0;i<element.size();i++) {
//				  if(element.get(i).getAttribute("href") != null && (!element.get(i).getAttribute("href").contains("javascript")) && (!element.get(i).getAttribute("href").contains("mailto")) ) 
//				  {
//					  element1.add(element.get(i));
//				  }				 		 
//			  }
//			 System.out.println(element1.size());
//
//			 for (int j=0;j<element1.size();j++) {
//				 
////				 System.out.println(element1.get(j).getAttribute("href"));
//				 //HttpURLConnection check = (HttpURLConnection)new URL(element1.get(j).getAttribute("href")).openConnection();
//				 HttpURLConnection check = (HttpURLConnection) new URL(element1.get(j).getAttribute("href")).openConnection();
//				 check.connect();
//				String s = check.getResponseMessage();
//				check.disconnect();
//				System.out.println("status message is :- " + element1.get(j).getAttribute("href")+ "---" +s);
//			 }
			 
			 
	}

}
