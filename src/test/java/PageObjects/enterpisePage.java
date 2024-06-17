package PageObjects;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class enterpisePage extends basePage{

	  JavascriptExecutor js;
	  public Logger logger;
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	  basePage base = new basePage(driver);
	  public String file = System.getProperty("user.dir") + "\\OutputData\\Exceloutputfile.xlsx";

	   //constructor of the superclass

	  public enterpisePage(WebDriver driver) {
		
		     super(driver);
		
		     js=(JavascriptExecutor)driver;
		 
		     logger = LogManager.getLogger(this.getClass());     
		     		
	  }
	  
	  //WEBELEMENT LOCATORS
	  
	  @FindBy(xpath = "(//a[normalize-space()='Solutions'])") WebElement Solutions;
	  
	  @FindBy(linkText = "Coursera for Campus") WebElement Campus;
	  
   //Click the solution from the enterprise page	  
	  
	  public void solutions() throws InterruptedException, IOException {
		  		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Solutions']")));
		  
		  Thread.sleep(2000);
		  
		  js.executeScript("arguments[0].style.border = '3px solid red' ",Solutions);
		  
		  base.takeScreenshot("Solutions");
		  
		  Solutions.click();
		  
	  }
	  
   //Click the course for campus	  
	  
	  public void campus() throws InterruptedException, IOException {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		  		  
		  Thread.sleep(3000);
		  
		  WebElement Campus = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Coursera for Campus']")));
		  
		  js.executeScript("arguments[0].style.border = '3px solid red' ",Campus);
		  
		  base.takeScreenshot("Course for campus");
		  
		  Campus.click();
		  
		  Thread.sleep(2000);
	      
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-testid='block_layout'])[12]")));
	
	  }
	  
	  
}
