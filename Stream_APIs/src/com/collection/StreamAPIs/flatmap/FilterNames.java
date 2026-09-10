package com.collection.StreamAPIs.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNames {

	public static void main(String[] args) {
		List<List<String>> names = Arrays.asList(
			    Arrays.asList("ajay", "karan", "rahul", "komal", "rohit", "kavita"),
			    Arrays.asList("aman", "neha", "krishna", "varun", "kiran", "pooja", "kunal"),
			    Arrays.asList("ravi", "karishma", "ankit", "meena", "kabir", "sahil", "kajal", "arjun"),
			    Arrays.asList("vikas", "kriti", "mohan", "karthik", "riya", "deepak"),
			    Arrays.asList("nikhil", "kanika", "sumit", "keshav", "priya", "rohan", "karan")
			);

		
	List<String> outputStream = names.stream().flatMap(list -> list.stream()).filter( w -> w.startsWith("k")).map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()).filter(w -> w.length() > 5).collect(Collectors.toList());

	System.out.println(outputStream);
	
	}
	
	

}
