import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuffer sb = new StringBuffer();
    	StringTokenizer st;
    	int N = 0, M = 0;
    	while (true) {
    		st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken());
			
			if(N + M == 0) {
				break;
			}
			if(N>M) sb.append("Yes\n");
			else 	sb.append("No\n");
		}
    	System.out.println(sb);
    	br.close();
	}
}