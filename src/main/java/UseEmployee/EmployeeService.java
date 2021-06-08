package UseEmployee;
import tools.*;
import java.util.*;
import java.util.stream.Collectors;

public interface EmployeeService {
	public ArrayList<Employee> getData();
	public Employee findByEmployeeNo( int empNo );
	
	
//	public static ArrayList<Employee> getData(){
//		return EmployeeServiceImpl.data;
//	};
//		
//	public static double calculateYearlySalary(Employee e) {
//		return e.getSalary()*40*52;
//	}
//	
//	public void displayAll();
//	
//	public static Employee findByEmployeeNo( int empNo) {
//		
//	}
//	public static void  showRecycleBin () {
//		System.out.println("|\tNo.\t|\tName\t|\tsalary\t\t|\tAddress");
//		EmployeeServiceImpl.data.stream()
//			.filter(emp -> emp.getIsDeleted() == true)
//			.collect(Collectors.toList())
//			.forEach(  Employee::showInfo );			
//	}
//	public static Employee selectAnDeletedEmployee(int empNo) {
//		return EmployeeServiceImpl.data .stream()
//					.filter( emp -> emp.getEmpNo() == empNo && emp.getIsDeleted() == true)
//					.findFirst()
//					.orElse(null);
//	}
//	
//	public static Employee updateEmployee ( Employee e, Scanner input) {
//		System.out.println("What do you want to update?");
//		System.out.println("1. Name | 2. salary | 3. Adrress | 4.Cancel");
//		System.out.print("Answer: ");
//		switch(input.nextInt()) {
//			case 1:{
//				System.out.print("New name: ");
//				e.setName(input.next());
//				break;
//			}
//			case 2:{
//				System.out.print("New salary: ");
//				e.setSalary(input.nextDouble());
//				break;
//			}
//			case 3:{
//				System.out.print("City: ");
//				e.getAddress().setCity(input.next());
//				System.out.print("State: ");
//				e.getAddress().setState(input.next());
//				break;
//			}
//			case 4: {
//				break;
//			}
//			default: {
//				System.out.println("Invalid value!");
//				return updateEmployee(e,input);
//			}
//		}
//		return e;
//	}
//	
//	public static void permanentDelete( Employee e) {
//		EmployeeServiceImpl.data.remove(e);
//	}
//	
	
}
