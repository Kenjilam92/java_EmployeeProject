package UseEmployee;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import tools.*;

public class Employee {
	private int empNo;
	private String name;
	private double salary;
	private Address address;
	
	
	public Employee( int no, String n, double s, String c, String st) {
		empNo = no;
		name = n;
		salary = s;
		address = new Address(c,st);
	}
	
	
	public int getEmpNo() {
		return empNo;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public Address getAddress() {
		return address;
	}
	public Employee setName(String n) {
		name = n;
		return this;
	}
	public Employee setSalary(double s) {
		salary = s;
		return this;
	}
	public Employee setAddress(String c, String s) {
		address.setCity(c);
		address.setState(s);
		return this;
	}	
	public void showInfo() {
		System.out.println("|\t" + empNo + "\t|\t"+ name + "\t|\t$" + salary + "\t\t|\t" +address.toString());
	}		
}
