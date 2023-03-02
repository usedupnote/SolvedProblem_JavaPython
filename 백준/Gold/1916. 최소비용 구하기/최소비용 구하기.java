import java.io.*;
import java.util.*;

public class Main {	
	static final long maxV = Long.MAX_VALUE;
	static int N, M, A, B;
	static int[][] path;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 도시의 개수 N(1 ≤ N ≤ 1,000)
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		// 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다.
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		path = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(path[i], Integer.MAX_VALUE);
		}
		
		//버스의 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;	// 버스의 출발 도시의 번호
			int end   = Integer.parseInt(st.nextToken()) - 1;	// 도착지의 도시 번호
			int cost  = Integer.parseInt(st.nextToken());		// 버스 비용 (0 <= 버스 비용 < 100,000)
			
			// 배열
			if(path[start][end] > cost) {
				path[start][end] = cost;
			}
		}
		
		long[] distance = new long[N];
		boolean[] v = new boolean[N];
		
		// A : 출발점의 도시번호 B : 도착점의 도시번호
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken()) - 1;
		B = Integer.parseInt(st.nextToken()) - 1;

		Arrays.fill(distance, maxV);

		distance[A] = 0;

		int current;
		long min;
		
		for (int c = 0; c < N; c++) {
			// step 1 : 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
			current = -1;
			min = maxV;
			
			for (int i = 0; i < N; i++) {
				if(!v[i] && min > distance[i]) {
					min = distance[i];
					current = i;
				}
			}
			
			if(current == -1) break;
			v[current] = true;
			// 선택된 정점이 문제에서 요구하는 도착정점이면 끝내기
			if (current == B)
				;
			
			// step 2 : 위에서 선택된 정점을 경유지로 해서 갈 수 있는 다른 인점 정점과의 비용 최소값 갱신		
			for (int i = 0; i < N; i++) {
				if(path[current][i] != -1 && distance[i] > min + path[current][i]) {
					distance[i] = min + path[current][i];
				}
			}
		}
		// A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력
		System.out.println(distance[B]!=maxV? distance[B]:-1);
	}
}