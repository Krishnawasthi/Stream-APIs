package com.collection.StreamAPIs.Pratice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductDriver
{
	public static void main(String[] args)
	{
      
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
		ProductData data13 = new ProductData("Sneakers", 11000);
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
		
		// Task 1 --> Get the product which Price are more than 8k
		
		//1. convert ArrayList to Stream
		Stream<ProductData> stream = list.stream();
		
		//2. Write the processing Logic 1;
	
		Stream<ProductData> filterStream = stream.filter(p -> p.getPrice()  > 8000);
		
			List<ProductData> filterList = filterStream.collect(Collectors.toList());
		
		for(ProductData filterProduct : filterList ) {

			System.out.println(filterProduct);
			}
			
	     
	}

}
