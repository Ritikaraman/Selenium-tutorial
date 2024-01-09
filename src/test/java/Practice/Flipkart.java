package Practice;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flipkart
{
 WebDriver driver=new ChromeDriver();
 
 @BeforeTest
 public void initialize()
 {
	 driver.get("https://www.flipkart.com/");
	 driver.manage().window().maximize();
 }

 
 @Test(priority=1)
 public void flipkartLogin() throws InterruptedException
 {
	 try
	 {
	   
	   System.out.println("logged in succesfully");
	  driver.findElement(By.xpath("//span[@class='_30XB9F']")).click();
       WebElement searchbox= driver.findElement(By.xpath("//input[@type='text']"));
       searchbox.sendKeys("Samsung S series model");
       Thread.sleep(5000);
       WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.visibilityOf(searchbox));
      List<WebElement>  lists= driver.findElements(By.xpath("//ul//li//div//a//div[contains(text(),'samsung')]"));
          for(int i=0;i<=lists.size()-1;i++)
           {
    	      System.out.println(lists.get(i).getText());
    	      //lists.get(5).click();
    	 
           }
          
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
           
          lists.get(5).click();
          
          WebElement mindropdown=driver.findElement(By.xpath(("(//select[@class='_2YxCDZ'])[1]")));
          new Select(mindropdown).selectByIndex(2);
          
        // WebElement maxdropdown =driver.findElement(By.xpath("(//select[@class='_2YxCDZ'])[2]"));
       //  new Select(maxdropdown).selectByIndex(1);
           
     
       
          
           
           
       }
	 
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 
     
 }
 
 
 
 @Test(priority=2,enabled=true)
 public void scroll() throws InterruptedException 
 {
	
	 Thread.sleep(5000);
	 JavascriptExecutor	js= (JavascriptExecutor) driver;
	 js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //scrolldown
	
     Thread.sleep(3000);
     js.executeScript("window.scrollTo(document.body.scrollHeight,0)"); //scroll up
     
     Thread.sleep(2000);
     
      WebElement samsunglink= driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy S9 (Midnight Black, 64 GB)']"));
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
      js.executeScript("arguments[0].scrollIntoView();", samsunglink) ;//scroll till the element
 
	 
 }
 
 
 
 
 
 
 

}
