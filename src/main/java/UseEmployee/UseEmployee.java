package UseEmployee;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class UseEmployee {
	private static final Logger LOGGER = Logger.getLogger(UseEmployee.class.getName());
	
	public static void main (String[] args) {
		LOGGER.info("Logger Name: "+LOGGER.getName());
//        LOGGER.warning("can be outbound or unexpected value");
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		
		boolean isContinue = true;
		Scanner input = new Scanner(System.in);
		println("Welcomwe to the Employee Services!");
		
		
		do {
				try {
				printBorder();
				println("Which service do you want to use");
				println("1. Show all employees");
				println("2. Find an employee by employee #");
				println("3. Show anual salary");
				println("4. Add an employee");
				println("5. Update an employee");
				println("6. Delete an employee");
				println("7. Quit");
				int service = getIntAnswer(input);
				switch(service) {
					case 1:{
						printBorder();
						employeeServiceImpl.displayAll();
						break;
					}
					case 2:{
						printBorder();
						println("Please type an employee #");
						int empNo = getIntAnswer(input);
						Employee result = employeeServiceImpl.findEmployeeByNo(empNo);
						if (result == null) {
							println("NO RESULT WAS FOUND");
						}
						else {
							System.out.println("|\tNo.\t|\tName\t|\tSallery\t\t|\tAddress");
							result.showInfo();
						}
						continue;
					}
					//Show Annual Salary
					case 3:{
						printBorder();
						println("Please type an employee #");
						int empNo = getIntAnswer(input);
						Employee e = employeeServiceImpl.findEmployeeByNo(empNo);
						if(e==null) {
							println("Data not found");
							break; 
						}
						println(e.getName()+"'s anual salary: " + employeeServiceImpl.calculateYearlySalary(e) );
						break;
					}
					//Add
					case 4:{
						printBorder();
						print("Employee No: ");
						int empno = input.nextInt();
						print("Employee Name: ");
						String name = input.next();
						print("Salary hour rate: ");
						double salary = input.nextDouble();
						print("City: ");
						String city = input.next();
						print("State: ");
						
						String state = input.next();
						Employee newEmp = new Employee(empno,name,salary,city,state);
						employeeServiceImpl.addEmployee(newEmp);
						break;
					}
					//Update
					case 5:{
						printBorder();
						println("Please type an employee #");
						int empNo = getIntAnswer(input);
						Employee e = employeeServiceImpl.findEmployeeByNo(empNo);
						if(e==null) {
							println("Data not found");
							break; 
						}
						boolean keepEdit = true;
						do {
							System.out.println("What do you want to update?");
							System.out.println("1. Name | 2. salary | 3. Adrress | 4.Back");
							System.out.print("Answer: ");
							switch(input.nextInt()) {
								case 1:{
									System.out.print("New name: ");
									e.setName(input.next());
									break;
								}
								case 2:{
									System.out.print("New salary: ");
									e.setSalary(input.nextDouble());
									break;
								}
								case 3:{
									System.out.print("City: ");
									e.getAddress().setCity(input.next());
									System.out.print("State: ");
									e.getAddress().setState(input.next());
									break;
								}
								case 4: {
									keepEdit = false;
									break;
								}
								default: {
									System.out.println("Invalid value!");
								}
							}
						}
						while (keepEdit);
						employeeServiceImpl.updateEmployee(e);
						break;
					}
					//Delete
					case 6:{
						printBorder();
						println("Please type an employee #");
						int empNo = getIntAnswer(input);
						Employee selected = employeeServiceImpl.findEmployeeByNo(empNo);
						if(selected==null) {
							println("Data not found");
							break; 
						}
						employeeServiceImpl.deleteEmployee(selected);
						break;
					}
					case 7:{
						isContinue = false;
						continue;
					}
					default:{
						println("Invalid Option! Please try again");
					}
				}
			}
			catch(InputMismatchException e) {
				println("");
				printBorder();
				println("Program is crashed! Please only type avaluable option");
				println(e);
				LOGGER.log(Level.SEVERE, "type wrong input \"" + input.next() + "\"", e);
			}
			catch(Exception e) {
				printBorder();
				println("Program is crashed! Please try again");
				println(e);
				LOGGER.log(Level.SEVERE, "other error", e);
			}
		}
		while(isContinue);
		input.close();
		printBorder();
		println("Thank you for using the Employee Serveces! Goodbye!");
	}
	
	
	

	
	
	
	/////////////////////////////////////////////////////////////////////
	public static int getIntAnswer( Scanner input) {
		print("Answer: ");
		return input.nextInt();
	}
	public static void println(Object a ) {
		System.out.println(a);
	}
	public static void print(Object i ) {
		System.out.print(i);
	}
	public static void printBorder() {
		println("******************************************************************************************");
	}
	public static void printBorder(int i) {
		for (int j=0; j<i-1; j++) {			
			print("*");
		}
		println("*");
	}
}
