package interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import TestProgram2.Employee;

public class Test17 {

	

	public static void main(String[] args) {

		//WAP to retrieve the list of employees with minimum salary
		 List<Employee> employees = new ArrayList<Employee>(){{
		    add(new Employee("bilbo baggins", 10));
		    add(new Employee("frodo baggins", 100));
		    add(new Employee("gandalf grey", 100));
		}};
		
		
		Employee emp = employees.stream().min(Comparator.comparing(e -> e.getSalary())).get();
		System.out.println(emp);
		
		Map<Integer, List<Employee>> salMap = employees.stream().collect(Collectors.groupingBy((Employee e) -> e.salary));
		System.out.println(salMap);
		
		List<Employee> eList = employees.stream().filter(e -> e.salary > 50).collect(Collectors.toList());
		System.out.println("Filtered Emp = "+eList);
		
		
		/*
		 * Reverse a string without affecting special characters Input: str = "a,b$c"
		 * Output: str = "c,b$a" Note that $ and , are not moved anywhere. Only
		 * subsequence "abc" is reversed
		 */
		
		String str = "a,b$c";
				
		char[] chArr = str.toCharArray();
		char[] revChArr = new char[chArr.length];
		
        for(int i = 0; i< chArr.length; i++) {
			
		}
		
		for(int i = chArr.length; i>0; i--) {
			
		}
		
	}

}

class Employee{
	String name;
	Integer salary;
	public Employee(String name, Integer salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
}
