package UseEmployee;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import tools.*;

public class Employee implements Print{
	public static Integer empAutoId; 
	private int empNo;
	private String name;
	private double salary;
	private Address address;
	private static ArrayList<Employee> data;
	private boolean isDeleted;
	
	public Employee( String n, double s, String c, String st) {
		if (Employee.empAutoId==null) {
			Employee.empAutoId=1;
		}
		else {
			Employee.empAutoId++;
		}
		if (data == null) {
			data= new ArrayList<Employee>();
		}
		empNo = empAutoId;
		name = n;
		salary = s;
		address = new Address(c,st);
		isDeleted=false;
		data.add(this);
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
	public String getAddress() {
		return address.toString();
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
		println("|\t" + empNo + "\t|\t"+ name + "\t|\t$" + salary + "\t\t|\t" +address.toString());
	}
	public static ArrayList<Employee> getData(){
		return data;
	}
	public static void displayAll() {
		System.out.println("|\tNo.\t|\tName\t|\tsalary\t\t|\tAddress");
		data.stream()
				.filter( emp -> emp.getIsDeleted() == false)
				.collect(Collectors.toList())
				.forEach( emp -> emp.showInfo());
	}
	
	
	
	public static Employee findByEmployeeNo( int empNo) {
		return data .stream()
					.filter( emp -> emp.getEmpNo() == empNo && emp.isDeleted == false)
					.findFirst()
					.orElse(null);
	}
	
	public static void  showRecycleBin () {
		System.out.println("|\tNo.\t|\tName\t|\tsalary\t\t|\tAddress");
		data.stream()
			.filter(emp -> emp.isDeleted == true)
			.collect(Collectors.toList())
			.forEach(  Employee::showInfo );			
	}
	public static Employee selectAnDeletedEmployee(int empNo) {
		return data .stream()
					.filter( emp -> emp.getEmpNo() == empNo && emp.isDeleted == true)
					.findFirst()
					.orElse(null);
	}
	public static void permanentDelete( Employee e) {
//		data.remove( data	.stream()
//							.filter( emp -> emp.getEmpNo() == empNo && emp.isDeleted == true)
//							.findFirst()
//							.orElse(null)
//		);
		data.remove(e);
	}
	
	
	public double calculateYearlySalary() {
		return salary*40*52;
	}
	
	public Employee updateEmployee( Scanner input ) {
		println("What do you want to update?");
		println("1. Name | 2. salary | 3. Adrress | 4.Cancel");
		print("Answer: ");
		switch(input.nextInt()) {
			case 1:{
				print("New name: ");
				this.setName(input.next());
				break;
			}
			case 2:{
				print("New salary: ");
				this.setSalary(input.nextDouble());
				break;
			}
			case 3:{
				print("City: ");
				address.setCity(input.next());
				print("State: ");
				address.setState(input.next());
				break;
			}
			case 4: {
				break;
			}
			default: {
				println("Invalid value!");
				return updateEmployee(input);
			}
		}
		return this;
	}
	
	public boolean getIsDeleted() {
		return isDeleted;
	}
	public boolean delete() {
		isDeleted = true;
		println(name + " is deleted");
		return true;
	}
	public boolean restore() {
		isDeleted = false;
		println(name + " is restored");
		return true;
	}
}
