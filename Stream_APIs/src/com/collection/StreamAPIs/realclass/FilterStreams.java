package com.collection.StreamAPIs.realclass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterStreams {

	public static void main(String[] args) {
	
		List<String> names = Arrays.asList("ajay", "abhijeet", "raman", " raghav", "aman", "rehan", "ankush", "avnish");
		
		//find name start with A
		
		// 1. convert into streams
		
		Stream<String> inputStream = names.stream();
		
		// 2. apply filter on stream
		
	Stream<String>  filterStream = inputStream.map(w -> w.trim().substring(0, 1).toUpperCase()+ w.trim().substring(1)).filter(word -> word.startsWith("A"));
	
	    //3. change filter stream to list(collect or print),
	
	List<String>  outputStream =  filterStream.collect(Collectors.toList());
		
		//name starts with "a"
       System.out.println(outputStream );
	}

}
