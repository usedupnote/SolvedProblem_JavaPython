import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long result = N;
		int[] numOfClass = new int[N];
		
		for (int i = 0; i < N; i++) {
			numOfClass[i] = sc.nextInt();
		}
		
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		for (int i : numOfClass) {
            i -= B;
            
			if (i < 0) {
				i = 0;
			}else {
				result += (i / C) + ((i % C) == 0 ? 0 : 1);
			}
		}
		System.out.println(result);
	}
}