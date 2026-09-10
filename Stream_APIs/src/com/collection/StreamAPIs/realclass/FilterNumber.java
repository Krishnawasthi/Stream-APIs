package com.collection.StreamAPIs.realclass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNumber {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(
			    12, 67, 34, 89, 45, 23, 76, 51,
			    9, 94, 38, 62, 17, 55, 41, 83,
			    29, 71, 48, 100, 36, 64, 21, 58
			);
		
		//find the integers which are above 50
		//Approach1
		List<Integer> filterNumber1 = numbers.stream().filter(n -> n > 50).collect(Collectors.toList());
		 System.out.println("Number List with Approach1: "+ filterNumber1);
		 
		//Approach2 
		 List<Integer> filterNumber2 = numbers.stream().filter(w -> w.intValue() > 50).collect(Collectors.toList());
		 System.out.println("Number List with Approach1: "+ filterNumber2);
		 
		//Approach3  //without streams  (Integer :: intValue)
		 numbers.stream().mapToInt(Integer -> Integer.intValue()).filter(n -> n > 50).forEach(System.out::println);
	}

}
