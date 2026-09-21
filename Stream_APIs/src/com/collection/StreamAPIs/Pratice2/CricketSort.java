package com.collection.StreamAPIs.Pratice2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CricketSort {

	public static void main(String[] args) {
		
		List<String> player = Arrays.asList("Ravi","Dhoni","Kohli","Rahul","Sachin","Jadeja","Rohit","Mayank","Rishabh");
	int strLength = player.stream().filter(n -> n.startsWith("R")).mapToInt(String::length).reduce(0,(acc, n) -> acc+n);
	System.out.println(strLength);
	}

}
