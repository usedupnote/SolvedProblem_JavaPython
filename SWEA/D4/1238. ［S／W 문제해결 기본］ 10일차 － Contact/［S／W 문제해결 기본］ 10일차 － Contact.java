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

			//bfs1(M);
			bfs2(M, 1);
			
			sb.append("#" + test_case+ " " + result + "\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void bfs1(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		int[] visited = new int[101];
		
		queue.offer(start);
		visited[start] = 1;
		
		int current = 0;
		
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println(current);
			
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
			}
		}
	}
	
	static void bfs2(int start, int cnt) {

		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[] visited = new boolean[101];
		
		queue.offer(new int[] {start, cnt});
		visited[start] = true;
		
		int[] current;
		
		while (!queue.isEmpty()) {
			current = queue.poll();
			
			if (count < current[1]) {
				result = current[0];
				count = current[1];
			}
			else if(count == current[1]) {
				result = Math.max(result, current[0]);
			}
			
			for (int vertex : arrlist[current[0]]) {
				if(visited[vertex]) continue;

				visited[vertex] = true;
				queue.offer(new int[] {vertex, current[1] + 1});
			}
		}
	}
}