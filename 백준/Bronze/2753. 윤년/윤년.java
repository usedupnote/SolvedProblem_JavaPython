import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long year = sc.nextLong();

		if (year % 400 == 0) System.out.println(1);
		else if (year % 100 == 0) System.out.println(0);
		else if (year % 4 == 0) System.out.println(1);
		else System.out.println(0);
	}
}