import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static int[] dirX = {-1,1,0,0};
	static int[] dirY = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int TC = Integer.parseInt(st.nextToken());
        
        for (int test_case = 1; test_case <= TC; test_case++) {
        	st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
	        
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
            	char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                	map[i][j] = ch[j] - '0';
				}
			}
            System.out.println("#" + test_case + " " + dijkstra());
		}
	}

	static int dijkstra() {
		final int INF = Integer.MAX_VALUE;
		int[][] minTime = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		}); // r,c,출발지에서 자신까지 최소비용
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}
		
		minTime[0][0] = 0;
		pq.offer(new int[] {0,0,minTime[0][0]});
		
		int[] cur = null;
		int r, c, minCost;
		
		while (true) {
			//step 1
			cur = pq.poll();
			r = cur[0];
			c = cur[1];
			minCost = cur[2];
			
			if(visited[r][c]) continue;
			visited[r][c] = true;
			if(r == N-1 && c == N-1) return minCost;
			
			//step 2
			int nr = 0, nc = 0;
			for (int d = 0; d < 4; d++) {
				nr = r + dirX[d];
				nc = c + dirY[d];
				
				if(0<=nr && nr<N && 0<=nc && nc<N && !visited[nr][nc] && minTime[nr][nc] > minCost+ map[nr][nc]){
					minTime[nr][nc] = minCost + map[nr][nc];
					pq.offer(new int[] {nr, nc, minTime[nr][nc]});
				}
			}
		}
	}
}
