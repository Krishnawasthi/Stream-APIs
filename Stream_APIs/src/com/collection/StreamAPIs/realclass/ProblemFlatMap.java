package com.collection.StreamAPIs.realclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemFlatMap {

	public static void main(String[] args) {
		List<List<Integer>> numbers = new ArrayList<>();

		numbers.add(Arrays.asList(10, 20, 30, 40));
		numbers.add(Arrays.asList(50, 60, 70, 80));
		numbers.add(Arrays.asList(90, 100, 110, 120));
		numbers.add(Arrays.asList(130, 140, 150, 160));
		
		List<Integer> oneDList = numbers.stream().flatMap(m -> m.stream()).collect(Collectors.toList());
		System.out.println("One Dimentional List: -> "+ oneDList);

	}

}
