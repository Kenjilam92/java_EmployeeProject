package UseEmployee;
import tools.*;
import java.util.*;
import java.util.stream.Collectors;

public interface EmployeeService {
	public double calculateYearlySalary(Employee e); 
	public void displayAll();
	public void displayEmployeeByNo( int empNo );
	public void addEmployee( Employee e );
	public void updateEmployee ( Employee e);
	public void deleteEmployee(Employee e);
	public Employee findEmployeeByNo(int empNo);
}
