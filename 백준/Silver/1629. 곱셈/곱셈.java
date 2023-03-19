import java.io.*;
import java.util.*;
 
public class Main {
	public static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(logic(A, B));
	}
	
	public static long logic(long A, long exponent) {
		
		if(exponent == 1) {
			return A % C;
		}
		
		long temp = logic(A, exponent / 2);
		
		if(exponent % 2 == 1) {
			return (temp * temp % C) * A % C;
		}
		return temp * temp % C;
	}
}