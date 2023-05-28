import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			String ns = s.toUpperCase();
						
			sb.append(ns.charAt(0)).append(s.substring(1)).append("\n");
		}
		System.out.println(sb);
	}
}