package TestAnualSalary;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import UseEmployee.*;

public class TestAnualSalary {
	Employee employee = new Employee();
	@Test
	public void testCalulateAppriasal() {
		employee.setSalary(15);
		assertEquals(employee.calculateYearlySalary(),31200);

	}
}
