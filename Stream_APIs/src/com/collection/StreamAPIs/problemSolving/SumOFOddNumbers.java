package com.collection.StreamAPIs.problemSolving;

import java.util.Arrays;
import java.util.List;

public class SumOFOddNumbers {

	public static void main(String[] args) {
		
   List<Integer> numbers = Arrays.asList(2, 5, 1, 8, 3, 4, 6, 7);
		
		//find the sum of odd numbers
    
 int sumOdd =   numbers.stream().filter(n -> n%2 != 0).reduce(0, (a,b) -> a+b);
   System.out.println("sum of the Odd numbers: " + sumOdd);
   
   int sumEven =   numbers.stream().filter(n -> n%2 == 0).reduce(0, (a,b) -> a+b);
   System.out.println("sum of the Even numbers: " + sumEven);
	}
}
