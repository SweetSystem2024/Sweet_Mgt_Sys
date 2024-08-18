package myApp;

import java.util.HashMap;
import java.util.Map;

public class Sales {
String name;
int sale;
public static Map<String, Sales> sales= new HashMap<String, Sales>();

@Override
public String toString() {
	return "Sales [name=" + name + ", sale=" + sale + "]";
}
public static Map<String, Sales> getSales() {
	return sales;
}
public static void setSales(Map<String, Sales> sales) {
	Sales.sales = sales;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSale() {
	return sale;
}
public void setSale(int sale) {
	this.sale = sale;
}
public Sales(String name, int sale) {
	super();
	this.name = name;
	this.sale = sale;
}



}
