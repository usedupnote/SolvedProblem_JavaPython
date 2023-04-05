import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());//게임 횟수 : X
        long Y = Integer.parseInt(st.nextToken());//이긴 게임 : Y (Z%)
        
        if(X==Y) {
        	System.out.println(-1);
        }
        else {
            long Z = 100*Y/X;
            
            long start = 0;
            long end = X*2;
            
            long mid = 0, check = 0;
            
            if((100 * (Y+end) / (X+end)) == Z) {
            	System.out.println(-1);
            }else {
            	while (start + 1 != end) {
            		mid = (start + end)/2;
            		check = 100 * (Y+mid) / (X+mid);
            		if(check == Z) {
            			start = mid;
            		} else {
            			end = mid;
            		}
            	}
            	System.out.println(end);
            }
        }
    }
}