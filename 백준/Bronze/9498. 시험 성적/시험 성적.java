import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int score = sc.nextInt() / 10;
		
		char result = 'A';
		
		switch (score) {
		case 10:
			result = 'A';
			break;
		case 9:
			result = 'A';
			break;
		case 8:
			result = 'B';
			break;
		case 7:
			result = 'C';
			break;
		case 6:
			result = 'D';
			break;
		default:
			result = 'F';
			break;
		}
		System.out.println(result);
	}
}