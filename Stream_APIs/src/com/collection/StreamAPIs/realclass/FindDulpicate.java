package com.collection.StreamAPIs.realclass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDulpicate {

	public static void main(String[] args) {
		List<String> name = Arrays.asList("CHE", "BLR", "AHM", "HYD", "CHE", "DL", "HYD", "GNOD", "BLR", "CHE");
		//print the duplicate element
		Set<String> set = new HashSet<String>();
		
		
		name.stream().filter(n -> ! set.add(n)).forEach(n -> System.out.println(n));
	}

}
