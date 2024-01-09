package Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Facebook {
	
	WebDriver driver;
	
	
	   @BeforeMethod
	   public void initialize()
	   {
	      ChromeOptions op = new ChromeOptions();
	      //disable notification parameter
	      op.addArguments("--disable-notifications");
	      op.addArguments("--incogito");
	      driver=new ChromeDriver(op);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	  }
	
	
	@Test
	public void facebookLogin() throws InterruptedException
	{
		      try
	    	    {
	          
	         //WebElement emailtextbox=driver.findElement(By.xpath("//input[@id='email']"));
	         //emailtextbox.sendKeys("ritikaraman29@gmail.com");
	
             WebElement createaccountbutton=driver.findElement(By.xpath("//a[text()='Create new account']"));
             createaccountbutton.click();
         
             WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
             wait.until(ExpectedConditions.visibilityOf(createaccountbutton));
             Thread.sleep(3000);
         
             WebElement firstnametextbox =driver.findElement(By.xpath("//input[@name='firstname']"));
             firstnametextbox.sendKeys("Richa");
             
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
             
             WebElement lastnamesearchbox = driver.findElement(By.xpath("//input[@name='lastname']"));
             lastnamesearchbox.sendKeys("Srivastava");
             
             Thread.sleep(2000);
             
            WebElement emailtextbox=driver.findElement(By.xpath("//input[@name='reg_email__']"));
            emailtextbox.sendKeys("rraman2810@gmail.com");
            
            new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(emailtextbox));
            
            WebElement reenteremailtextbox= driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
            reenteremailtextbox.sendKeys("rraman2810@gmail.com");
             
            Thread.sleep(2000);
            
             WebElement pwdtextbox =driver.findElement(By.xpath("//input[@data-type='password']"));
             pwdtextbox.sendKeys("W31come29");
             
             WebElement datedropbutton =driver.findElement(By.xpath("//select[@name='birthday_day']"));
             Select select=new Select(datedropbutton);
             select.selectByValue("28");
             
             Thread.sleep(2000);
             WebElement monthdropbutton =driver.findElement(By.xpath("//select[@name='birthday_month']"));
             new Select(monthdropbutton).selectByVisibleText("Aug");
             
             Thread.sleep(3000);
             
             WebElement yeardropdown=driver.findElement(By.xpath("//select[@name='birthday_year']"));
             new Select(yeardropdown).selectByValue("1992");
            
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
            
             WebElement  gendercheckbox =driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
             gendercheckbox.click();
             
             Thread.sleep(4000);
            
             WebElement signupbutton=driver.findElement(By.xpath("//button[@name='websubmit']"));
             signupbutton.click();
           
             Thread.sleep(3000);
           
            //WebElement Createaccountbutton = driver.findElement(By.xpath("(//a[text()='No, Create New Account'])[1]"));
            //new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(Createaccountbutton ));
		
		         }
		 
		        catch(Exception e)
		        {
			       e.printStackTrace();
		        }
	
	    }
	
	@Test(priority=0)
	public void accountLogin() throws InterruptedException
	{
		    try
		       {
		        WebElement emailtextbox=driver.findElement(By.xpath("//input[@id='email']"));
                emailtextbox.sendKeys("ritikaraman29@gmail.com");
        
                WebElement pwdtextbox=driver.findElement(By.xpath("//input[@type='password']"));
                pwdtextbox.sendKeys("W31come@29");
         
                Thread.sleep(3000);
       
                WebElement loginbutton=driver.findElement(By.xpath("//button[@name='login']"));
                loginbutton.click();
          
                Thread.sleep(3000);
          
                // Thread.sleep(5000);
                JavascriptExecutor js=(JavascriptExecutor) driver;
                js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
         
                Thread.sleep(4000);
                js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
             
                WebElement seemore=driver.findElement(By.xpath("(//span[text()='See more'])[1]"));
             
                js.executeScript("arguments[0].scrollIntoView();",seemore);
          
          
		        }
		
		        catch(Exception e)
		         {
			       e.printStackTrace();
		         }
	 }
	
	@Test(priority=1)
	public void screenShot() throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
	    File srcfile=ts.getScreenshotAs(OutputType.FILE);
	    File descfile=new File("D:\\Practice 4\\com.Project\\src\\test\\java\\screenshot\\failed.png");
	    
	    FileUtils.copyFile(srcfile, descfile);
		
	}
}




