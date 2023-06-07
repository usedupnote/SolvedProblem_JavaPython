import java.io.*;
import java.util.*;

public class Main {		    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for (int TC = 0 ; TC < T ; TC++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            
            int result = 0;
            
            for (int i = 0 ; i < N ; i++) {            
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int f = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                
                if (D <= v * f / c) result++;
            }
            sb.append(result).append("\n");
        }
        
        System.out.print(sb);
        br.close();
	}
}
