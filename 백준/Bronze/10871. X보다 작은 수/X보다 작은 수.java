import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int X = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int compare = sc.nextInt();
			
			if (X > compare) {
				System.out.print(compare + " ");
			}
		}
		sc.close();
	}
}