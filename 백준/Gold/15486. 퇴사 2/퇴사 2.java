import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] day = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		if (T <= N) day[T] = P;
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());

			day[i] = Math.max(day[i-1], day[i]);
			
			if (i + T <= N) {
				day[i+T] = Math.max(day[i] + P, day[i+T]);
			}
		}
		day[N] = Math.max(day[N-1], day[N]);
		
		System.out.println(day[N]);
		br.close();
	}
}