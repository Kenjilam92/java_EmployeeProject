package UseEmployee;
import java.util.*;

public class Address {
	private String city;
	private String state;
	
	public Address (String c, String s) {
		city = c;
		state = s;
	}
	
	public String getCity () {
		return city;
	}
	public String getState() {
		return state;
	}
	public Address setCity(String c) {
		city =c;
		return this;
	}
	public Address setState(String s) {
		state =s;
		return this;
	}
	public String toString () {
		return city + ", " + state ;
	}
}
