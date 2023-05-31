import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int result = 100001;
        int A,B;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            if(A <= B) {
        		result = Math.min(result, B);
            }
		}
        System.out.print(result == Integer.MAX_VALUE ? -1:result);
    }
}