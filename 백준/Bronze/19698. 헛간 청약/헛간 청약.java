import java.io.*;
import java.util.*;

public class Main {		    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
        W /= L;
        H /= L;
        
        System.out.println(Math.min(W * H, N));
		br.close();
	}
}
