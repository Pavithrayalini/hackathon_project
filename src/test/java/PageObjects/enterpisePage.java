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
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	  basePage base = new basePage(driver);
	  public String file = System.getProperty("user.dir") + "\\OutputData\\Exceloutputfile.xlsx";

	   //constructor of the superclass

	  public enterpisePage(WebDriver driver) {
		
		     super(driver);
		
		     js=(JavascriptExecutor)driver;
		 
		     logger = LogManager.getLogger(this.getClass());     
		     		
	  }
	  
	  //WEBELEMENT LOCATORS
	  
	  @FindBy(xpath = "(//a[normalize-space()='Solutions'])[2]") WebElement Solutions;
	  
	  @FindBy(xpath = "//a[contains(text(),'Solutions')]")WebElement Solutions_click;
	  
	  @FindBy(xpath = "//a[@data-track-component='navigation_mobile_menu']") WebElement Navigation_key;
	  
	  @FindBy(xpath = "//a[@data-track-component='navigation_mobile_menu_link_Universities']") WebElement Campus;
	  
	  @FindBy(xpath = "//a[@data-track-component='navigation_mega_menu_Solutions_Universities']") WebElement Course_Campus;
	  
   //Click the solution from the enterprise page	  
	  
	  public void solutions() throws InterruptedException, IOException {
		  		  
//		  Thread.sleep(2000);
	  
		  try {
			  
			  js.executeScript("arguments[0].style.border = '3px solid red' ",Solutions_click);
			  
			  base.takeScreenshot("Solutions");
			  
			  Solutions_click.click();
			  
		  }catch(Exception e) {
			  
		       Navigation_key.click();
		  
		       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Solutions'])[2]")));
		 
		       js.executeScript("arguments[0].style.border = '3px solid red' ",Solutions);
		  
		       base.takeScreenshot("Solutions");
		  
		       js.executeScript("arguments[0].click();", Solutions);
		  
		  }
		  
	  }
	  
   //Click the course for campus	  
	  
	  public void campus() throws InterruptedException, IOException {
		  
//		  Thread.sleep(3000);
		  
		  try {
			  
			  js.executeScript("arguments[0].style.border = '3px solid red' ",Course_Campus);
			  
			  base.takeScreenshot("Course for campus");
			  
			  Course_Campus.click();
			  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-testid='block_layout'])[12]")));
		  }
		  		  
		  catch(Exception e) {

		       js.executeScript("arguments[0].style.border = '3px solid red' ",Campus);
		  
		       base.takeScreenshot("Course for campus");
		  
		       js.executeScript("arguments[0].click();", Campus);
	      
		       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-testid='block_layout'])[12]")));
	
	  }
	  
	  }  
}
