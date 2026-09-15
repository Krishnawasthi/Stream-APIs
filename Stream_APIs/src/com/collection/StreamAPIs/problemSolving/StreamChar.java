package com.collection.StreamAPIs.problemSolving;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamChar {

	public static void main(String[] args) {
		String input = "swiss";
		
		
     Map<Character, Long> out =  input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
     System.out.println(out);
    
    
    
	}

}
