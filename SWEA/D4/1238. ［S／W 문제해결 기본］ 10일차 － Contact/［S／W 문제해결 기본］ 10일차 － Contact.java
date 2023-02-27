import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, count, result;
	static int[] group;
	static boolean[] v;
	static ArrayList<Integer>[] arrlist;
	
	public static void main(String[] args) throws IOException {
		// 초기 설정 부분
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb   = new StringBuilder();
		StringTokenizer st;	

		for (int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// size로 묶어서 루프
			arrlist = new ArrayList[101];
			
			// 이거 안하면 nullPoint 떨어짐
			for (int i = 0; i <= 100; i++) {
				arrlist[i] = new ArrayList<Integer>();
			}
			
			int from, to;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				// 무향 그래프
				arrlist[from].add(to);
			}
			
			count = 0;
			result = 0;

			bfs(M);
			
			sb.append("#" + test_case+ " " + result + "\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		int[] visited = new int[101];
		
		queue.offer(start);
		visited[start] = 1;
		
		int current = 0;
		
		while (!queue.isEmpty()) {
			current = queue.poll();
			
			for (int vertex : arrlist[current]) {
				if(visited[vertex] == 0) {
					visited[vertex] = visited[current] + 1;
					queue.offer(vertex);
				}
			}
			
			if (count < visited[current]) {
				result = current;
				count = visited[current];
			}
			else if(count == visited[current]) {
				result = Math.max(result, current);
				count = visited[current];
			}
		}
	}
}