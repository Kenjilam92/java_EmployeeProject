package UseEmployee;
import tools.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

	public ArrayList<Employee> data ;	
	public EmployeeServiceImpl() {
		updateData();
	}
	
	private void updateData() {
		String QUERY = "select * from emp";
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try(Connection con = ConectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY))
		    {	
//				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
				while(rs.next()){
				int no = rs.getInt("empno");
				String name = rs.getString("ename");
				double salary = rs.getDouble("salary");
				String city = rs.getString("city");
				String state = rs.getString("state");
//				System.out.println("Connection");
				employeeList.add(new Employee(no,name,salary,city,state));
				}//try
//				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
		} catch (SQLException e) {e.printStackTrace(); }
		
		data = employeeList;
		
	}
	@Override
	public double calculateYearlySalary(Employee e) {
		return e.getSalary()*52*40;
	}
	@Override
	public void displayAll() {
		System.out.println("|\tNo.\t|\tName\t|\tsalary\t\t|\tAddress");
		data.stream()
			.collect(Collectors.toList())
			.forEach( emp -> emp.showInfo());
	}
	@Override
	public void displayEmployeeByNo(int empNo) {
		try {
		System.out.println("|\tNo.\t|\tName\t|\tsalary\t\t|\tAddress");
		data .stream()
				.filter( emp -> emp.getEmpNo() == empNo)
				.findFirst()
				.orElse(null)
				.showInfo();
		}
		catch (Exception e){
			System.out.println("Data not found");
		}
	}
	@Override
	public void addEmployee(Employee e) {
		// TODO Auto-generated method stub
		try (
				Connection conn = ConectionUtil.getConnection();
				CallableStatement stmt=conn.prepareCall("{call create_emp(?,?,?,?,?)}")
			)
	    {	 
			stmt.setInt(1,e.getEmpNo());  
			stmt.setString(2,e.getName());  
			stmt.setDouble(3,e.getSalary());
			stmt.setString(4, e.getAddress().getCity());
			stmt.setString(5, e.getAddress().getState());
			stmt.execute();
			System.out.println("New employee added");
			updateData();
	    } 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		String QUERY = "UPDATE emp SET ename=?, salary=?, city=?, \"state\"=? WHERE empno=? "; 
		try (Connection conn = ConectionUtil.getConnection();
	             java.sql.PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) 
	     {	
			preparedStatement.setString(1, e.getName() );
			preparedStatement.setDouble(2, e.getSalary() );
		    preparedStatement.setString(3, e.getAddress().getCity() );
		    preparedStatement.setString(4, e.getAddress().getState());
			preparedStatement.setInt(5, e.getEmpNo());
	        preparedStatement.executeUpdate();
	   	   	System.out.println("data updated");
	   	   	
	     }
		 catch( SQLException ex)
	     {
	    	 System.out.print(ex);
	    	 System.out.println(" Row cannot be updated");
	     }
		 updateData();
	}
	@Override
	public void deleteEmployee(Employee e) {
		// TODO Auto-generated method stub
		String QUERY = "Delete from emp where empno = ?";
	     try (Connection conn = ConectionUtil.getConnection();
	             java.sql.PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) 
	     {		
	    	 preparedStatement.setInt(1, e.getEmpNo());
	         preparedStatement.executeUpdate();
	         System.out.println(e.getName()+"'s data is deleted");
	     }catch( SQLException ex)
	     {
	    	 System.out.println(" Row cannot be deleted");
	     }
	     updateData();
	}
	
	
	@Override
	public Employee findEmployeeByNo(int empNo) {
		// TODO Auto-generated method stub
		return data .stream()
					.filter( emp -> emp.getEmpNo() == empNo )
					.findFirst()
					.orElse(null);
	}
	
}
