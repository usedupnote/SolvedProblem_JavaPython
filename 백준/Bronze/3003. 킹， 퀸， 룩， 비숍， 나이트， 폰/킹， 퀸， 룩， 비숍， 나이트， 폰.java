import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] num = {1,1,2,2,2,8};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 6; i++) {
			N = Integer.parseInt(st.nextToken());
			sb.append(num[i] - N + " ");
		}
		
		System.out.println(sb);
		br.close();
	}
}