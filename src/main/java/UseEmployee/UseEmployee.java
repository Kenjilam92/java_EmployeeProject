package UseEmployee;
import java.util.*;
import java.util.stream.Collectors;

public class UseEmployee {
	public static void main (String[] args) {
		Object[][] employees = {
				{"Kenji", 12.45, "Centreville", "Virginia"},
				{"Alex", 8.45, "Fairfax", "Virginia"},
				{"John", 11.32, "Dallas","Texas   "},
				{"James",9.5,"Chicago","Illinois "}
		};
//		ArrayList<Employee> data = new ArrayList<Employee>();
		for(Object[] emp : employees) {
			new Employee((String) emp[0], (double) emp[1], (String) emp[2], (String) emp[3] );
		}
		
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
				println("4. Update an employee");
				println("5. Delete an employee");
				println("6. Recycle bin");
				println("7. Quit");
				int service = getIntAnswer(input);
				switch(service) {
					case 1:{
						printBorder();
						Employee.displayAll();
						break;
					}
					case 2:{
						printBorder();
						println("Please type an employee #");
						int empNo = getIntAnswer(input);
						Employee result = Employee.findByEmployeeNo(empNo);
						if (result == null) {
							println("NO RESULT WAS FOUND");
						}
						else {
							System.out.println("|\tNo.\t|\tName\t|\tSallery\t\t|\tAddress");
							result.showInfo();
						}
						continue;
					}
					case 3:{
						printBorder();
						Employee selected = selectEmployee(input);
						println(selected.getName()+"'s anual salary: " + selected.calculateYearlySalary() );
						break;
					}
					case 4:{
						printBorder();
						Employee selected = selectEmployee(input);
						selected.updateEmployee(input);
						break;
					}
					case 5:{
						printBorder();
						Employee selected = selectEmployee(input);
						selected.delete();
						break;
					}
					case 6:{
						printBorder();
						println("Here is the list of deleted employee");
						printBorder();
						Employee.showRecycleBin();
						printBorder();
						println("What do you want to do?");
						println("1. Restore | 2. Delete permanently | 3. Back");
						boolean isStay = true;
						do {
							switch (getIntAnswer(input)) {
								case 1:{
									Employee selected = selectDeletedEmployee(input);
									selected.restore();
									isStay=false;
									break;
								}
								case 2:{
									Employee selected = selectDeletedEmployee(input);
									Employee.permanentDelete(selected);
									isStay=false;
									break;
								}
								case 3:{
									isStay=false;
									break;
								}
								default:{
									println("Invalid input! Please try again");
								}
							}
						}while(isStay);
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
				println("Program is crashed! Please only type avaluable option");
				println(e);
				input.next();
			}
			catch(Exception e) {
				println("Program is crashed! Please try again");
				println(e);
			}
		}
		while(isContinue);
		input.close();
		printBorder();
		println("Thank you for using the Employee Serveces! Goodbye!");
	}
	
	
	public static Employee selectEmployee(Scanner input) {
		Employee selected = null;
		do {
			println("Please select an employee by employee number");
			selected = Employee.findByEmployeeNo(getIntAnswer(input));
			if( selected == null ) {
				println("NO RESULT WAS FOUND");
				continue;
			}
		}
		while(selected == null);
		return selected;
	}
	
	public static Employee selectDeletedEmployee(Scanner input) {
		Employee selected = null;
		do {
			println("Please select an employee by employee number");
			selected = Employee.selectAnDeletedEmployee(getIntAnswer(input));
			if( selected == null ) {
				println("NO RESULT WAS FOUND");
				continue;
			}
		}
		while(selected == null);
		return selected;
	}

	
	
	
	////
	public static int getIntAnswer( Scanner input) {
//		printBorder();
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
