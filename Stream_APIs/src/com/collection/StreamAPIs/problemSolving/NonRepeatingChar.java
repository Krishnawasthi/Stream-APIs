package com.collection.StreamAPIs.problemSolving;

import java.util.Optional;

public class NonRepeatingChar {

	public static void main(String[] args) {
		String word = "swiss";
		// find the first non repeating char
		Optional<Character> ch = word.chars().mapToObj(c -> (char) c).filter(c -> word.indexOf(c) == word.lastIndexOf(c)).findFirst();
		System.out.println(ch.get());
	}

}
