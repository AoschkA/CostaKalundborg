package test;

import static org.junit.Assert.*;
import logic.LoginLogic;

import org.junit.Test;

import entity.login.Employee;

public class LoginDB {

	@Test
	public void test() {
		LoginLogic ll = new LoginLogic();
		ll.addEmployee(true, "Admin", "pass");
		assertEquals(true, ll.validateLogin("Admin", "pass"));
		
	}

	@Test
	public void test2() {
		LoginLogic ll = new LoginLogic();
		ll.addEmployee(true, "Admin", "password");
		assertEquals(true, ll.validateLogin("Admin", "passwort"));
		
	}
	
	@Test
	public void test3() {
		Employee emp = new Employee(true, true, "Admin", "pass");
		emp.setUsername("SysAdmin");
		assertEquals("SysAdmin", emp.getUsername());
		
	}
	
	@Test
	public void test4() {
		Employee emp = new Employee(true, true, "Admin", "pass");
		emp.setUsername("SysAdmin");
		assertEquals("NotAdmin", emp.getUsername());
		
	}
	
	@Test
	public void test5() {
		Employee emp = new Employee(true, true, "Admin", "pass");
		emp.setActive(false);
		assertEquals(false, emp.isActive());
		
	}
	
	@Test
	public void test6() {
		Employee emp = new Employee(true, true, "Admin", "pass");
		emp.setActive(false);
		assertEquals(true, emp.isActive());
		
	}
	
	@Test
	public void test7() {
		Employee emp = new Employee(true, true, "Admin", "pass");
		emp.setAdmin(false);
		assertEquals(false, emp.isAdmin());
		
	}
	
	@Test
	public void test8() {
		Employee emp = new Employee(true, true, "Admin", "pass");
		emp.setAdmin(false);
		assertEquals(true, emp.isAdmin());
		
	}
	
	@Test
	public void test9() {
		Employee emp = new Employee(true, true, "Admin", "pass");
		emp.setPassword("password");
		assertEquals("password", emp.getPassword());
		
	}
	
	@Test
	public void test10() {
		Employee emp = new Employee(true, true, "Admin", "pass");
		emp.setPassword("passwort");
		assertEquals("password", emp.getPassword());
		
	}
}
