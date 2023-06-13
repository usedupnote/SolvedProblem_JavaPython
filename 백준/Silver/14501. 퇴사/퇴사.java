import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;			
		
		int N = Integer.parseInt(br.readLine());
				
		int[] num = new int[N+6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			num[i+d] = Math.max(num[i+d], num[i] + s);
			for (int j = i+d; j <= N; j++) {
				num[j] = Math.max(num[j-1], num[j]);
			}
		}
		System.out.println(num[N]);
		br.close();
	}
}