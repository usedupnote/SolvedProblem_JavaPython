import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] num = new int[N][M];
		
		for (int count = 0; count < 2; count++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					num[i][j] += sc.nextInt();
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(num[i]).replace(",", "").replace("[", "").replace("]", ""));
		}
		sc.close();
	}
}