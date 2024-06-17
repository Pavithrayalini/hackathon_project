package PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.baseClass;
import stepDefinitions.campusPage;
import utilities.ExcelUtils;
import utilities.writeExcel;

public class campus extends basePage{
	
	  JavascriptExecutor js;
	  public Logger logger;
	  public Properties p;
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	  basePage base = new basePage(driver);
	  public String file = System.getProperty("user.dir") + "\\OutputData\\Exceloutputfile.xlsx";
  
	  public String file1 = System.getProperty("user.dir") +  "\\TestData\\Contact_Form data.xlsx";
	  
	  public campus(WebDriver driver) {
		  
		     super(driver);

		     js=(JavascriptExecutor)driver;
		 
		     logger = LogManager.getLogger(this.getClass());  
	  }

	  //WebElement Locators
	  
	  @FindBy(xpath = "//input[@id='FirstName']") WebElement Firstname;
	  
	  @FindBy(xpath = "//input[@id='LastName']") WebElement Lastname;
	  
	  @FindBy(xpath = "//input[@id='Email']") WebElement Email;
	  
	  @FindBy(xpath = "//input[@id='Phone']") WebElement Phone;
	  
	  @FindBy(xpath = "//select[@id='Institution_Type__c']") WebElement Institution;
	  
	  @FindBy(xpath = "//input[@id='Company']") WebElement Company;
	  
	  @FindBy(xpath = "//select[@id='Title']") WebElement Title;
	  
	  @FindBy(xpath = "//select[@id='Department']") WebElement Department;
	  
	  @FindBy(xpath = "//select[@id='What_the_lead_asked_for_on_the_website__c']") WebElement Needs;
	  
	  @FindBy(xpath = "//select[@id='Country']") WebElement Country;
	  
	  @FindBy(xpath = "//select[@id='State']") WebElement State;
	  
	  @FindBy(xpath = "//button[@type='submit']")WebElement Submit;
	  	  
	//Passing value for firstname  
	  
	  public void firstname(String firstname) throws IOException, InterruptedException {

			  Firstname.clear();
			  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-testid='block_layout'])[12]")));	
			  
			  base.takeScreenshot("Form");
			  
			  Firstname.sendKeys(firstname) ;
			  
	  }
	  
	//Passing value for lastname
	  
	  public void lastname(String lastname) {
		  
		  Lastname.clear();
		  
		  Lastname.sendKeys(lastname);
		  
	  }
	  
   //Passing value for email 
	  
	  public void email(String email) {
		  
		  Email.clear();
		  
		  Email.sendKeys(email);
		  
	  }
	  
    //Passing value for phone 
	  
	  public void phone(String phone) {
			  
        	   Phone.clear();
    		  
    		   Phone.sendKeys(phone);
	  }
	  
	  //Select the instituion type
	  
	  public void institution(String institution) {
		  
		  Institution  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='Institution_Type__c']")));

		  js.executeScript("arguments[0].click();", Institution);
		  
		  Select select = new Select(Institution);
		  
		  select.selectByVisibleText(institution);
		  
	  }
	  
   // Passing value for Institution name	  
	  
	  public void name(String name) {
		  
		  Company.clear();
		  
		  Company.sendKeys(name);
		  
	  }
	  
	//Select the job title
	  
	  public void job(String job) {
		  
		  Title  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='Title']")));
		  
		  js.executeScript("arguments[0].click();", Title);

          Select select = new Select(Title);
		  
		  select.selectByVisibleText(job);
		  
		  
	  }
	  
	// Select the department
	  
	  public void department(String department) {
		  
		  Department = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='Department']")));
			 
		  js.executeScript("arguments[0].click();", Department);
		  
          Select select = new Select(Department);
		  
		  select.selectByVisibleText(department);
		  
	  }
	  
   //Select the needs	  
	  
	  public void needs(String needs) {
		  
		  Needs  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='What_the_lead_asked_for_on_the_website__c']")));
			  
		  js.executeScript("arguments[0].click();", Needs);
		  
          Select select = new Select(Needs);
		  
		  select.selectByVisibleText(needs);
		  
	  }
	  
   //Select the country	  
	  
	  public void country(String country) {
		  
		  Country  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='Country']")));
		  
		  js.executeScript("arguments[0].click();", Country);
		  
          Select select = new Select(Country);
		  
		  select.selectByVisibleText(country);     
		  
	  }
	  
   // Select the state	  
	  
	  public void state(String state) {

		  State = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='State']")));
		  
		  js.executeScript("arguments[0].click();", State );
		  
          Select select = new Select(State);
		  
		  select.selectByVisibleText(state); 
		 
	  }
	  
	//Submit the form  
		 
	  public void submit() throws InterruptedException {
		  
		  Thread.sleep(2000);
		  
		  Submit.click();
		
	  }
	  
	//Capture the message  
	  
	  public void message() throws InterruptedException, IOException {	
		  
		  int i = campusPage.index;
		  
		//Capture the Failure message
		  
		  try {
			  
			  WebElement ErrorMessage =  driver.findElement(By.xpath("//div[@class='mktoError']//div[2]"));
			
			  System.out.println("The error message : \n" +ErrorMessage.getText());
			  
			  try {
	        	    
	        	    writeExcel.setCellData(file1, "InputData", i+1, 12, "FAIL");
	        	    
	        	    writeExcel.setCellData(file1, "InputData", i+1, 13, ErrorMessage.getText());
	        	    
	        	    writeExcel.fillRedColor(file1, "InputData", i+1, 12);
	        	    
					
		      }catch(Exception e) {
		    	  
			          logger.error("Something went wrong"+e);
			          
		      }	
				  
			  baseClass.getLogger().info("Error message displayed");
			  
			  baseClass.getLogger().info("Form is not submitted");
			  
			  System.out.println("The error message displayed");
			  
			  base.takeScreenshot("Error message " + i+1);
				  
			  Thread.sleep(3000);
			  
		  }
		  
	  //Capture the Success message 	  
		  
		  catch(Exception e){
				  
			  WebElement successMessage =  driver.findElement(By.xpath("//h1[@data-testid='how_module_hero_heading']"));
			  
			  js.executeScript("arguments[0].style.border = '3px solid red' ",successMessage);
			  
			  System.out.println("The success message :  \n" +successMessage.getText());
			  
			  try {
 
	        	    writeExcel.setCellData(file1, "InputData", i+1, 12, "PASS");
	        	    
	        	    writeExcel.setCellData(file1, "InputData", i+1, 13, successMessage.getText());
	        	    
	        	    writeExcel.fillGreenColor(file1, "InputData",i+1,12);
					
		      }catch(Exception exp) {
		    	  
			          logger.error("Something went wrong"+ exp);
			          
		      }	
			  
			  baseClass.getLogger().error("Form is submitted successfully");
			  
			  baseClass.getLogger().info("Success message displayed");
			  
			  System.out.println("The Success message displayed");
			  
			  base.takeScreenshot("Success message " + i+1);
			  
			  driver.navigate().back();
			  
		      Thread.sleep(2000);			  
				  
			  }

	  }
	  
}
		  
 
	  
	  
