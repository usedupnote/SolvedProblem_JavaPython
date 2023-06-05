import java.io.*;
import java.util.*;

public class Main {		    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken())-1;
		int M = Integer.parseInt(st.nextToken())-1;
		    
        System.out.println(Math.abs(N/4 - M/4) + Math.abs(N%4 - M%4));
		br.close();
	}
}
