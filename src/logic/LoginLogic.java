package logic;

import java.util.ArrayList;

import entity.login.Employee;

public class LoginLogic {
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public LoginLogic(){
		employees.add(new Employee(true, true, "ErAktiv", "ErAdmin"));
		employees.add(new Employee(true,false, "ErAktiv","ErIkkeAdmin"));
		employees.add(new Employee(false,true, "ErIkkeAktiv","ErAdmin"));
		employees.add(new Employee(false,false,"ErIkkeAktiv","ErIkkeAdmin"));
	}
	
	public boolean validateLogin(String username, String password){
		for(Employee e:employees){
			if(e.getUsername() == username && e.getPassword() == password)
				return true;
		}
		return false;
	}
}
