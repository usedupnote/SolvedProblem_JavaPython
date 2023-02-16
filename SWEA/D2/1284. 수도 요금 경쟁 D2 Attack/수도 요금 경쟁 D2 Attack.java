import java.io.*;
import java.util.*;
 
public class Solution {
    static StringBuilder sb = new StringBuilder();
	static int T, P, Q, R, S, W, result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        T = Integer.parseInt(st.nextToken());
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            
            result = Math.min(W * P, Q + (W - R <= 0 ? 0 : (W - R) * S));
            
            sb.append("#" + test_case + " " + result + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}