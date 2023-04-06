import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int P = 1_000_000_007;
	    
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int R = Integer.parseInt(st.nextToken());
	    
    	R = Math.min(N-R, R);
    	
	    System.out.println(nCr(N,R,P));
	    br.close();
	}

	private static long nCr(int n, int r, int p) {
		if(r==0) return 1L;
		
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i-1] * i % p;
		}
	
		return(fac[n] * power(fac[n-r], p-2, p)%p * power(fac[r], p-2, p)%p)%p;
	}

	private static long power(long x, long y, long p) {
		long res = 1L;
		
		x = x % p;
		
		while (y > 0){
			if(y % 2 == 1) {
				res = (res * x) % p;
			}
			y = y >> 1;
	    	x = (x * x) %p;
		}
		return res;
	}
}