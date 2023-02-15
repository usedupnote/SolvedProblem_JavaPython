import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> person = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			person.offer(i);
		}
		
		int count = 0;
		
		sb.append("<");
		
		while (person.size() != 1) {
			count = (count+1) % M;
			if(count == 0) {
				sb.append(person.poll() + ", ");
			}else {
				person.offer(person.poll());
			}
		}
		sb.append(person.poll() + ">");
		
		System.out.println(sb);
		br.close();
	}
}