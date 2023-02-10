import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Queue<Integer> num = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			num.offer(i + 1);
		}
		
		for (int i = 0; i < N - 1; i++) {
			num.poll();
			num.offer(num.poll());
		}
		
		System.out.println(num.poll());
		br.close();
	}
}