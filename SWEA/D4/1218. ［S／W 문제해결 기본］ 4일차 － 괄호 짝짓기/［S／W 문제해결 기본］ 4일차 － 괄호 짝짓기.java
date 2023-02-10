import java.io.*;
import java.util.*;
 
public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<Character> barcket = new ArrayDeque<>();
		
		int N;
		char[] ch;
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		map.put('<', '>');
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			barcket = new ArrayDeque<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			ch = br.readLine().toCharArray();
			
			for (char c : ch) {
				if (map.containsKey(c)) {
					barcket.offer(map.get(c));
				}else if (barcket.size() != 0 && barcket.getLast() == c) {
					barcket.pollLast();
				} else {
					barcket.offer(c);
					break;
				}
			}
			
			sb.append("#"+ test_case + " " +(barcket.size() == 0 ? 1 : 0) + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}