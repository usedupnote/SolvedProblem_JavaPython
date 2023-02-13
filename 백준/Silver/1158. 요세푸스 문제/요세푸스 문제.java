import java.io.*;
import java.util.*;
 
public class Main {
	static int N, K, count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> num = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			num.offer(i);
		}
		
		count = 1;
		sb.append("<");
		while (num.size() != 1) {
			if(count >= K) {
				sb.append(num.poll() + ", ");
				count = 1;
				continue;
			}
			num.offer(num.poll());
			count++;
		}
		sb.append(num.poll() + ">");
		
		System.out.println(sb);
		br.close();
	}
}