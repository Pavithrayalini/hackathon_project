package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.enterpisePage;
import factory.baseClass;
import io.cucumber.java.en.*;

public class enterprisePage {
	
	private WebDriver driver;
	private enterpisePage ep;
	
	public enterprisePage() {
		this.driver = baseClass.getDriver();
		this.ep = new enterpisePage(driver);
	}
	
	@Given("the user has accessed the enterprise solutions section")
	public void the_user_has_accessed_the_enterprise_solutions_section() throws InterruptedException 
	{
		
		baseClass.getLogger().info("Navigating to For Enterprise page");
	}

	@When("the user selects the Solutions option")
	public void the_user_selects_the_solutions_option() throws InterruptedException, IOException 
	{
		
		baseClass.getLogger().info("Click on the solutions");
		
		ep.solutions();
	}

	@Then("the solutions overview should be displayed")
	public void the_solutions_overview_should_be_displayed() 
	{
		
		baseClass.getLogger().info("The solutions overview is displayed");
		
	}

	@When("the user clicks on the Coursera for Campus option")
	public void the_user_clicks_on_the_coursera_for_campus_option() throws InterruptedException, IOException
	{
		
		baseClass.getLogger().info("Coursera for campus is clicked");
		
	    ep.campus();
		
	}

	@Then("the details for campus solutions should be presented")
	public void the_details_for_campus_solutions_should_be_presented() {
		
		baseClass.getLogger().info("The details for campus solutions are presented");
		
	}
	
}



