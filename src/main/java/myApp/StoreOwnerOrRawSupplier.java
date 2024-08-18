package myApp;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class StoreOwnerOrRawSupplier {
public String username;
public	String password;
public static String email;
 public static ArrayList<StoreOwnerOrRawSupplier> list = new ArrayList<StoreOwnerOrRawSupplier>();
	public static boolean logedIn(StoreOwnerOrRawSupplier so) {
		for(int i=0 ; i<list.size();i++)
		{
			if(list.get(i).getUsername().equals(so.getUsername()))
				return true;
					
		}
		return false;
	}
	public StoreOwnerOrRawSupplier() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static ArrayList<StoreOwnerOrRawSupplier> getList() {
		return list;
	}
	public static void setList(ArrayList<StoreOwnerOrRawSupplier> list) {
		StoreOwnerOrRawSupplier.list = list;
	}
	public StoreOwnerOrRawSupplier(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		StoreOwnerOrRawSupplier.email = email;
	}

	public void PrintStoreOwner() {
		for (Map.Entry<String, User> entry : myappsweet.getOwners().entrySet()) {
		    String key = entry.getKey();
		    User user = entry.getValue();
		    System.out.println("Key: " + key + ", Value: " + user);
		}

	}
	
	
	
	
	
}
