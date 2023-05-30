import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] num = new int[N][10];
		
		for (int i = 0; i < 10; i++) {
			num[0][i] = 1;
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					num[i][k] += num[i-1][j];
				}
				num[i][j] %= 10007;
			}
		}
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += num[N-1][i];
		}
		System.out.print(sum % 10007);
	}
}