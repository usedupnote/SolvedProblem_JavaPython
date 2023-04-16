import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {-1,1,0,0};	//상 하 좌 우
	static final int[] dirY = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N, M;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if (N == 0) break;
			
			int[] num = new int[N];
			num[0] = Integer.parseInt(st.nextToken());
			
			sb.append(num[0] + " ");
			
			for (int i = 1; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				if (num[i-1] == num[i]) continue;
				sb.append(num[i] + " ");
			}
			sb.append("$\n");
		}
		System.out.println(sb);
	}
}