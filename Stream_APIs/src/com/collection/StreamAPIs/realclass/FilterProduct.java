package com.collection.StreamAPIs.realclass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Product {

	String prodName;
	int price;

	public Product(String prodName, int price) {
		super();
		this.prodName = prodName;
		this.price = price;
	}

	public static List<String> prodList(List<Product> product){
		
		return (List<String>) product.stream().filter(p -> p.price > 1000).map(prod -> prod.prodName + "-" + (prod.price - (prod.price/10))).collect(Collectors.toList());
	}
}

public class FilterProduct {

	public static void main(String[] args) {
		List<Product> products = Arrays.asList(new Product("HardDisk", 5000), new Product("Phone Cover", 250),
				new Product("Headphones", 1500), new Product("Keyboard", 1200), new Product("Mouse", 800),
				new Product("Monitor", 15000), new Product("Tablet", 18000), new Product("Speaker", 350));

		List<String> result = Product.prodList(products);
		System.out.println(result);
	}

}
