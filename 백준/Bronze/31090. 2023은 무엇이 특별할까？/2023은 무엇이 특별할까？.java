import java.io.*;
import java.util.*;

public class Main {	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int year = Integer.parseInt(st.nextToken());	
			sb.append((year+1) % (year%100) == 0 ? "Good" : "Bye").append("\n");
		}
    	System.out.println(sb);
    }
}