import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int compare = 1;
		int count = 1;
		
		int result = 0;
		
		if (N == 1) {
			result = 1;
		} else {
			N--;
			while (N > compare) {
				N -= compare;
				
				count++;
				compare *= 2;
			}
			result = N * 2;
		}
		
		System.out.println(result);
	}
}
