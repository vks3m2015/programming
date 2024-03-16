package practice;

import java.util.ArrayList;
import com.google.gson.Gson;


public class DtoTest {
	
	int empId;
	String name;
	String company;
	
	DtoTest(int empId, String name)
	{
       this.empId = empId;
       this.name = name;
    }
	

/*	public String toString()
	{
		return "empId ="+empId+ "  name ="+name +" company = "+company;
	}
	*/
	public static void main(String[] arg)
	{
		ArrayList<DtoTest> arrList = new ArrayList<DtoTest>();
		
		DtoTest dtoTest1 = new DtoTest(12, "vikas");
		DtoTest dtoTest2 = new DtoTest(13, "ut");
		
		arrList.add(dtoTest1);
		arrList.add(dtoTest2);
		
		Gson gsonObj = new Gson();
		String gsonStr = gsonObj.toJson(arrList);
		
		System.out.println(arrList +"--------"+gsonStr); 
		
		System.out.println("  printing object ===  "+gsonObj.toJson(dtoTest1));
		
	}
}
