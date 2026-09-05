package com.collection.StreamAPIs.problemSolving;

import java.util.Arrays;
import java.util.List;

public class ThirdHighestEvenNumber {

	public static void main(String[] args) {
	 
		List<Integer> numbers = Arrays.asList(2, 5, 1, 8, 3, 4, 6, 7);
		
		//find the 3rd highest even number
		
		numbers.stream().filter(n -> n%2 == 0).skip(2).findFirst().ifPresent(n -> System.out.println(n));
	}

}
