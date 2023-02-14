import java.io.*;
import java.util.*;
 
public class Main {
	static long N, M;
	static long result;
	static char[] ch;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		ch = br.readLine().toCharArray();
		
        M = 1;
		for (int i = 0; i < N; i++) {
			result += ((Character.valueOf(ch[i])-'a' + 1) * M) % 1234567891;
			M = (M * 31) % 1234567891;
		}
		System.out.println(result %= 1234567891);
		br.close();
	}
}