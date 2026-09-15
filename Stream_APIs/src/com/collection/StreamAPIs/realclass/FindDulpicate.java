package com.collection.StreamAPIs.realclass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDulpicate {

	public static void main(String[] args) {
		List<String> name = Arrays.asList("CHENNAI", "BLROR", "AHMBAD", "HYDBAD", "CHENNAI", "DLHI", "HYDBAD", "GNOD", "BLRLORE", "CHENNAI");
		//print the duplicate element
		Set<String> set = new HashSet<String>();
		
		
		name.stream().filter(n -> ! set.add(n)).forEach(n -> System.out.println(n));
		name.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream().filter(e -> e.getValue() > 1).forEach(System.out::println);
	}

}
