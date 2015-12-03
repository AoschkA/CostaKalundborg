package entity.login;




public class Customer {

	
	
	private String phonenumber=null;
	private String name=null;
	
	public Customer (String  name, String phonenumber) {
		this.name=name; 
		this.phonenumber=phonenumber; 
	}
	
	public String getPhonenumber() {return phonenumber;}
	public String getName() {if(name != null)return name; else{return null;}}
}


