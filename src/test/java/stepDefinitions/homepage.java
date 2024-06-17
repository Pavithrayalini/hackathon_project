package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.basePage;
import PageObjects.campus;
import PageObjects.enterpisePage;
import PageObjects.homePage;
import factory.baseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class homepage {
    
	  WebDriver driver;
	  homePage hp = new homePage(baseClass.getDriver());
	  enterpisePage ep =new enterpisePage(baseClass.getDriver());
	  campus cp = new campus(baseClass.getDriver());
	  
	  

@Given("the user has navigated to the homepage")
public void the_user_has_navigated_to_the_homepage() {
   
	baseClass.getLogger().info("Go to for individuals and search for course");
	
}

@When("the user enters a course name into the search bar")
public void the_user_enters_a_course_name_into_the_search_bar() throws InterruptedException, IOException {
	
	baseClass.getLogger().info("Enter the course to search");
     
	hp.toSearch();
	
	
}

@When("the user clicks the search button")
public void the_user_clicks_the_search_button() throws InterruptedException, IOException {
   
	hp.toClick();
	
}

@Then("the search results should display courses related to the entered name")
public void the_search_results_should_display_courses_related_to_the_entered_name() {
   
	baseClass.getLogger().info("The courses are displayed ");
	
	System.out.println("course displayed");
	
}

@When("the user selects the English language filter")
public void the_user_selects_the_english_language_filter() {
	
	baseClass.getLogger().info("Apply the filter ");

     hp.english();
	
}

@When("the user selects the Beginner level filter")
public void the_user_selects_the_beginner_level_filter() throws InterruptedException {

	hp.beginner();
	
}

@Then("the search results should update to show only English beginner courses")
public void the_search_results_should_update_to_show_only_english_beginner_courses() {
  
	baseClass.getLogger().info("The courses are displayed after applying filter");
	
}

@When("the user views the list of courses")
public void the_user_views_the_list_of_courses() {
    
	baseClass.getLogger().info("User will select first two courses information");
	
}

@Then("the user should be able to select a course from the list")
public void the_user_should_be_able_to_select_a_course_from_the_list() throws IOException {
   
	hp.selectCourse();
	
}

@When("the user clicks on a course")
public void the_user_clicks_on_a_course() throws InterruptedException {
	
	hp.displayDetails();
	
}

@Then("the course title, ratings, and hours of learning should be displayed")
public void the_course_title_ratings_and_hours_of_learning_should_be_displayed() {
    
	baseClass.getLogger().info("Display the course title , ratings and learning hours of the courses");
	
}

@When("the user clicks on the see all languages button")
public void the_user_clicks_on_the_see_all_languages_button() {
	 
	hp.seeAll();
	
}

@Then("the total number of languages and languages name should be displayed")
public void the_total_number_of_languages_and_languages_name_should_be_displayed() throws InterruptedException, IOException {
	
	baseClass.getLogger().info("Display the language count and languages");
   
	hp.languageCount();
	
}

@When("the user views the list of levels")
public void the_user_views_the_list_of_levels() {

	baseClass.getLogger().info("Display the levels count and levels");
	
}

@Then("the total number of levels and the levels should be displayed")
public void the_total_number_of_levels_and_the_levels_should_be_displayed() throws InterruptedException, IOException {
	
   
	hp.levelCount();
	
	baseClass.getLogger().info("Click the For Enterprise");
	
	hp.clickEnterprise();
	
}

}
