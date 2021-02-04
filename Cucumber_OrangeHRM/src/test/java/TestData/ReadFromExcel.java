package TestData;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import PageObjects.AddUser_Objects;



public class ReadFromExcel extends ExtentReporsClass {

public	static List<String> First_Name= new ArrayList<String>();
public	static List<String> Middle_Name= new ArrayList<String>();
public	static List<String> Last_Name= new ArrayList<String>();
public	static List<String> User_Name= new ArrayList<String>();
public	static List<String> Employee_Id = new ArrayList<String>();
public	static List<String> Password= new ArrayList<String>();
public	static List<String> Gender = new ArrayList<String>();
public	static List<String> Marital_Status= new ArrayList<String>();
 static ExtentTest testcase;
	public  static  void Read() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\villu\\Documents\\Book12.xlsx");
		FileInputStream excel= new FileInputStream(file);
		XSSFWorkbook workbook= new XSSFWorkbook(excel);
		XSSFSheet sheets= workbook.getSheetAt(0);
		Iterator<Row> rowIterator=sheets.iterator();
		while(rowIterator.hasNext()) {
			Row rowvalue=rowIterator.next();
			Iterator<Cell> columnIterator=rowvalue.cellIterator();
			int i = 1;
			while(columnIterator.hasNext()) 
			{
				if(i==1) {
					First_Name.add(columnIterator.next().toString());
					}
				else if(i==2)
				{
					Middle_Name.add(columnIterator.next().toString());
					}
				else if(i==3)
				{
					Last_Name.add(columnIterator.next().toString());
					}
				else if(i==4)
				{
					User_Name.add(columnIterator.next().toString());
					}
				else if(i==5)
				{
					Employee_Id.add(columnIterator.next().toString());
					}
				else if(i==6)
				{
					Password.add(columnIterator.next().toString());
					}
				else if(i==7)
				{
					Gender.add(columnIterator.next().toString());
					}
				else
				{
					Marital_Status.add(columnIterator.next().toString());
					}

				i++;
			}
			
			
			
			
	}workbook.close();
	
}
	
	public static void user_details_page(String FirstName, String MiddleName,String LastName,String EmployeeID,String UserName,String Password,String Gender,String MartialStatus) throws InterruptedException {
		PageFactory.initElements(TestCases.Login.driver, AddUser_Objects.class);
		ExtentReportsreports();
		testcase=extent.createTest("Enter User details");
		AddUser_Objects.PIM.click();
		Thread.sleep(2000);
		AddUser_Objects.AddEmployee.click();
		TestCases.Login.logger.info("Add Employee is clicked");
		Thread.sleep(2000);
		AddUser_Objects.FirstName.sendKeys(FirstName);
		TestCases.Login.logger.info("Entered first name");
		Thread.sleep(2000);
		AddUser_Objects.MiddleName.sendKeys(MiddleName);
		TestCases.Login.logger.info("Entered Middle name");
		Thread.sleep(2000);
		AddUser_Objects.LastName.sendKeys(LastName);
		TestCases.Login.logger.info("Entered Last name");
		Thread.sleep(2000);
		AddUser_Objects.EmployeeID.clear();
		AddUser_Objects.EmployeeID.sendKeys(EmployeeID);
		TestCases.Login.logger.info("Entered Employee ID");
		Thread.sleep(2000);
		AddUser_Objects.CheckLogin.click();
		TestCases.Login.logger.info("Clicks on check login");
		Thread.sleep(2000);
		AddUser_Objects.UserName.sendKeys(UserName);
		TestCases.Login.logger.info("Entered User name");
		Thread.sleep(2000);
		AddUser_Objects.Password.sendKeys(Password);
		TestCases.Login.logger.info("Entered Password");
		Thread.sleep(2000);
		AddUser_Objects.Repassword.sendKeys(Password);
		TestCases.Login.logger.info("Entered Re password");
		Thread.sleep(2000);
		AddUser_Objects.SaveButton.click();
		TestCases.Login.logger.info("Clicks on Save button");
		Thread.sleep(2000);
		AddUser_Objects.EditDetails.click();
		TestCases.Login.logger.info("Clicks on Edit button");
		Thread.sleep(2000);
		if(Gender.contains("Male"))
		{
			AddUser_Objects.GenderMale.click();
			TestCases.Login.logger.info("Clicks on Male Option");
		}
		else {
			AddUser_Objects.GenderFemale.click();
			TestCases.Login.logger.info("Clicks on Female Option");
		}
		Thread.sleep(2000);
		AddUser_Objects.MartialStatus.sendKeys(MartialStatus);
		TestCases.Login.logger.info("Clicks Martial status");
		Thread.sleep(2000);
		AddUser_Objects.DateofBirth.clear();
		Thread.sleep(2000);
		AddUser_Objects.DateofBirth.sendKeys("1997-02-15");
		TestCases.Login.logger.info("Entered DOB");
		Thread.sleep(2000);
		AddUser_Objects.Nationality.sendKeys("India");
		TestCases.Login.logger.info("Entered Nationality");
		Thread.sleep(2000);
		AddUser_Objects.EditDetails.click();
		TestCases.Login.logger.info("Saved all details");
		testcase.info("Details entered and User is created");
		extent.flush();
	}

	public static void execute() throws InterruptedException {
		PageFactory.initElements(TestCases.Login.driver, AddUser_Objects.class);
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
	
	public static void main_method() throws IOException, InterruptedException {
		PageFactory.initElements(TestCases.Login.driver, AddUser_Objects.class);
		Read();
		execute();
		
	}
	}