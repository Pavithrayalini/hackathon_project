package hooks;
 
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import org.apache.commons.io.serialization.ValidatingObjectInputStream;
import org.openqa.selenium.WebDriver;

import factory.baseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
 
public class hooks {
	static WebDriver driver;
	Properties properties;
	  static boolean isInitialized = false;
	  public static boolean isQuit = false;
  
	  
	@Before
	public void appSetup() throws IOException, InterruptedException {
				
		if(!isInitialized) {
			driver = baseClass.initilizeBrowser();
			driver = baseClass.getDriver();
			properties = baseClass.getProperties();
			driver.get(properties.getProperty("appURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			 Thread.sleep(5000);
			 baseClass.getLogger().info("Web Page opens");
			isInitialized = true;	
			
		}
	
	}
	
	
	@After
	public void quitAplication() throws IOException {
		
		if(isQuit){
			
			driver.quit();
			
		}
	}
}