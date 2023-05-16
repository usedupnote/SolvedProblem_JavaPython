import java.io.*;
import java.util.*;

public class Main {	
	static final int[] dirX = {-1,1,0,0};	//상하좌우
	static final int[] dirY = {0,0,-1,1};
	static int M, N, K;
	static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// M, N, K는 모두 100 이하의 자연수
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[M][N];
		
		//입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.
		for (int c = 0; c < K; c++) {
			st = new StringTokenizer(br.readLine());	
			int x1 = Integer.parseInt(st.nextToken());	//왼쪽 아래 꼭짓점의 x1, y1좌표값
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());	//오른쪽 위 꼭짓점의 x2, y2좌표값
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					map[i][j] = true;
				}
			}
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]) continue;
				q.offer(bfs(i, j, 1));
			}
		}
		
		//첫째 줄에 분리되어 나누어지는 영역의 개수
		sb.append(q.size()).append("\n");

		//둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력
		while (!q.isEmpty()) {
			sb.append(q.poll()).append(" ");
		}
		
		System.out.println(sb);
		br.close();
    }
	
	private static Integer bfs(int x, int y, int cnt) {
		ArrayDeque<int[]> check = new ArrayDeque<>();
		check.offer(new int[] {x,y});

		int dx,dy;
		map[x][y] = true;
		
		while (!check.isEmpty()) {
			int[] poll = check.poll();
			
			for (int d = 0; d < 4; d++) {
				dx = poll[0] + dirX[d];
				dy = poll[1] + dirY[d];
				
				if (0<=dx && dx<M && 0<=dy && dy<N && !map[dx][dy]) {
					map[dx][dy] = true;
					cnt++;
					check.offer(new int[] {dx,dy});
				}
			}
		}
		return cnt;
	}
}