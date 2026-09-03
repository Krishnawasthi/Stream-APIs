package com.collection.StreamAPIs.Pratice2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterCities {

	public static void main(String[] args) {
		
		
		List<String> cities = Arrays.asList(  "Boston", "Brussels", "Budapest", "London", "Paris", "Tokyo", "Beijing",
				"New York","Berlin", "Sydney", "Toronto", "Bangkok", "Dubai", "Singapore","Barcelona");
		
	//Changes cities list to Stream --> process the first operation [to starsWith (K)] --> process the second operation [length >= 6]
	//Adding terminal Operation to perform the intermediate operations because intermediate operations are ----> Lazy
		
	   	
		List<String> output = cities.stream().filter(word -> word.startsWith("B") && word.length() > 6).collect(Collectors.toList());
	   	
       
		System.out.println(output);
		
	}

}
