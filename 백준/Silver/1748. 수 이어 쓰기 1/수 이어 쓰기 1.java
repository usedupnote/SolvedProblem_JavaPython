import java.io.*;
import java.util.*;

public class Main {
	static boolean[] button;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long result = 0;
		int len = Integer.toString(N).length();
		
		for (int i = 1; i < len; i++) {
			result += i * (Math.pow(10, i) - Math.pow(10, i-1));
		}
		result += len * (N - Math.pow(10, len-1)+1);
		System.out.println(result);
        br.close();
	}
}