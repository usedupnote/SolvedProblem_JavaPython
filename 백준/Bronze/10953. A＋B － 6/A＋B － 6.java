import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int A, B;
		for (int i = 0; i < N; i++) {
			String[] S = br.readLine().split(",");
			A = Integer.parseInt(S[0]);
			B = Integer.parseInt(S[1]);
			sb.append(A+B+"\n");
		}
		System.out.println(sb);
	}
}