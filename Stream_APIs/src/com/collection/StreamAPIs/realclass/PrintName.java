package com.collection.StreamAPIs.realclass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintName {

	public static void main(String[] args) {

		List<String> empNames = Arrays.asList("ajay", "abhijeet", "raman", " raghav", "aman", "rehan", "ankush", "avnish");
		System.out.println("---------------------------------------------------------");
		//Approach1
		empNames.stream().map(w -> w.trim().substring(0, 1).toUpperCase() + w.trim().substring(1).toLowerCase())
				.map(w -> w.concat(" Kumar")).filter(word -> word.startsWith("A")).forEach(w -> System.out.println(w));
		
		
		System.out.println("---------------------------------------------------------");
		//Approach1
		List<String> filterName = empNames.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
		System.out.println(filterName);
		
		//terminal oeration will be called only once(used to terminate the stream)
		//intermediate can called multiple times
	}

}
