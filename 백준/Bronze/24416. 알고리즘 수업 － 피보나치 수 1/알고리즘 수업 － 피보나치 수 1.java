import java.io.*;
import java.util.*;

public class Main {
	static int cnt1, cnt2;
	static int[] f;
	
	static int fib(int n) {
	    if (n == 1 || n == 2) {
	    	cnt1++;
	    	return 1;  // 코드1
	    }
	    else return (fib(n - 1) + fib(n - 2));
	}
	
	static int fibonacci(int n) {
		
		f[1] = 1;
		f[2] = f[1] + 1;
		
		for (int i = n; i >= 3; i--) {
			cnt2++;
			f[i] = f[i - 1] + f[i - 2];  // 코드2
		}
	    return f[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		f = new int[n+1];
		
		fib(n);
		fibonacci(n);
		
		System.out.println(cnt1 + " " + cnt2);
		br.close();
	}
}