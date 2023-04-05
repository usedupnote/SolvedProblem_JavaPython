import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {0,1,0,-1};	//우하좌상
	static final int[] dirY = {1,0,-1,0};
	static final int INF = 999_999_999;
	
	static int N, M, cnt=1;
	static int[][] map, bridge;
	static int[] v;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());	//1 ≤ N, M ≤ 10
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				//0은 바다, 1은 땅을 의미한다.
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) map[i][j] = 7;
			}
		}
        
        searchLand();
        
        bridge = new int[cnt][cnt];
        
        for (int i = 0; i < cnt; i++) {
			Arrays.fill(bridge[i], INF);
		}
        
        checkBridge();
        
        
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
        
        for (int i = 1; i < cnt; i++) {
        	for (int j = 1; j < cnt; j++) {
        		if(bridge[i][j] == INF) continue;
        		q.offer(new int[] {i,j,bridge[i][j]});
        	}
		}

        
		//다리는 바다에만 건설할 수 있고, 다리의 길이는 다리가 격자에서 차지하는 칸의 수이다.
        //다리를 연결해서 모든 섬을 연결하려고 한다. 섬 A에서 다리를 통해 섬 B로 갈 수 있을 때, 섬 A와 B를 연결되었다고 한다. 다리의 양 끝은 섬과 인접한 바다 위에 있어야 하고, 한 다리의 방향이 중간에 바뀌면 안된다. 또, 다리의 길이는 2 이상이어야 한다.
		//다리의 방향이 중간에 바뀌면 안되기 때문에, 다리의 방향은 가로 또는 세로가 될 수 밖에 없다. 방향이 가로인 다리는 다리의 양 끝이 가로 방향으로 섬과 인접해야 하고, 방향이 세로인 다리는 다리의 양 끝이 세로 방향으로 섬과 인접해야 한다.
		//섬 A와 B를 연결하는 다리가 중간에 섬 C와 인접한 바다를 지나가는 경우에 섬 C는 A, B와 연결되어있는 것이 아니다. 
		//아래 그림은 섬을 모두 연결하는 올바른 2가지 방법이고, 다리는 회색으로 색칠되어 있다.
        //섬은 정수, 다리는 알파벳 대문자로 구분했다.
		
        //출력
		//모든 섬을 연결하는 다리 길이의 최솟값을 출력한다. 모든 섬을 연결하는 것이 불가능하면 -1을 출력한다.
        v = new int[cnt];
        
        for (int i = 1; i < cnt; i++) {
			v[i] = i;
		}
        
        int result = 0;
        int check = cnt;
        
        while (!q.isEmpty()) {
        	if(check == 0) break;
        	
        	int[] poll = q.poll();

        	if (union(poll[0], poll[1])) {
				result += poll[2];
				check--;
			}
		}
        
        for (int i = 1; i < cnt; i++) {
        	v[i] = findSet(i);
        	if(v[i] != v[1]) {
        		result = 0;
        		break;
        	}
		}
        System.out.println(result==0?-1:result);
    }

	private static int findSet(int a) {
		if (v[a] == a) return a;
		v[a] = findSet(v[a]);
		return v[a];
	}
	
	static boolean union (int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		v[bRoot] = aRoot;
		return true;
	}

	private static void checkBridge() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue;
				makeBridge(i, j, map[i][j]);
			}
		}
	}

	private static void makeBridge(int x, int y, int from) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		int dx, dy;

		for (int d = 0; d < 2; d++) {
			dx = x + dirX[d];
			dy = y + dirY[d];
			
			if(0<=dx && dx<N && 0<=dy && dy<M && map[dx][dy] == 0) {
				q.offer(new int[] {dx,dy,1,d});
			}
		}
		

		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			dx = poll[0] + dirX[poll[3]];
			dy = poll[1] + dirY[poll[3]];
			
			if(0<=dx && dx<N && 0<=dy && dy<M && map[dx][dy] != from) {
				if(map[dx][dy] != 0) {
					if(poll[2] < 2) continue;
					if(bridge[from][map[dx][dy]] > poll[2]) {
						bridge[from][map[dx][dy]] = poll[2];
						bridge[map[dx][dy]][from] = poll[2];
					}
					continue;
				}
				q.offer(new int[] {dx, dy, poll[2]+1, poll[3]});
			}
		}
	}

	private static void searchLand() {
		// 땅 분류하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 7) continue;
				makeColorMap(i, j);
				cnt++;
			}
		}
	}

	private static void makeColorMap(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x,y});

		map[x][y] = cnt;
		
		int dx, dy;
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int d = 0; d < 4; d++) {
				dx = poll[0] + dirX[d];
				dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<M && map[dx][dy] == 7) {
					map[dx][dy] = cnt;
					q.offer(new int[] {dx, dy});
				}
			}
		}
	}
}