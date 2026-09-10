package com.collection.StreamAPIs.realclass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
	String name;
	int salary;
	
	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public static List<String> filterEmp( List<Employee> emp) {
		
       
		return (List<String>) emp.stream().filter(employee -> employee.salary >= 10).map(employee -> employee.name  +  " - " + employee.salary + " LPA").collect(Collectors.toList());		
		
	}
	
	
	
}


public class GetEmpSalWithName {
	

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
			    new Employee("Rahul", 8),
			    new Employee("Aman", 12),
			    new Employee("Karan", 15),
			    new Employee("Rohit", 9),
			    new Employee("Priya", 18),
			    new Employee("Neha", 11),
			    new Employee("Vikas", 7),
			    new Employee("Ankit", 14)
			);
		
		List<String> result = Employee.filterEmp(employees);
		
       System.out.println(result);
	}

}
