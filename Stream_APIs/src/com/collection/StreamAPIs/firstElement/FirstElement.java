package com.collection.StreamAPIs.firstElement;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FirstElement {

	public static void main(String[] args) {
List<Integer>  input = Arrays.asList(23,12,34,43,56,54,15,43,76);
		
		Optional<Integer> optional = input.stream().findFirst();
		System.out.println(optional.get());

	}

	}


