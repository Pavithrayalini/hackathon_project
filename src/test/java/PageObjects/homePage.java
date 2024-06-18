package PageObjects;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtils;

public class homePage extends basePage{
	

	  JavascriptExecutor js;
	  public Logger logger;
	  public Properties p;
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(120));
	  List<String> Course_list = new ArrayList<>();
	  basePage base = new basePage(driver);
	  Actions action = new Actions(driver);
	  String file = System.getProperty("user.dir") + "\\OutputData\\Exceloutputfile.xlsx";

	   //constructor of the superclass

	  public homePage(WebDriver driver) {
		
		     super(driver);
		
		     js=(JavascriptExecutor)driver;
		 
		     logger = LogManager.getLogger(this.getClass());  
		   		     		
	  }	
	  
  
	  //WebElement Locators
	  
	  @FindBy(xpath = "(//input[@type='text'])[1]")WebElement Search;
	  
	  @FindBy(xpath = "(//button[@class='mobile-search-icon'])[1]") WebElement Search_Icon_Mobile;
	  
	  @FindBy(xpath = "(//div[@data-e2e='AutoComplete'])[2]//input[1]") WebElement Search_Mobile;
	  
	  @FindBy(xpath = "//button[@aria-label='Submit Search']") WebElement Toclick;
	 	  
	  @FindBy(xpath = "(//div[@data-testid='search-filter-group-Language']//div[@class='cds-checkboxAndRadio-labelText'])[1]") WebElement English;
	  
	  @FindBy(xpath = "(//div[@data-testid='search-filter-group-Level']//div[@class='cds-checkboxAndRadio-labelText'])[1]") WebElement Beginner;
	  
	  @FindBy(xpath = "//span[contains(text(),'Sort by')]")WebElement Sortby;
	  
	  @FindBy(xpath = "//div[contains(text(),'Newest')]") WebElement Newest;
	  
	  @FindBy(xpath = "//div[@class='cds-CommonCard-metadata']") List<WebElement> Courses;
	  
	  @FindBy(xpath = "cds-CommonCard-ratings") List<WebElement> Ratings_count;
	  
	  @FindBy(xpath = "//a[@data-click-key='search.search.click.search_card']") List<WebElement> Course_Click;
	  
	  @FindBy(xpath = "//h1[@data-e2e='hero-title']") WebElement Course_Title;
	  
	  @FindBy(xpath = "//div[@data-e2e='key-information']//div[1]//div[2]//div[1]//div[1]") WebElement Ratings;
	  
	  @FindBy(xpath = "//div[@data-e2e='key-information']//div[contains(text(),'hours')]") WebElement Hours;
	  
	  @FindBy(xpath = "(//span[contains(normalize-space(),'more')])[2]") WebElement seeall;
	  
	  @FindBy(xpath = "//div[@data-testid='search-filter-group-Language']//div[@class='cds-checkboxAndRadio-labelText']") List<WebElement> Languages;
	  
	  @FindBy(xpath = "//div[@data-testid='search-filter-group-Level']//div[@class='cds-checkboxAndRadio-labelText']") List<WebElement> Levels;
	  
	  @FindBy(linkText = "For Enterprise") WebElement Enterprise;
	  
   // Enter the course to be search	  
	  
	  public void toSearch() throws IOException {
		  
		  FileReader file=new FileReader(".\\src\\test\\resources\\config.Properties");
			 p=new Properties();
			 p.load(file);
		  
		  try {
			  
			  Search.sendKeys(p.getProperty("Tosearch"));
			  
		  }catch(Exception e){
			  
			  Search_Icon_Mobile.click();
			  
			  action.sendKeys(Keys.ENTER).perform();
			  
			  Search_Mobile.sendKeys(p.getProperty("Tosearch"));
		  }
		  
		  base.takeScreenshot("To Search");
		  
		  System.out.println("Entering search value");
	  	
	  }
	  
   // Click the search button	  
	  
	  public void toClick() throws InterruptedException, IOException {
		  	  
		   Thread.sleep(3000);
		  
		   action.sendKeys(Keys.ENTER).perform();
		  
		  base.takeScreenshot("Before applying filter");
		  
	  }
	  
   // Apply the filter for language as English
	  
	  public void english()  {
		 
		  English.click();
		  
      }
	 
   //Apply the filter for level as beginner	  
	  
	  public void beginner() throws InterruptedException {
		  
          Beginner.click();
		  
		  Thread.sleep(3000);
		  
		  Sortby.click();
		  
		  Newest.click();
 		  
		  
	  }
	  
   // Select the course and display its count	  
	  
	  public void selectCourse() throws IOException {
		  
	      for (int i = 0; i < Courses.size(); i++) {
	    	  
		       String courseLevel = Courses.get(i).getText();
		       
		       Course_list.add(courseLevel); 
		       
		       System.out.println("the courses : " + Course_Click.get(i).getText());
		  }
	      
	      System.out.println("No.of courses available: " +Course_list.size());
	      
	      base.takeScreenshot("After applying filter");
	      
	  }
	  
   // Display the details of course title , ratings , Hours of learning for the first 2 courses 	  
	  
	  public void displayDetails() throws InterruptedException {
		  
		  System.out.println("\n The courses are : ");
		  
		  for(int i = 0 ;i < 2; i++) {
			  
			  js.executeScript("arguments[0].style.border = '3px solid red' ",Course_Click.get(i));
			  
	          try {
	        	  
	          ExcelUtils.setCellData(file, "Course details", i+1, 0,Course_Click.get(i).getText());
	        			  		  
			  Course_Click.get(i).click();  
		
			  List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
  	          
  	          for(int j = windowHandles.size()-1;j>0;j--) {
  	        	  
  	        	 driver.switchTo().window(windowHandles.get(j));
  	        	 
		          System.out.println("The course title : " + Course_Title.getText());
		          
		          ExcelUtils.setCellData(file, "Course details", i+1, 1,Course_Title.getText());
		          
		          js.executeScript("arguments[0].style.border = '3px solid red' ",Course_Title);
		      
		          System.out.println("Ratings : " + Ratings.getText());
		         
//		          js.executeScript("arguments[0].scrollIntoView(true);",Course_Title);
		          
		          ExcelUtils.setCellData(file, "Course details", i+1, 2,Ratings.getText());
		          
		          js.executeScript("arguments[0].style.border = '3px solid red' ",Ratings);
		      
		          System.out.println("Hours of Learning : " + Hours.getText());
		          
		      	  ExcelUtils.setCellData(file, "Course details", i+1, 3,Hours.getText());
		          
		          js.executeScript("arguments[0].style.border = '3px solid red' ",Hours);
		          
		          System.out.println();
		          
		          base.takeScreenshot("course details");
		      
		          Thread.sleep(3000);
		      
		          driver.close();
		      
                  driver.switchTo().window(windowHandles.get(j-1));
                  
                  Thread.sleep(1000);
                  
  	          }
                  
  	    	     }catch(Exception e) {
		    	  
		          logger.error("Something went wrong"+e);
		          
	             }	
			  
		      }
	        
	  }
	  
   //Click the see all in language for taking its count	  
	  
	  public void seeAll() {
		   
		  seeall.click();
		  
		  System.out.println("-------------------------------------------------------");
		  
		  
	  }
	  
	//Take the count of the languages and display the languages  
	  
	  public void languageCount() throws InterruptedException, IOException {
		   
		 
		  System.out.println("Total number of languages : " + Languages.size());
		  
		  WebElement scroll = driver.findElement(By.xpath("//label[contains(text(),'Language')]"));
		  
		  js.executeScript("arguments[0].scrollIntoView(true);",scroll);
		  
		  for(int i = 0 ; i < Languages.size(); i++) {
			  
			  System.out.println(Languages.get(i).getText());
			  
			  try {
	        	  
	        	    ExcelUtils.setCellData(file, "Language and levels", i+1, 0 ,Languages.get(i).getText());
					
		      }catch(Exception e) {
		    	  
			          logger.error("Something went wrong"+e);
			          
		      }	
			  
		  }
		  
		  System.out.println();
		  
		  Thread.sleep(2000);
		  
		  base.takeScreenshot("Languages");
		  
	  }
	  
    //Take the count of the levels and display the levels  
	  
	  public void levelCount() throws IOException {
		  
		  System.out.println("-------------------------------------------------------");
		  
		  WebElement scroll = driver.findElement(By.xpath("//label[contains(text(),'Level')]"));
		  
		  js.executeScript("arguments[0].scrollIntoView(true);",scroll);
		  
		  System.out.println("Total number of levels : " + Levels.size());
		  
		  for(int i = 0 ; i < Levels.size();i++) {
			  
			  System.out.println(Levels.get(i).getText());
			  
			  try {
	        	  
	        	    ExcelUtils.setCellData(file, "Language and levels", i+1, 1 ,Levels.get(i).getText());
					
		      }catch(Exception e) {
		    	  
			          logger.error("Something went wrong"+e);
			          
		      }	
			  
		  }
		  
		  System.out.println();
		  
		  base.takeScreenshot("Levels");
		  
		  System.out.println("-------------------------------------------------------");
	  }
	  
   //Click the for enterprise
	  
	  public void clickEnterprise() throws InterruptedException, IOException {
		  
		  WebElement scroll = driver.findElement(By.xpath("(//p[contains(text(),'Community')])"));
		  
		  js.executeScript("arguments[0].scrollIntoView(true);",scroll);
		  
		  Thread.sleep(2000);
		  
		  js.executeScript("arguments[0].style.border = '3px solid red' ",Enterprise);
		  
		  base.takeScreenshot("For enterprise");
		  
		  js.executeScript("arguments[0].click();", Enterprise);  
		  
	  }

}
