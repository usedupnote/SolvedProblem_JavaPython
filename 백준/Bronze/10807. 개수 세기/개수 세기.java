import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) num[i] = sc.nextInt();
		
		int checker = sc.nextInt();
		int counter = 0;
		
		for (int i = 0; i < N; i++) {
			if (checker == num[i]) counter += 1;
		}
		
		System.out.println(counter);
		sc.close();
	}
}