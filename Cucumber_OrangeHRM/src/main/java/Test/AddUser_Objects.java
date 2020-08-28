package Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser_Objects {
	@FindBy(id="menu_pim_viewPimModule")
	public static WebElement PIM;

	@FindBy(id="menu_pim_addEmployee")
	public static WebElement AddEmployee;

	@FindBy(name="firstName")
	public static WebElement FirstName;

	@FindBy(name="middleName")
	public static WebElement MiddleName;

	@FindBy(name="lastName")
	public static WebElement LastName;
	
	@FindBy(name="employeeId")
	public static WebElement EmployeeID;
	
	@FindBy(name="chkLogin")
	public static WebElement CheckLogin;

	@FindBy(name="user_name")
	public static WebElement UserName;
	
	@FindBy(name="user_password")
	public static WebElement Password;
	
	@FindBy(name="re_password")
	public static WebElement Repassword	;
	
	@FindBy(xpath ="//*[@id=\"btnSave\"]")
	public static WebElement SaveButton;
	
	@FindBy(id="btnSave")
	public static WebElement EditDetails;
	
	@FindBy(xpath ="//*[@id=\"frmEmpPersonalDetails\"]/fieldset/ol[3]/li[1]/ul/li[1]/label")
	public static WebElement GenderMale;
	
	@FindBy(xpath ="//*[@id=\"frmEmpPersonalDetails\"]/fieldset/ol[3]/li[1]/ul/li[2]/label")
	public static WebElement GenderFemale;
	
	@FindBy(id="personal_cmbMarital")
	public static WebElement MartialStatus;
	
	@FindBy(name="personal[DOB]")
	public static WebElement DateofBirth;
	

	@FindBy(name="personal[cmbNation]")
	public static WebElement Nationality;
	
}


