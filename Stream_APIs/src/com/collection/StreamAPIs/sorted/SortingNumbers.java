package com.collection.StreamAPIs.sorted;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortingNumbers {

	public static void main(String[] args) {
		
		List<Integer>  input = Arrays.asList(12,34,43,7556,354,12,4543,7655,646,674,587,646,675,3453);
		
		List<Integer>  output = input.stream().sorted().collect(Collectors.toList());
		
		System.out.println(output);
		
	}

}
