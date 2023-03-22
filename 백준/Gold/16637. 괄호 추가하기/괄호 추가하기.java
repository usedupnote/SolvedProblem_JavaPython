import java.io.*;
import java.util.*;
 
public class Main {
	static char[] operator = {'+', '-', '*'};
	static int N;
	static long result;
	static char[] ch;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		ch = br.readLine().toCharArray();
		
		result = Long.MIN_VALUE;
		calculation(0, 1, (long)(ch[0] - '0'), 0);
		
		System.out.println(result);
	}

	private static void calculation(int cnt, int start, long now, long mid) {
		
		if(cnt == (N - 1)) {
			result = Math.max(result, now);
			return;
		}
		
		for (int i = cnt + 2; i < cnt + 6; i += 2) {
			if(i >= N) break;
			if(i == cnt + 2) {
				mid = (long)(ch[i] - '0');
			}else if(ch[i-1] == operator[0]) {		// +
				mid += (long)(ch[i] - '0');
			} else if (ch[i-1] == operator[1]) {	// -
				mid -= (long)(ch[i] - '0');
			} else {								// *
				mid *= (long)(ch[i] - '0');
			}
			if(ch[start] == operator[0]) {	// +
				calculation(i, i + 1, now + mid, 0);
			} else if (ch[start] == operator[1]) {	// -
				calculation(i, i + 1, now - mid, 0);
			} else {	// *
				calculation(i, i + 1, now * mid, 0);
			}
		}
	}
}