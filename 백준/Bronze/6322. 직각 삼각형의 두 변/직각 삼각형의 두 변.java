import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;

    	int cnt = 0;
    	while (true) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	int c = Integer.parseInt(st.nextToken());
	    	
	    	if (a+b+c == 0) break;

	    	sb.append("Triangle #").append(++cnt).append("\n");
	    	
	    	if (c != -1) {
	    		if (c <= a+b+1) sb.append("Impossible.");
	    		else if (a == -1) {
	    			sb.append("a = ").append(String.format("%.3f", Math.sqrt(c*c-b*b)));
	        	} else {
	    			sb.append("b = ").append(String.format("%.3f", Math.sqrt(c*c-a*a)));
	        	}
	    	} else {
    			sb.append("c = ").append(String.format("%.3f", Math.sqrt(a*a+b*b)));
	    	}
    		sb.append("\n").append("\n");
		}
    	System.out.println(sb);
    }
}