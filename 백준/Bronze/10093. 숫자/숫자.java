import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
    	long N = Long.parseLong(st.nextToken());
    	long M = Long.parseLong(st.nextToken());
    	
    	if (N > M) {
			long C = N;
			N = M;
			M = C;
		}
    	
    	if(M-N-1 <=0) {
    		sb.append(0).append("\n");
    	} else {
    		sb.append(M-N-1).append("\n");
    		for (long i = N+1; i < M; i++) {
    			sb.append(i).append(" ");
    		}
    	}

        System.out.println(sb);
        br.close();
    }
}