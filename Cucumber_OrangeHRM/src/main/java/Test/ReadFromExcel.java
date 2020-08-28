package Test;

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


public class ReadFromExcel {

public	static List<String> First_Name= new ArrayList<String>();
public	static List<String> Middle_Name= new ArrayList<String>();
public	static List<String> Last_Name= new ArrayList<String>();
public	static List<String> User_Name= new ArrayList<String>();
public	static List<String> Employee_Id = new ArrayList<String>();
public	static List<String> Password= new ArrayList<String>();
public	static List<String> Gender = new ArrayList<String>();
public	static List<String> Marital_Status= new ArrayList<String>();
	
	public  static  void Read() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\villu\\Documents\\Book12.xlsx");
		FileInputStream excel= new FileInputStream(file);
		XSSFWorkbook workbook= new XSSFWorkbook(excel);
		XSSFSheet sheet= workbook.getSheetAt(0);
		Iterator<Row> rowIterator=sheet.iterator();
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
	
	
/*
 * public static void main(String[] args) throws IOException { // TODO
 * Auto-generated method stub ReadFromExcel.Read();
 * System.out.println(First_Name); System.out.println(Middle_Name);
 * System.out.println(Last_Name); System.out.println(User_Name);
 * System.out.println(Employee_Id); System.out.println(Password);
 * System.out.println(Gender); System.out.println(Marital_Status); }
 */

	}