import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt((br.readLine()));
    	
        for (int i = 0; i < (2*N)-1 ; i++) {
        	for (int j = 0; j < Math.max(N-i-1, i-N+1); j++) sb.append(" ");
			for(int j = 0; j < Math.min((2*N)-i-1, i+1) ; j++) sb.append("*");
			sb.append("\n");
		}
        
        System.out.println(sb);
        br.close();
    }
}