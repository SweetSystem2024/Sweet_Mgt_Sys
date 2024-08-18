package myApp;
 


import java.util.Map;
import java.util.Map.Entry;

import myApp.myappsweet; 
import java.util.Objects;



public class User {
    private String username;
    private String password;
    private  String email;
    public Type kindofuser;
    private String city;
    private static int countnablus;
    private static int countjenin;


    public User(String username, String password, String email, Type kindofuser) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.kindofuser = kindofuser;
	}

    public Type getKindofuser() {
		return kindofuser;
	}

	public void setKindofuser(Type kindofuser) {
		this.kindofuser = kindofuser;
	}

	public User(String username, String password, String email, Type kindofuser, String city) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.kindofuser = kindofuser;
		this.city = city;
	}

	
	
	public User() {
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

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    

	

	@Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +  // Include password here

                ", email='" + email + '\'' +
                ", userType='" + kindofuser + '\'' +
                '}';
    }

	
	public static int UsersFromNablus() {
		 for (User obj : myappsweet.users.values()) 
			 if(obj.getCity().equals("Nablus"));
		countnablus++;
		return countnablus;
	}

	private String getCity() {
		// TODO Auto-generated method stub
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}



	public static int UsersFromJenin() {
		for (User obj : myappsweet.users.values()) 
			 if(obj.getCity().equals("Jenin"));
		countjenin++;
		return countjenin;
	}


  
}
