import java.io.*;
import java.util.*;
 
public class Main {
	static long N;
	static long result;
	static int[] num;
	static char[] ch;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		ch = br.readLine().toCharArray();
		
		for (int i = 0; i < N; i++) {
			result += (Character.valueOf(ch[i])-'a' + 1) * Math.pow(31, i);
			result %= 1234567891;
		}
		
		System.out.println(result);
		br.close();
	}
}