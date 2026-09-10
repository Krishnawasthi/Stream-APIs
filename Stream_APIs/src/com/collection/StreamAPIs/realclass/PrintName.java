package com.collection.StreamAPIs.realclass;

import java.util.Arrays;
import java.util.List;

public class PrintName {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("ajay", "abhijeet", "raman", " raghav", "aman", "rehan", "ankush", "avnish");

		names.stream().map(w -> w.trim().substring(0, 1).toUpperCase() + w.trim().substring(1).toLowerCase())
				.map(w -> w.concat(" Kumar")).filter(word -> word.startsWith("A")).forEach(w -> System.out.println(w));

		
		//terminal oeration will be called only once(used to terminate the stream)
		//intermediate can called multiple times
	}

}
