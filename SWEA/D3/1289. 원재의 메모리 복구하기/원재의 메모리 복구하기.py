import java.io.*;
import java.util.*;

public class Solution {
	static int T;
    static int result;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        T = Integer.parseInt(st.nextToken());
         
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            
            String S = st.nextToken();
            
            result = S.charAt(0) == '0' ? 0:1;
            
            for (int i = 1; i < S.length(); i++) {
            	result += S.charAt(i) == S.charAt(i-1) ? 0:1;
			}
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}
