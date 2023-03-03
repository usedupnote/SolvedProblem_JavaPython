import java.io.*;
import java.util.*;

public class Main {		
	static class Creature {
		int x, y;
		int weight;
		int cnt;
		
		public Creature(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}
	
	static int N, result;
	static final int[] dirX = {-1, 0, 0, 1}; // 상 좌 우 하
	static final int[] dirY = {0, -1, 1, 0};

	static Creature shark;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		//공간의 크기 N(2 ≤ N ≤ 20)
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 행의 수
		
		//둘째 줄부터 N개의 줄에 공간의 상태가 주어진다.
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				//0: 빈 칸
				//1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9) {
					//9: 아기 상어의 위치
					map[i][j] = 0;
					shark = new Creature(i, j, 2);
				}
			}
		}
		
		result = 0;
		
		while (bfs(shark.x, shark.y, shark.weight)) {
			if(shark.cnt == shark.weight) {
				//아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가
				shark.cnt = 0;
				shark.weight++;
			}
		}
		//첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력
		System.out.println(result);
		br.close();
	}

	static boolean bfs(int x, int y, int weight) {
		
		PriorityQueue<int[]> pos = new PriorityQueue<>(new Comparator<int[]>() {

            //먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
            //먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] == o2[2]) {
					if(o1[0] == o2[0]) {
                        //가장 위에 있는 물고기가 여러마리 -> 가장 왼쪽에 있는 물고기
						return Integer.compare(o1[1], o2[1]);
					} else {
                        // 거리가 가까운 물고기가 여러마리 -> 가장 위에 있는 물고기
						return Integer.compare(o1[0], o2[0]);
					}
				} else {
					return Integer.compare(o1[2], o2[2]);
				}
			}
		});
		
		boolean[][] v = new boolean[N][N];
		
		pos.offer(new int[] {x, y, 0});
		
		while (!pos.isEmpty()) {
            //아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
			int[] poll = pos.poll();

    		//아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.			
			if(map[poll[0]][poll[1]] != 0 && map[poll[0]][poll[1]] < shark.weight) {
				map[poll[0]][poll[1]] = 0;
				shark.x = poll[0];
				shark.y = poll[1];
				shark.cnt++;
				result += poll[2];
				
				return true;
			}
			
			for (int d = 0; d < 4; d++) {
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
                // 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
				if(0<=dx && dx<N && 0<=dy && dy<N && !v[dx][dy] && map[dx][dy] <= shark.weight) {
					v[dx][dy] = true;
                    //아기 상어의 이동은 칸마다 1초
					pos.offer(new int[] {dx, dy, poll[2] + 1});
				}
			}
		}
		return false;
	}
}