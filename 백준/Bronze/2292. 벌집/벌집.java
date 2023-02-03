import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		result = 1;
		
		N -= result;
		
		while (N > 0) {
			N -= result * 6;
			result += 1;
		}
		
		System.out.println(result);
	}
}