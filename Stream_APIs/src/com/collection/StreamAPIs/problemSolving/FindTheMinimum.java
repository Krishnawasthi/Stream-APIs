package com.collection.StreamAPIs.problemSolving;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindTheMinimum {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2, 5, 1, 8, 3, 4, 6, 7);
		
		//Approach1
		numbers.stream().sorted(Comparator.naturalOrder()).limit(1).forEach(System.out:: println);
		
		//Approach2
		numbers.stream().sorted().limit(1).forEach(System.out:: println);
		
		//Approach3
		numbers.stream().sorted().findFirst().ifPresent(min -> System.out.println(min));
		
		//Approach4
		int minNumber = numbers.stream().reduce(Integer.MAX_VALUE, (a, b) -> a<b ? a:b);
		
		System.out.println(minNumber);
		
		//Approach5
		Optional<Integer> minimum = numbers.stream().reduce((a,b) -> (a<b) ? a:b);
		
		minimum.ifPresent(min -> System.out.println(min));
		
		//Approach6
		Optional<Integer> min = numbers.stream().min(Comparator.naturalOrder());
		System.out.println(min.get());
		
		//Appraoch7
		Optional<Integer> minNum =  numbers.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
		System.out.println(minNum.get());
		
		//Appraoch8 [int Stream(If working with primitives)]
		int minIntNum = numbers.stream().mapToInt(Integer :: IntValue).min().getAsInt();
		System.out.println(minIntNum);
		
        
	}

}
