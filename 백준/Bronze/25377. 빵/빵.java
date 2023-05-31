import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int result = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            if(A <= B) {
        		result = Math.min(result, B);
            }
		}
        System.out.println(result == Integer.MAX_VALUE ? -1:result);
    }
}