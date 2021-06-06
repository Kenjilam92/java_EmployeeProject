package tools;

public interface Print {
	public default void print(Object content) {
		System.out.print(content);
	}
	public default void println(Object content) {
		System.out.println(content);
	}
	public default void printBorder(int i) {
		for( int j = 0 ; j< i-1; j++ ) {			
			print("*");
		}
		println("*");
	}
	public default void printBorder() {
		println("*********************************************************************");
	}
}
