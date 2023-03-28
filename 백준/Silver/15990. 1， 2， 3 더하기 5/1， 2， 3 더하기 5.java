import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		int[] num = new int[T];
		
		int max = 0;
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken())-1;
			
			if(max < num[i]) {
				max = num[i];
			}
		}
		
		long[][] result = new long[max+1][3];
		
		result[0] = new long[] {1,0,0};
		result[1] = new long[] {0,1,0};
		result[2] = new long[] {1,1,1};
		
		for (int i = 3; i <= max; i++) {
			result[i][0] = (result[i-1][1] + result[i-1][2])%1000000009;
			result[i][1] = (result[i-2][0] + result[i-2][2])%1000000009;
			result[i][2] = (result[i-3][0] + result[i-3][1])%1000000009;
		}
		
		
		for (int i = 0; i < T; i++) {
			sb.append((result[num[i]][0] + result[num[i]][1] + result[num[i]][2])%1000000009 + "\n");
		}

		System.out.println(sb);
		br.close();
	}
}