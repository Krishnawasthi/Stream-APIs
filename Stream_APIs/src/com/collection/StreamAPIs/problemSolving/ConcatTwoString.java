package com.collection.StreamAPIs.problemSolving;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatTwoString {

	public static void main(String[] args) {
		
		List<String> list1 = Arrays.asList("Bangalore", "Delhi", "Pune", "Chennai", "Hyderabad");
		List<String> list2 = Arrays.asList("Delhi", "Noida", "Mysore", "Delhi");
		
		//concat the  two lists
		Stream.concat(list1.stream(),list2.stream()).distinct().forEach(System.out::println);
		
		//find the max length of which city
		System.out.println("----------------------------------------------------------------------------");
		Optional<String> output = Stream.concat(list1.stream(),list2.stream()).max(Comparator.comparingInt(w -> w.length()));
		System.out.println(output.get());
		Stream.concat(list1.stream(),list2.stream()).max(Comparator.comparingInt(w -> w.length())).ifPresent(System.out::println);
	}

}
