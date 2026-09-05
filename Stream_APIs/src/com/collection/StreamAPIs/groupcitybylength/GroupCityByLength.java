package com.collection.StreamAPIs.groupcitybylength;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupCityByLength {

	public static void main(String[] args) {
		
		List<String> cities = Arrays.asList(
			    "Bangalore", "Pune", "Chennai", "Hyderabad", "Delhi", "Noida", "Mysore",
			    "Mumbai", "Indore", "Nagpur", "Patna", "Ranchi", "Jaipur", "Lucknow",
			    "Kolkata", "Kochi", "Surat", "Bhopal", "Raipur", "Shimla"
			);
		
		Map<Integer, List<String>> city = cities.stream().collect(Collectors.groupingBy(word -> word.length()));
           System.out.println(city);
           
          System.out.println("--------------------------------------------------------");
        Map<Integer, List<String>> cityLen = cities.stream().filter(c -> c.length() >= 5 && c.length() <= 7).collect(Collectors.groupingBy(word -> word.length()));
           System.out.println(cityLen);
	}

}
