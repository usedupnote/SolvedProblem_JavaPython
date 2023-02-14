import java.io.*;
import java.util.*;
 
public class Main {
	static int N;
	static int[] num;
	static ArrayDeque<int[]> maxPoint = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		
		maxPoint.offer(new int [] {100000000, 0});
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			
			while (!maxPoint.isEmpty()) {
				if (num[i] > maxPoint.getFirst()[0]) {
					maxPoint.poll();
				} else {
					sb.append((maxPoint.getFirst()[1]) + " ");
					maxPoint.push(new int [] {num[i],i + 1});
					break;
				}
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
}