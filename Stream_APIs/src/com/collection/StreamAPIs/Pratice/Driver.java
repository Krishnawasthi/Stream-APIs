package com.collection.StreamAPIs.Pratice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Driver {

	public static void main(String[] args) {

		List<String> brand = Arrays.asList("nokia", "motorola", "apple", "samsung", "realme", "redmi");

		System.out.println("input: " + brand);

		// process the collections -- Task ---> convert all the brand to upper case

		// 1. Convert the collection(list) to Stream Object

		Stream<String> stream = brand.stream();

		// 2. Apply processing logic (intermideate and terminal)

		Stream<String> upperCaseStream = stream.map(word -> word.toUpperCase());

		// 3. Collect the result / terminate the Stream

		List<String> processedBrand = upperCaseStream.collect(Collectors.toList());

		System.out.println("Processed brand: " + processedBrand);
	}

}
