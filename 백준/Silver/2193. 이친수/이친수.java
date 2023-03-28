import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		long[] num = new long[T+1];
		
		num[0] = 1;
		num[1] = 1;
		
		for (int i = 2; i < T; i++) {
				num[i] = num[i-1] + num[i-2];
		}
		System.out.println(num[T-1]);
		br.close();
	}
}