import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Queue<Integer> num = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			num.add(i + 1);
		}
		
		for (int i = 0; i < N - 1; i++) {
			num.poll();
			num.add(num.poll());
		}
		
		System.out.println(num.poll());
		br.close();
	}
}
