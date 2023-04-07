import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long[] arr, bit;
	
	static long sum(int i, int j) {
		return sum(j) - sum(i-1);
	}
	
	static long sum(int i) {
		long ans = 0l;
		
		while (i>0) {
			ans += bit[i];
			i-=(i&-i);
		}
		return ans;
	}
	
	static void update(int i, long diff) {
		while (i<=N) {
			bit[i] += diff;
			i+=(i&-i);
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		bit = new long[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Long.parseLong(st.nextToken());
			update(i, arr[i]);
		}
		
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a==1) {
				long c = Long.parseLong(st.nextToken());
				long diff = c-arr[b];
				arr[b] = c;
				update(b, diff);
			}
			else if(a==2) {
				int c = Integer.parseInt(st.nextToken());
				System.out.println(sum(b,c));
			}
		}
	}
}