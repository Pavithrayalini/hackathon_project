package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utilities.ExcelUtils;

public class baseClass {

		 static WebDriver driver;
	     static Properties p;
	     static Logger logger;
	  	     
  // Browser initialization based on input from configure file 
	     
	public static WebDriver initilizeBrowser() throws IOException, InterruptedException
	{
		p = getProperties();
        String browser = p.getProperty("browser").toLowerCase();
		
				switch(browser.toLowerCase()) 
				{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
		
		 driver.manage().deleteAllCookies(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		 ExcelUtils.createExcel();
		 return driver;
		 
	}
	
	public static WebDriver getDriver() {
	
			return driver;
			
		}

	public static Properties getProperties() throws IOException
	{		 
	
	 // To declare the configure file
		
        FileReader file=new FileReader(".\\src\\test\\resources\\config.Properties");
       	p=new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getLogger() 
	{	
 
	 // To declare the logger file	
		
		logger=LogManager.getLogger(); //Log4j
		return logger;
		
	}
	
		
}

