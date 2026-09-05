package com.collection.StreamAPIs.skip;

import java.util.Arrays;
import java.util.List;

public class SkipNumber {

	public static void main(String[] args) {
		
List<Integer>  input = Arrays.asList(23,12,34,43,56,54,15,43,76);
		
		input.stream().skip(4).forEach(number -> System.out.println(number));

	}

}
