import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			ArrayDeque<Character> ar = new ArrayDeque<>();
			char[] ch = br.readLine().toCharArray();
			
			for (char c : ch) {
				if (c == '(') {
					ar.offer(c);
				} else if (ar.isEmpty()){
					ar.offer(c);
					break;
				} else {
					ar.poll();
				}
			}
			
			if (ar.isEmpty()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}