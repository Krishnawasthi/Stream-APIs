package com.collection.StreamAPIs.Pratice2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice3 {

	

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(12, 35 ,45, 22,322,568, 585, 234, 432 ,923, 345);
		
		List<Integer> output = list.stream().map(n -> n*10).filter(num -> num%3 == 2).collect(Collectors.toList());

		System.out.println(output);
		
	}

}
