import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		char[] ch = br.readLine().toCharArray();
		
		while (ch[0] != '.' && ch.length != 1) {
			ArrayDeque<Character> q = new ArrayDeque<>();
			
			boolean check = true;
			
			label: for (char c : ch) {
				if (c == '(' || c =='[') {
					q.offer(c);
				} else {
					if (c == ']') {
						if (q.size() == 0 || q.peekLast() != '[') {

							check = false;
							break label;
						}
						q.pollLast();
					}
					if(c == ')') {
						if (q.size() == 0 || q.peekLast() != '(') {

							check = false;
							break label;
						}
						q.pollLast();
					}
				}
			}
			sb.append(((check && q.size() == 0)?"yes":"no") + "\n");
			ch = br.readLine().toCharArray();
		}
		System.out.println(sb);
		br.close();
	}
}