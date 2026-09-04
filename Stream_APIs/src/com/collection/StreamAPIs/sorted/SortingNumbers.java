package com.collection.StreamAPIs.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingNumbers {

	public static void main(String[] args) {
		
		List<Integer>  input = Arrays.asList(23,12,34,43,56,54,15,43,76);
		
		input.stream().sorted().forEach(number -> System.out.println(number));
		
		
		/* input.stream().sorted(Comparator.reverseOrder()).forEach(number -> System.out.println(number));
		 System.out.println("----------------------------------------------------");
		 input.stream().sorted(Comparator.naturalOrder()).forEach(number -> System.out.println(number)); */
		
		
		
	}

}
