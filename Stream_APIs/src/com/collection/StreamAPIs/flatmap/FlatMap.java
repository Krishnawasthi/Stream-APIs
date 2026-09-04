package com.collection.StreamAPIs.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

	public static void main(String[] args) {
		List<List<String>> input = Arrays.asList(Arrays.asList("Banglore", "Chennai"), Arrays.asList("Hyderabad", "Ahmedabad", "delhi"), Arrays.asList("Mysore", "Bellandur"));
         
		System.out.println("Array 2d : " + input);
		
		List<String> flattenList = input.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		
		System.out.println("Array 1d : " + flattenList);
		
		flattenList.stream().filter(w -> w.startsWith("B") && w.length() > 5).forEach(word -> System.out.println(word));
	}

}
