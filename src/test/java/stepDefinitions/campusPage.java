package stepDefinitions;

import java.io.IOException;
import hooks.hooks;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.campus;
import PageObjects.enterpisePage;
import PageObjects.homePage;
import factory.baseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DataReader;

public class campusPage {
	
	  WebDriver driver;
	  homePage hp = new homePage(baseClass.getDriver());
	  enterpisePage ep =new enterpisePage(baseClass.getDriver());
	  campus cp = new campus(baseClass.getDriver());
	  public static int index;
	  public String file = System.getProperty("user.dir") + "\\OutputData\\Exceloutputfile.xlsx";
	  public Logger logger = LogManager.getLogger(this.getClass()); 
	  List<HashMap<String, String>> datamap;
   
	  
	@Given("the user is on the campus inquiry page")
	public void the_user_is_on_the_campus_inquiry_page() {

		baseClass.getLogger().info("The user is on the campus inquiry page ");
		
	}

	@When("the user enters their personal and professional details into the form using {string}")
	public void the_user_enters_their_personal_and_professional_details_into_the_form(String rows) throws InterruptedException, IOException {

		baseClass.getLogger().info("The user enters their personal and professional details into the form");
		
	 // Reading data from excel and store it as list of map
			 
		datamap=DataReader.data(System.getProperty("user.dir")+"\\TestData\\Contact_Form data.xlsx", "InputData");

        index=Integer.parseInt(rows)-1;
       
     // Retriving data from datamap   

        String firstname= datamap.get(index).get("FirstName");
        String lastname= datamap.get(index).get("LastName");
        String email= datamap.get(index).get("Email");
        String phone= datamap.get(index).get("Phone");
        String institution= datamap.get(index).get("Institution");
        String name= datamap.get(index).get("Name");
        String job= datamap.get(index).get("Job");
        String deprtment= datamap.get(index).get("Department");
        String needs= datamap.get(index).get("Needs");
        String country= datamap.get(index).get("Country");
        String state= datamap.get(index).get("State");
       
      // pass the value retrived from the excel to the form inputs
        
        cp.firstname(firstname);
        Thread.sleep(1000);
        cp.lastname(lastname);
        Thread.sleep(1000);
        cp.email(email);
        Thread.sleep(1000);
        cp.phone(phone);
        Thread.sleep(1000);
        cp.institution(institution);
        Thread.sleep(1000);
        cp.name(name);
        Thread.sleep(1000);
        cp.job(job);
        Thread.sleep(1000);
        cp.department(deprtment);
        Thread.sleep(1000);
        cp.needs(needs);
        Thread.sleep(1000);
        cp.country(country);
        Thread.sleep(2000);
        cp.state(state);
        cp.submit();
        
        
        if(index == 4) {
        	hooks.isQuit = true;
        }
	  }

	

	@When("the user submits the campus inquiry form")
	public void the_user_submits_the_campus_inquiry_form() throws IOException, InterruptedException {

		baseClass.getLogger().info("Form is filled");
	}

	@Then("a confirmation message should be displayed if the submission is successful")
	public void a_confirmation_message_should_be_displayed_if_the_submission_is_successful() {
	
		baseClass.getLogger().info("Message will be displayed");

	}

	@Then("an error message should be displayed if there are any validation errors")
	public void an_error_message_should_be_displayed_if_there_are_any_validation_errors() throws InterruptedException, IOException {
		
		cp.message();
		

	}
}
