import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		boolean[] num = new boolean[2000003];
		int max = 0;
		int min = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) + 1000000;
			num[a] = true;
			max = Math.max(max, a);
			min = Math.min(min, a);
		}
		
		
		for (int i = min; i <= max; i++) {
			if(num[i]) sb.append(i - 1000000 + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}