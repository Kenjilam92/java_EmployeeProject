package UseEmployee;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import tools.*;

public class Employee {
	public static Integer empAutoId; 
	private int empNo;
	private String name;
	private double salary;
	private Address address;
	private boolean isDeleted;
	
	public Employee( String n, double s, String c, String st) {
		if (Employee.empAutoId==null) {
			Employee.empAutoId=1;
		}
		else {
			Employee.empAutoId++;
		}
		empNo = empAutoId;
		name = n;
		salary = s;
		address = new Address(c,st);
		isDeleted=false;
//		EmployeeServiceImpl.add(this);
	}
	public Employee() {
		// TODO Auto-generated constructor stub
		if (Employee.empAutoId==null) {
			Employee.empAutoId=1;
		}
		else {
			Employee.empAutoId++;
		}
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
	
	
	public boolean getIsDeleted() {
		return isDeleted;
	}
	public boolean delete() {
		isDeleted = true;
		System.out.println(name + " is deleted");
		return true;
	}
	public boolean restore() {
		isDeleted = false;
		System.out.println(name + " is restored");
		return true;
	}
}
