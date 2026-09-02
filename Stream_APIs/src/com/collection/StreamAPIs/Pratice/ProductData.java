package com.collection.StreamAPIs.Pratice;

public class ProductData{

	String prodName;
	int prodPrice;

	public ProductData(String prodName, int prodPrice)
	{
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		
	}
	
	public String getName() {
		
		return prodName;
	}
	
   public int getPrice() {
		
		return prodPrice;
	}
   
   
 
  
  @Override
   public String toString() 
   {
	return "Product Name: " + prodName + ", Product Price: " + prodPrice ;
	   
	   
   }
   
   
}
