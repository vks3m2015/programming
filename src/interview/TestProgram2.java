package interview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TestProgram2 {


    static class Employee {


        public Employee(String empId, String empName, Double salary, int age) {

            super();

            this.empId = empId;

            this.empName = empName;

            this.salary = salary;

            this.age = age;

        }

        public String empId;

        public String empName;

        public Double salary;

        public int age;

    }


    //TODO : Need to Implement by using Java 8 Syntax

    public void printEmployeeName(Map<String, Employee> empMap, String ageLimit ){

        // Print all employees name in ascending order of their salary.
    	
    	//empMap.entrySet().stream().sorted(Comparator.comparing(Map.Entry<String, Employee> entry -> entry.))
    	
    	empMap.entrySet().stream().sorted( (entry1, entry2) -> entry1.getValue().salary.intValue() - entry2.getValue().salary.intValue())
    	      .collect(Collectors.toMap(null, null));

    	
    	
    	

    }



    public static void main(String...strings){

        //Created 4 Employee Objects

        Employee e1 = new Employee("e1", "Amar", 1000.00, 25);

        Employee e2 = new Employee("e2", "Akbar", 1050.00, 27);

        Employee e3 = new Employee("e3", "Anthony", 1100.00, 23);

        Employee e4 = new Employee("e4", "Geeta", 1200.00, 26);


        //Populate employee Object in map.

        Map<String, Employee> empMap = new HashMap<String, Employee>();

        empMap.put("e1", e1);

        empMap.put("e2", e2);

        empMap.put("e3", e3);

        empMap.put("e4", e4);


      //  printEmployeeName(empMap, "25");


    }

}