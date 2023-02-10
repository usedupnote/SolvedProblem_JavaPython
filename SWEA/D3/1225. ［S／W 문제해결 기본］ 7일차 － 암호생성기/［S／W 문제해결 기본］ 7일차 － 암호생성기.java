import java.io.*;
import java.util.*;
 
public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<Integer> password;
		
		int N;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			password = new ArrayDeque<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
				
			N = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 8; i++) {
				password.offer(Integer.parseInt(st.nextToken()));
			}
			
			label : while (true) {
				for (int i = 1; i <= 5; i++) {
					password.offer(password.poll() - i);
					if (password.getLast() <= 0) {
						password.pollLast();
						password.offer(0);
						break label;
					}
				}
			}
			
			sb.append("#"+ N + " " + password.toString().replace("[", "").replace(",", "").replace("]", "") + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}