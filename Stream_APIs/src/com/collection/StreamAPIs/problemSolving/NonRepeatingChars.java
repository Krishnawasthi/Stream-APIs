package com.collection.StreamAPIs.problemSolving;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NonRepeatingChars {

	public static void main(String[] args) {
		String input = "swiss";
		
	List<Character> output = input.chars().mapToObj(c ->(char) c).filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch)).collect(Collectors.toList());
	   System.out.println(output);
	   
	   //find first non repeating char
	   Character output1 = input.chars().mapToObj(c ->(char) c).filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch)).findFirst().get();
	   System.out.println(output1);
	}
	

}
