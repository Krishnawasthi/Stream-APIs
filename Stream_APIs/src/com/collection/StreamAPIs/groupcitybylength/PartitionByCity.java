package com.collection.StreamAPIs.groupcitybylength;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionByCity {

	public static void main(String[] args) {
		List<String> cities = Arrays.asList(
			    "Bangalore", "Pune", "Chennai", "Hyderabad", "Delhi", "Noida", "Mysore",
			    "Mumbai", "Indore", "Nagpur", "Patna", "Ranchi", "Jaipur", "Lucknow",
			    "Kolkata", "Kochi", "Surat", "Bhopal", "Raipur", "Shimla"
			);
		
		//partition the data based on the length  [devide the data into parts]
		
		Map<Boolean, List<String>> city = cities.stream().collect(Collectors.partitioningBy(word -> word.length() > 6));
        System.out.println(city);

	}

}
