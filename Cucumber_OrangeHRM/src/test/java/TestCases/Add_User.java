package TestCases;



import org.openqa.selenium.support.PageFactory;


import PageObjects.AddUser_Objects;

import io.cucumber.java.en.*;

public class Add_User {
	
	
	@When("User Navigates to PIM Employee list")
	public void User_Navigates_to_PIM_Employee_list(){
		TestCases.Login.logger.info("User  clicks on PIM");
		
	}


	@Then("User can see Add Employee page")
	public void user_can_see_add_employee_page() throws Exception {
		TestCases.Login.logger.info("User  clicks on Add Employee page");
		TestData.ReadFromExcel.main_method();
	}
	@Then("User enters all details")
	public void user_enters_all_details() {
		TestCases.Login.logger.info("User  Enters all details");
	}


	@Then("user clicks on save button")
	public void user_clicks_on_save_button() {
		PageFactory.initElements(Login.driver, AddUser_Objects.class);
		TestCases.Login.logger.info("User  click on Save button");
	}
	@Then("user gets success message")
	public void user_gets_success_message() {
		TestCases.Login.logger.info("User gets success message ");
	}



}
