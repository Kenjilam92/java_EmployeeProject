package UseEmployee;
import tools.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService,Print {

	public ArrayList<Employee> data ;	
	public EmployeeServiceImpl() {
		data = new ArrayList<Employee>();
		data.add(new Employee("Kenji", 12.45, "Centreville", "Virginia"));
		data.add(new Employee("Alex", 8.45, "Fairfax", "Virginia"));
	}
	
	@Override
	public ArrayList<Employee> getData() {
		// TODO Auto-generated method stub
		return data;
	}
	@Override
	public Employee findByEmployeeNo(int empNo) {
		// TODO Auto-generated method stub
		return data .stream()
					.filter( emp -> emp.getEmpNo() == empNo && emp.getIsDeleted() == false)
					.findFirst()
					.orElse(null);
	}
	
	
	
//	public static void add(Employee e) {
//		data.add(e);
//	}
//	public static void displayAll() {
//		System.out.println("|\tNo.\t|\tName\t|\tsalary\t\t|\tAddress");
//		EmployeeServiceImpl.data.stream()
//				.filter( emp -> emp.getIsDeleted() == false)
//				.collect(Collectors.toList())
//				.forEach( emp -> emp.showInfo());
//	}
}
