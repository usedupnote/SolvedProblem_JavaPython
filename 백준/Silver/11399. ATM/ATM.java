import java.io.*;
import java.util.*;

public class Main {
	static int N, K, result;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = N; i > 0; i--) {
			result += i * q.poll();
		}
		System.out.println(result);
	}
}