import java.io.*;
import java.util.*;

public class Main {	
	static int N, M;
	static int[] num, b;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		b = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		comb(0, 0);
		
		System.out.println(sb);
		br.close();
	}
	private static void comb(int cnt, int start) {
		if(cnt == M) {
			sb.append(Arrays.toString(b).replace("[", "").replace(",", "").replace("]", "") + "\n");
			return;
		}
		for (int i = start; i < N; i++) {
			b[cnt] = num[i];
			comb(cnt+1, i);
		}
	}
}