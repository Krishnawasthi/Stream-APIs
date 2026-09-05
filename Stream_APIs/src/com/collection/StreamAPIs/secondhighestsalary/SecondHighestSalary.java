package com.collection.StreamAPIs.secondhighestsalary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class SecondHighestSalary {

	public static void main(String[] args) {
		List<Integer> salaries = Arrays.asList(900, 15000, 12000, 13000, 11000, 10000, 13000);
		
	    HashSet<Integer> set = new HashSet<>();
	    
	  Optional<Integer> secondHighestSalary =  salaries.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
	
            //System.out.println("secondHighestSalary of the employee: " + secondHighestSalary);
            
            secondHighestSalary.ifPresent(salary -> System.out.println("secondHighestSalary of the employee: " + salary));
            
            }

	}


