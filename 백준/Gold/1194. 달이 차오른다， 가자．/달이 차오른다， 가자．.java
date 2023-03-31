import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1,1,0,0};		//상 하 좌 우
	static int[] dirY = {0,0,-1,1};
	
	static int[] player;
	static char[][] map;
	static int[][][] checkMap;
	
	static ArrayDeque<int[]> destination;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//첫째 줄에 미로의 세로 크기 N과 가로 크기 M(1 ≤ N, M ≤ 50)
		
		map = new char[N][M];
		checkMap = new int[N][M][1<<('F' - 'A' + 1) + 1];
		destination = new ArrayDeque<>();
		
		//둘째 줄부터 N개의 줄에 미로의 모양이 주어진다.
		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = ch[j];
				
				//민식이의 현재 위치: 빈 곳이고, 민식이가 현재 서 있는 곳이다. ('0')
				if(map[i][j] == '0') player = new int[] {i, j};
				//출구: 달이 차오르기 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를 탈출한다. ('1')
				else if(map[i][j] =='1') destination.offer(new int[] {i, j});
			}
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {player[0], player[1], 0, 0});
		
		int[] poll;
		
		int result = Integer.MAX_VALUE;
		
		while (!q.isEmpty()) {
			poll = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int dx = poll[0] + dirX[d];
				int dy = poll[1] + dirY[d];
				
				if(0<=dx && dx<N && 0<=dy && dy<M && map[dx][dy] != '#') {
					if(checkMap[dx][dy][poll[3]] != 0) continue;
					//열쇠칸 도달
					if(0<=map[dx][dy] - 'a' && map[dx][dy] - 'a'< 6) {
						checkMap[dx][dy][poll[3] | (1<<(map[dx][dy] - 'a'))] = poll[2] + 1;
						q.offer(new int[] {dx,dy,poll[2] + 1,poll[3] | (1<<(map[dx][dy] - 'a'))});
					}
					// 문 칸 도달
					else if(0<=map[dx][dy] -'A' && map[dx][dy] -'A' < 6) {
						if (((poll[3]) & (1<<(map[dx][dy]-'A'))) != 0) {
							checkMap[dx][dy][poll[3]] = poll[2] + 1;
							q.offer(new int[] {dx,dy,poll[2] + 1,poll[3]});
						}
					}
					// 그냥 이동
					else {
						checkMap[dx][dy][poll[3]] = poll[2] + 1;
						q.offer(new int[] {dx,dy,poll[2] + 1,poll[3]});
					}
				}
			}
		}
		while (!destination.isEmpty()) {
			int[] dpoll = destination.poll();
			int current = map[dpoll[0]][dpoll[1]];
			for (int i : checkMap[dpoll[0]][dpoll[1]]) {
				if(i == 0) continue;
				result = Math.min(result, i);
			}
		}
		
		System.out.println(result==Integer.MAX_VALUE?-1:result);
		br.close();
	}
}