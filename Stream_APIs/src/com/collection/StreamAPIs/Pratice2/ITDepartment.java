package com.collection.StreamAPIs.Pratice2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Employee{ 
	 private int empId ;
	 private String empName;
	 private int salary;
	 private String department;
	Employee(int empId,String empName,int salary,String department){
		
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.department = department;			
		
	}
	
 public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

 public String showdetails() {
	 
	 return empId + " " + empName + " " + salary + " " + department;
 }
		 
		 

}

public class ITDepartment {

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(
			    new Employee(101, "Rahul", 80000, "IT"),
			    new Employee(102, "Aman", 120000, "HR"),
			    new Employee(103, "Rohan", 150000, "IT"),
			    new Employee(104, "Priya", 90000, "Finance"),
			    new Employee(105, "Raj", 130000, "IT"),
			    new Employee(106, "Neha", 110000, "HR")
			);
	Optional<Employee> empHighestSalary = employees.stream().filter(e -> e.getDepartment().equals("IT")).max(Comparator.comparing(Employee::getSalary));
	  
	 empHighestSalary.ifPresent(e -> System.out.println(e.showdetails()));
	}

}
