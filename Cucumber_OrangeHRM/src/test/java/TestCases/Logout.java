package TestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Login_Logout_Objects_1;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout  {
	
	
	@When("user clicks on logout button")
	public static void user_clicks_on_logout_button() throws InterruptedException {
		TestCases.Login.logger.info("User clicks on logout button");
		PageFactory.initElements(Login.driver, Login_Logout_Objects_1.class);
		/*
		 * WebDriverWait wait= new WebDriverWait(Login.driver,10); WebElement
		 * welcome_button=
		 * wait.until(ExpectedConditions.elementToBeClickable((By.id("welcome"))));
		 * welcome_button.click(); WebDriverWait wait2= new
		 * WebDriverWait(Login.driver,10); WebElement logout=
		 * wait2.until(ExpectedConditions.elementToBeClickable((By.xpath(
		 * "//*[text()='Logout']")))); logout.click();
		 */
		PageFactory.initElements(Login.driver, Login_Logout_Objects_1.class);
		Thread.sleep(3000);
		Login_Logout_Objects_1.Welcome_Admin.click();
		Thread.sleep(3000);
		Login_Logout_Objects_1.Logout_Button.click();
	}

	@Then("User is logged out")
	public static void User_is_logged_out() {
		TestCases.Login.logger.info("User Logged out");

	}


	@After("@AdminLogout")
	public static void close_browser() {
		Login.driver.close();
	}
}
