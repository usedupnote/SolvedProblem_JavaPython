import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] day = new int[N + 1];
		
		int T = sc.nextInt();
		int P = sc.nextInt();
		
		if (T <= N) {
			day[T] = P;
		}
		
		for (int i = 1; i < N; i++) {
			T = sc.nextInt();
			P = sc.nextInt();

			day[i] = Math.max(day[i-1], day[i]);
			
			if (i + T <= N) {
				day[i+T] = Math.max(day[i] + P, day[i+T]);
			}
		}
		day[N] = Math.max(day[N-1], day[N]);
		
		System.out.println(day[N]);
	}
}