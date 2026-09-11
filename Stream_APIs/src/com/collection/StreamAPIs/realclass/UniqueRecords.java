package com.collection.StreamAPIs.realclass;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueRecords {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("CHE","BLR", "AHM", "HYD", "CH","DL", "HYD","GNOD","CCH");
		List<String> output = list.stream().distinct().collect(Collectors.toList());
		
		System.out.println(output);
		
	Set<String> set	 = list.stream().collect(Collectors.toSet());
	System.out.println(set);
	
	list.stream().filter(n -> n.startsWith("C")).limit(5).forEach(n -> System.out.println(n));

	}

}
