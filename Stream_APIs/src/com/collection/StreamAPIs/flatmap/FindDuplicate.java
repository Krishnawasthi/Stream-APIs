package com.collection.StreamAPIs.flatmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicate {

	public static void main(String[] args) {
		
		List<List<String>> input = Arrays.asList(Arrays.asList("Banglore", "Chennai","Hyderabad", "Ahmedabad", "delhi"),
				Arrays.asList("Mysore", "Bellandur","Lucknow","Chennai","Chennai"));
		HashSet<String> set = new HashSet<String>();
	   List<String>  str =  input.stream().flatMap(f -> f.stream()).distinct().collect(Collectors.toList());
	   System.out.println(str);
		
		// input.stream().flatMap(word -> word.stream()).filter(element -> ! set.add(element)).forEach(System.out::println);
		
		//input.stream().flatMap(word -> word.stream()).filter(e -> set.add(e)).forEach(w -> System.out.println(w));
	}

}
