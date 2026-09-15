package com.collection.StreamAPIs.realclass;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {

	public static void main(String[] args) {
		List<String> cities = Arrays.asList("Delhi", "Mumbai", "Bangalore", "Chennai", "Hyderabad", "Kolkata", "Pune",
				"Jaipur", "Ahmedabad", "Lucknow");
		
		
		// count() vs Collectors.counting()
		long total = cities.stream().collect(Collectors.counting());
             System.out.println(total);
             
             
       Map<Object, List<String> > city =  cities.stream().collect(Collectors.groupingBy(c -> c.length()));
       System.out.println(city);
	}

}
