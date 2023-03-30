import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1,1,0,0};	//상하좌우
	static int[] dirY = {0,0,-1,1};
	static int N, M;
	static int area, safeArea;
	static int[][] map;
	static LinkedList<int[]> virus;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());	//지도의 세로 크기 N (3 ≤ N, M ≤ 8)
    	M = Integer.parseInt(st.nextToken());	//지도의 가로 크기 M
    	
    	virus = new LinkedList<>();
    	map = new int[N][M];
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());

    		// 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치
    		// 2 <= 바이러스의 수 <= 10
    		// 3 <= safeArea(빈칸의 수)
    		for (int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] == 0) area++;
    			else if(map[i][j] == 2) virus.offer(new int[] {i,j});
			}
		}
    	
    	area -= 3;
    	safeArea = 0;
    	setWall(0,0,3);

		//얻을 수 있는 안전 영역의 최대 크기
    	System.out.println(safeArea);
    	br.close();
    }

    //새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
	private static void setWall(int x, int y, int cnt) {
		if(cnt == 0) {
			getSpace();
			return;
		}
		
		for (int i = x; i < N; i++) {
			if(i==x) {
				for (int j = y; j < M; j++) {
					if(map[i][j] == 0) {
						map[i][j] = 9;
						setWall(i, j, cnt-1);
						map[i][j] = 0;
					}
				}
			} else {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0) {
						map[i][j] = 9;
						setWall(i, j, cnt-1);
						map[i][j] = 0;
					}
				}
			}
		}
	}

	private static void getSpace() {
		// 전체의 빈 공간에서 각 바이러스 bfs한 공간을 빼야할 듯
		//바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다.
		int[][] compareMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			compareMap[i] = map[i].clone();
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		for (int i = 0; i < virus.size(); i++) {
			q.offer(virus.get(i));
		}
		
		int checkArea = area;
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<M && compareMap[dx][dy] == 0) {
					checkArea--;
					compareMap[dx][dy] = 2;
					q.offer(new int[] {dx,dy});
				}
			}
		}
		safeArea = Math.max(safeArea, checkArea);
	}
}