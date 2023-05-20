import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		
		for (int TC = 0; TC < N; TC++) {
			int Y = 0, K = 0;
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				Y += Integer.parseInt(st.nextToken());
				K += Integer.parseInt(st.nextToken());
			}
			sb.append(Y>K?"Yonsei":(Y<K?"Korea":"Draw")).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}