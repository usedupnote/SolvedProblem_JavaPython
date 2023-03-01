import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    M = Math.min(M, N - M);
	    
	    BigDecimal result = BigDecimal.valueOf(1);
	    
	    int now = 0;
	    while (true) {
	    	if(M == now) break;
			result = result.multiply(BigDecimal.valueOf(N--));
			result = result.divide(BigDecimal.valueOf(++now));
		}
	    
	    System.out.println(result);
	    br.close();
	}
}