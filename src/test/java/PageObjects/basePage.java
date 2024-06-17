package PageObjects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

public class basePage {

	// only for constructor
	
	    static WebDriver driver;
		static TakesScreenshot tk;
		//Constructor
		  public basePage (WebDriver driver) {
			  basePage.driver= driver;
			  PageFactory.initElements(driver, this);
			  tk = (TakesScreenshot)driver; 
		}
		  
  // Taking screenshot and store in the folder
		  
	public void takeScreenshot(String name) throws IOException {
		 
		  File source= tk.getScreenshotAs(OutputType.FILE);
		  File target = new File("C:\\Users\\2318440\\eclipse-workspace\\Hackethon\\Screenshots\\"+name+".png");
		  FileHandler.copy(source, target);
		  
		}

	}	  
	

