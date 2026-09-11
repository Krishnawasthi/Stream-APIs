package com.collection.StreamAPIs.realclass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ThirdSalary {

	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(
			   12000, 67000, 34000, 89000, 45000, 23000, 76000, 51000,94000,
			    91000, 94000,78000, 90000, 91000
			);
		
		int output = num.stream().distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst().get();
		System.out.println(output);
		
	}

}
