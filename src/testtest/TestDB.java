package testtest;

import static org.junit.Assert.*;
import entity.login.CustomerDB;
import org.junit.Test;

public class TestDB {

	@Test
	public void test() {
		CustomerDB customer = new  CustomerDB();
		customer.addCustomer("Hans Hansen", "12345678");
		assertEquals("Hans Hansen", customer.getCustomer("12345678").getName());
	
	}

	
	@Test
	public void test2() {
		CustomerDB customer = new  CustomerDB();
		customer.addCustomer("John Johnson", "123123112");
		assertEquals("Hans Hansen", customer.getCustomer("12312312").getName());
	
	}
	

	
}