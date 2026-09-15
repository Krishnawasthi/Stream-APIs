package com.collection.StreamAPIs.Emplyeeclasssalary;

import java.util.Arrays;
import java.util.List;

class Employee {

	String name;
	int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

}

public class DriveSecondSalary {

	public static void main(String[] args) {
		List<Employee> emp = Arrays.asList(new Employee("Krishna", 50000), new Employee("Mohan", 30000),
				new Employee("Rahul", 75000), new Employee("Aman", 45000), new Employee("Karan", 90000),
				new Employee("Rohit", 60000), new Employee("Ankit", 35000), new Employee("Vikas", 80000),
				new Employee("Ajay", 55000), new Employee("Ravi", 40000));
	Employee out =   emp.stream().sorted((e1,e2) -> e1.getSalary() - e2.getSalary()).skip(1).findFirst().get();
		System.out.println("Name: "+ out.getName() +",Salary "+ out.getSalary());

	}

}
