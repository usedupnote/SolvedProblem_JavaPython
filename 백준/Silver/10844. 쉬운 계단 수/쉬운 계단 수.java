import java.io.*;
import java.util.*;

public class Main {
	static int[] dir = {1, -1};
	static int N, result;
	static int[][] Eggs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
        
		int[][] num = new int[N][10];
		Arrays.fill(num[0], 1);
		num[0][0] = 0;
		
		int check = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int d = 0; d < 2; d++) {
					check = j + dir[d];
					if(0<=check && check < 10) {
						num[i][j] += num[i-1][check];
					}
					num[i][j] %= 1_000_000_000;
				}
			}
		}
		result = 0;
		
		for (int i = 0; i < 10; i++) {
			result = (result + num[N-1][i]) % 1_000_000_000;
		}
		System.out.println(result);
		br.close();
	}
}