package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class AddUserAccess {
	public static WebDriver driver;

	public static void openChrome() {

		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		PageFactory.initElements(driver, Login_Logout_Objects_1.class);
		Login_Logout_Objects_1.UserName.sendKeys("Admin");
		Login_Logout_Objects_1.PassWord.sendKeys("admin123");
		Login_Logout_Objects_1.Login_Button.click();
	}

	public static void user_details_page(String FirstName, String MiddleName,String LastName,String EmployeeID,String UserName,String Password,String Gender,String MartialStatus) throws InterruptedException {
		PageFactory.initElements(driver, AddUser_Objects.class);
		Thread.sleep(2000);
		AddUser_Objects.PIM.click();
		Thread.sleep(2000);
		AddUser_Objects.AddEmployee.click();
		Thread.sleep(2000);
		AddUser_Objects.FirstName.sendKeys(FirstName);
		Thread.sleep(2000);
		AddUser_Objects.MiddleName.sendKeys(MiddleName);
		Thread.sleep(2000);
		AddUser_Objects.LastName.sendKeys(LastName);
		Thread.sleep(2000);
		AddUser_Objects.EmployeeID.clear();
		AddUser_Objects.EmployeeID.sendKeys(EmployeeID);
		Thread.sleep(2000);
		AddUser_Objects.CheckLogin.click();
		Thread.sleep(2000);
		AddUser_Objects.UserName.sendKeys(UserName);
		Thread.sleep(2000);
		AddUser_Objects.Password.sendKeys(Password);
		Thread.sleep(2000);
		AddUser_Objects.Repassword.sendKeys(Password);
		Thread.sleep(2000);
		AddUser_Objects.SaveButton.click();
		Thread.sleep(2000);
		AddUser_Objects.EditDetails.click();
		Thread.sleep(2000);
		if(Gender.contains("Male"))
		{
			AddUser_Objects.GenderMale.click();
		}
		else {
			AddUser_Objects.GenderFemale.click();
		}
		Thread.sleep(2000);
		AddUser_Objects.MartialStatus.sendKeys(MartialStatus);
		Thread.sleep(2000);
		AddUser_Objects.DateofBirth.clear();
		Thread.sleep(2000);
		AddUser_Objects.DateofBirth.sendKeys("1997-02-15");
		Thread.sleep(2000);
		AddUser_Objects.Nationality.sendKeys("India");
		Thread.sleep(2000);
		AddUser_Objects.EditDetails.click();

	}

	public static void execute() throws InterruptedException {
		for(int i=1;i<ReadFromExcel.First_Name.size();i++){
			
			user_details_page(ReadFromExcel.First_Name.get(i),
					        ReadFromExcel.Middle_Name.get(i),
					        ReadFromExcel.Last_Name.get(i),
					        ReadFromExcel.Employee_Id.get(i),
					        ReadFromExcel.User_Name.get(i),
					        ReadFromExcel.Password.get(i),
					        ReadFromExcel.Gender.get(i),
					        ReadFromExcel.Marital_Status.get(i)

					);
		}
	}
	
	public static void logout() {
		PageFactory.initElements(driver, Login_Logout_Objects_1.class);
		Login_Logout_Objects_1.Welcome_Admin.click();
		Login_Logout_Objects_1.Logout_Button.click();
		driver.close();
	}
	
	

	public static void main(String[] args) throws IOException, InterruptedException {
		ReadFromExcel.Read();
		openChrome();
		execute();
		logout();

	}
	
	
	

}
