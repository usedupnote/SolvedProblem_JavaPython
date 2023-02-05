import java.util.*;

public class Main {
	
	public static int calculation(int A, int B) {
		int reusult = (A+B) * (A-B);
		
		return reusult;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(calculation(A,B));
	}
}