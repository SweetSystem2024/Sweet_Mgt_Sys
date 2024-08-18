


package myApp;




import java.lang.*;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Product {

	int num_product;
	String name_of_product;
	double price;
	int count;
	int SalesCount;
	String UserNameOfOrderOwner;
	private int OrderId;
	private static int currentOrderId = 0; // Static counter for unique order IDs

	double totalprice;
	 //public static ArrayList<Product> list = new ArrayList<Product>();
	   static private Map<String, Product> listofproduct;
	   public static Map<String, Product> itemsbuy = new HashMap<String, Product>();

   public Product(int num_product2,String name ,double price2 , int count1) {
   num_product=num_product2;
   name_of_product=name;
   price=price2;
   count=count1;

	}
	
	
	
	public int getOrderId() {
	return OrderId;
}



public void setOrderId(int orderId) {
	OrderId = orderId;
}



	public Product() {
	}



	public Product(String name, int num) {
  name_of_product=name;
  this.SalesCount=num;
	}

	public Product(String name, int num ,String own,double price) {
		  name_of_product=name;
		  this.SalesCount=num;
		  this.UserNameOfOrderOwner=own;
		  this.price=price;
			this.OrderId = ++currentOrderId; 

			}

	public Product(int i, String string) {
		num_product=i;
		name_of_product=string;
	}

	public Product(String s1,int i, String string) {
		this.SalesCount=i;
		name_of_product=s1;
		this.UserNameOfOrderOwner=string;
		
	}


	
	public String getUserNameOfOrderOwner() {
		return UserNameOfOrderOwner;
	}



	public void setUserNameOfOrderOwner(String userNameOfOrderOwner) {
		UserNameOfOrderOwner = userNameOfOrderOwner;
	}



	public Product(String string) {
name_of_product=string;	}



	public Product(Product p, double n) {
      this.name_of_product=p.getName_of_product();
      this.num_product=p.getNum_product();
      
	}



	public int getNum_product() {
		return num_product;
	}
	
	public void setNum_product(int num_product) {
		this.num_product = num_product;
	}
	
	public String getName_of_product() {
		return name_of_product;
	}
	
	public void setName_of_product(String name_of_product) {
		this.name_of_product = name_of_product;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}



	public static boolean CheckIfExistToUpdate(String string) {
	//	myappsweet ap=new myappsweet();
      // listofproduct=ap.getProducts();
       for (Product obj : myappsweet.getProducts().values()) 
    	   if (obj.getName_of_product().equals(string)) {
               System.out.println("This product exists");
               return true;
           }

		return false;
	}



	



	


	@Override
	public String toString() {
		return "Product [num_product=" + num_product + ", name_of_product=" + name_of_product + ", price=" + price
				+ ", count=" + count + ", SalesCount=" + SalesCount + ", UserNameOfOrderOwner=" + UserNameOfOrderOwner
				+ "]";
	}



	public static boolean UpdateNameOfProduct(String string, String string2) {
		
		boolean existname=false;
		for (HashMap.Entry<String, Product> entry : myappsweet.products.entrySet()) {
        	Product product = entry.getValue();
        	if(product.getName_of_product().equals(string2))
        		existname=true;
        }
		
		if (string2.isEmpty() || existname) {
	        System.out.println("Sorry, you are missing important data OR repeated name");
	        return false;
	    }
		
	    
	    // Iterate over the products to find the one with the specified old name
	    for (Product product : myappsweet.getProducts().values()) {
	        if (product.getName_of_product().equals(string)) {
	        	 //Product.listofproduct.remove(string);
	            product.setName_of_product(string2); // Update the product name
	            product.setCount(product.getCount());
	            product.setNum_product(product.getNum_product());
	            System.out.println(product.getNum_product());

	            product.setPrice(product.getPrice());
	            System.out.println("Updating done successfully");
	            return true; 
	        }
	    }
	    System.out.println("Product with the name " + string + " not found.");
	    return false;
	}
	



	public static boolean CheckNameAndCount(String string, Integer int1) {
		for (Product product : myappsweet.getProducts().values()) {
            if (product.getName_of_product().equals(string) && product.getCount()==int1 ) {
            	myappsweet.getProducts().put(String.valueOf(product.getNum_product()), product);
                return true;
            }
        }

	return false;
		
		
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public static boolean CheckThenewcountispositive(Integer int1) {
		if(int1>0)
			return true;
		else
			{System.out.println("Please recheck the count of the product , it seems a negative ");
			return false;}
	}


	public static boolean SetNewCount(Integer int1, Integer int2, String string) {
	//	myappsweet ap=new myappsweet();
         if(CheckNameAndCount(string,int1)) {
	       listofproduct=myappsweet.getProducts();
	       for (Product product : listofproduct.values()) {
	            if (product.getName_of_product().equals(string)) {
	            	if(product.getCount() == int1)
	                product.setCount(int2);;
	                listofproduct.put(Integer.toString(product.getNum_product()), product);
	                System.out.println("Update done successfully");
	                return true;
	            }
	        }}
         else
        	 System.out.println();
		return false;
			}



	public boolean checkifwehaveEnoughItems(String string, int numberofitems) {
      
		 for (Product product : myappsweet.getProducts().values()) {
	            if (product.getName_of_product().equals(string)) {
	            	if(product.getCount()>=numberofitems)
	                return true;
	            }
		 }
		return false;
		
	}



	public boolean AddToChart(Product p) {
		double n=0.0;
		 Product v;
		//String x=String.valueOf(p.getOrderId());
		for (Product product : myappsweet.getProducts().values()) {
            if (product.getName_of_product().equals(p.getName_of_product())) {
               n=product.getPrice();
               Product c=new Product(product.getNum_product(),p.getName_of_product(),product.getPrice(),p.getSalesCount());
               Product d=new Product(p.getName_of_product(),p.getSalesCount(),p.getUserNameOfOrderOwner(),product.getPrice());
       		String x=String.valueOf(d.getOrderId());
            //   System.out.println(d.getOrderId());
               //System.out.println(d);
   			itemsbuy.put(x, d);
   			p.DecreaseTheNumberOfItems(p.getName_of_product(), p.getSalesCount());
   			boolean paiedmoney=false;
   			System.out.println("Do you want to order more?   (yes/no)");
   		 Scanner scanner = new Scanner(System.in);
         String s = scanner.nextLine();
             if(s.equals("yes"))
            	 paiedmoney=true;
             
			if(p.checkiftheuserBuySth() && !paiedmoney) {
   				HaveA10Discount();
			
   			System.out.print("The status of your order is:");
   			System.out.println(d.GetStatus(d));  }
   			
            }
             
			}
		return true;

	}

	public void DecreaseTheNumberOfItems(String string, int numberofitems) {
		 for (Product product : myappsweet.getProducts().values()) {
	            if (product.getName_of_product().equals(string)) {
	            	product.setCount(product.getCount()-numberofitems);;
	            	myappsweet.getProducts().put(Integer.toString(product.getNum_product()), product);
	            }
		 }
	boolean v=SetSales(string,numberofitems)	; 
		
	}



	private boolean SetSales(String s,int numberofitems) {
		for (Sales product : Sales.sales.values()) {
		if (product.getName().equals(s)) { 
			int x=product.getSale();
			product.setSale(x+numberofitems);
			return true;
		}
		}
		Sales.sales.put(s,new Sales(s,numberofitems));
		return false;
	}



	public boolean CheckWeDefineQuantity(Product p) {
      if(p.getNum_product()==0)
		return false;
      else
    	  return true;
	}



	public boolean checkiftheuserBuySth() {
		return !(itemsbuy.isEmpty());
	}


	 double pricee=0.0;

	public void HaveA10Discount() {
		 for (Product product : itemsbuy.values())
		 {
			  
		      pricee= pricee+(product.getPrice()*product.getSalesCount());
		      
		 }
		     System.out.print("Your total price after discount is:");
    		System.out.println(pricee-(pricee*0.1));
    		System.out.println("You have a discount 10% on your purchases");

	}
	


	public static Map<String, Product> getItemsbuy() {
		return itemsbuy;
	}



	public static void setItemsbuy(Map<String, Product> itemsbuy) {
		Product.itemsbuy = itemsbuy;
	}



	public int getSalesCount() {
		return SalesCount;
	}



	public String GetStatus(Product p) {
		
        if (itemsbuy.containsKey(String.valueOf(getOrderId()))) {
		return" Processing";		
	}
        else
    		return "failed";
	}



	
	
	
	
	
	
}
