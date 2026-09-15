package com.collection.StreamAPIs.problemSolving;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionBy {

	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(
			    12, 67, 34, 89, 45, 23, 76, 51,
			    9, 94, 38, 62, 17, 55, 41, 83
			    
			);
		
		
		Map<Boolean, List<Integer>> output = num.stream().collect(Collectors.partitioningBy(n -> n%2 == 0));
		System.out.println(output);

	}

}
