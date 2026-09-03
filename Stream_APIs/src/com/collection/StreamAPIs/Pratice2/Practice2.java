package com.collection.StreamAPIs.Pratice2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.collection.StreamAPIs.Pratice.ProductData;

public class Practice2 {

	public static void main(String[] args) {
		
		ProductData data1 = new ProductData("Shirt", 9000);
		ProductData data2 = new ProductData("joggers", 5400);
		ProductData data3 = new ProductData("Bottoms", 11000);
		ProductData data4 = new ProductData("Shoes", 15330);
		ProductData data5 = new ProductData("Belts", 6700);
		ProductData data6 = new ProductData("T-Shirt", 1800);
		ProductData data7 = new ProductData("Jacket", 12000);
		ProductData data8 = new ProductData("Cap", 4900);
		ProductData data9 = new ProductData("Socks", 5800);
		ProductData data10 = new ProductData("Watch", 15000);
		ProductData data11 = new ProductData("Wallet",2500);
		ProductData data12 = new ProductData("Hoodie", 7500);
		ProductData data13 = new ProductData("Sneakers", 190700);
		ProductData data14 = new ProductData("Jeans", 4500);
		ProductData data15 = new ProductData("Sunglasses", 3500);
		
		List<ProductData> list = new ArrayList<>();
		
		list.add(data1);
		list.add(data2);
		list.add(data3);
		list.add(data4);
		list.add(data5);
		list.add(data6);
		list.add(data7);
		list.add(data8);
		list.add(data9);
		list.add(data10);
		list.add(data11);
		list.add(data12);
		list.add(data13);
		list.add(data14);
		list.add(data15);
		
		
		//Task --> find the product which are starts with letter "S".
		
		//1.convert list into Stream
		Stream<ProductData> brand = list.stream();
		
        //2. write the process logic on stream
		
		List<String> filterstream =  brand.filter(f -> f.getName().startsWith("S")).map(word -> word.getName().toUpperCase() + ": " + word.getPrice())
				.collect(Collectors.toList());
		
		filterstream.forEach(word -> System.out.println(word));
		
		}
	}


