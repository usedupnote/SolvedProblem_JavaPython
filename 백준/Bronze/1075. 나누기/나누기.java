import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	
    	N = N - (N % 100);
    	
    	if(N % M != 0) {
    		int check = M - (N % M);
    		sb.append(check < 10 ? "0" + check:check);
    	} else {
    		sb.append("00");
    	}
    	System.out.println(sb);
    	br.close();
	}
}