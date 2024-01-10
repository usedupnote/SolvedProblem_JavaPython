import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
    
	private static void setStar(int x, int y) {
		for (int i = 0; i < y-x; i++) {
			sb.append(" ");
		}
		for (int i = 0; i < (x*2)-1; i++) {
			sb.append("*");
		}
		sb.append("\n");
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			setStar(i, n);
		}
		for (int i = 1; i < n; i++) {
			setStar(n-i, n);
		}
		System.out.println(sb);
    }
}