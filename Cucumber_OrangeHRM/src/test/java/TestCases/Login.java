package TestCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObjects.Login_Logout_Objects_1;
import TestData.ExtentReporsClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login {
	public static Properties properties=null;
	public static Logger logger=Logger.getLogger(Login.class);
	public static  WebDriver driver=null;
	public static String url;
	public static ExtentTest testcase;
	
	public static Properties property_file() throws Exception {
		PropertyConfigurator.configure("logger.properties");
		FileInputStream fileInputStream= new FileInputStream("Configuration.properties");
		properties=new Properties();
		properties.load(fileInputStream);
		return properties;
	}

	@Before("@Login")
	public static void openbrowser() throws Exception {
		property_file();
		String location=properties.getProperty("location");
		url=properties.getProperty("URL");
		//System.setProperty("webdriver.chrome.driver", location);
		driver= new ChromeDriver();
		driver.manage().window().maximize();


	}


	@Given("User is on OrangeHRM Login Page")
	public  void user_is_on_orange_hrm_login_page() {
		TestData.ExtentReporsClass.ExtentReportsreports();
		testcase=ExtentReporsClass.extent.createTest("Login to HRM");
		logger.info("Opening the chrome");
		testcase.info("Opening the chrome");
		driver.navigate().to(url);
		PageFactory.initElements(driver, Login_Logout_Objects_1.class);
		testcase.info("Orange HRM Login Page");
		logger.info("Orange HRM Login Page");
	}


	@When("User enters username and password")
	public void user_enters_username_and_password() {

		Login_Logout_Objects_1.UserName.sendKeys(properties.getProperty("Admin_UserName"));
		
		testcase.info("User enters Username");
		logger.info("User enters Username");
		Login_Logout_Objects_1.PassWord.sendKeys(properties.getProperty("Admin_PassWord"));
		logger.info("User enters Password");
		testcase.info("User enters Password");
		Login_Logout_Objects_1.Login_Button.click();
		logger.info("User clicks on submit button");
		testcase.info("User clicks on submit button");
	}
	@Then("User is logged in to Home Page")
	public void user_is_logged_in_to_home_page() {
		
		logger.info("User is on Home Page");
		testcase.info("User is on Home Page");
		testcase.log(Status.PASS, "user is on login page");
		
		
	}

	

}
