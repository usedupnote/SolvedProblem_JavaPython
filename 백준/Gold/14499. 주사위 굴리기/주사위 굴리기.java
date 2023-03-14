import java.io.*;
import java.util.*;
 
public class Main {
	static int[] dirX = {0, 0, -1, 1}; // 총 4가지 방향 (→,←,↑,↓)
	static int[] dirY = {1, -1, 0, 0}; 
	static int N, M, x, y, K, move;
	static int[][] map;
	static int[][] dice;
	static LinkedList<Integer> diceUD;
	static LinkedList<Integer> diceLR;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 지도의 세로 크기 N (1 ≤ N, M ≤ 20)
		M = Integer.parseInt(st.nextToken());	// 지도의 가로 크기 M 
		x = Integer.parseInt(st.nextToken());	// 주사위를 놓은 곳의 좌표 x, y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1)
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());	// 명령의 개수 K (1 ≤ K ≤ 1,000)

		//지도에 쓰여 있는 수
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//  2
		//4 1 3 6
		//  5
		//  6
		
		// 가장 처음에 주사위에는 모든 면에 0이 적혀져 있다.
		dice = new int[4][4];
		diceUD = new LinkedList<>(); 
		diceLR = new LinkedList<>();
		
		for (int i = 0; i < 4; i++) {
			diceUD.offer(0);
			diceLR.offer(0);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			// (동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4) - 1
			move = Integer.parseInt(st.nextToken()) - 1;
			
			int dx = x + dirX[move];
			int dy = y + dirY[move];
			
			if(0<=dx && dx<N && 0<=dy && dy<M) {
				x = dx;
				y = dy;
				
				if(move == 0) {
					// right
					diceLR.offer(diceLR.removeFirst());
					diceUD.remove(1);
					diceUD.add(1, diceLR.get(1));
					diceUD.removeLast();
					diceUD.offer(diceLR.getLast());
				} else if(move==1) {
					// left
					diceLR.addFirst(diceLR.removeLast());
					diceUD.remove(1);
					diceUD.add(1, diceLR.get(1));
					diceUD.removeLast();
					diceUD.offer(diceLR.getLast());
				} else if(move==2) {
					// up
					diceUD.offer(diceUD.removeFirst());
					diceLR.remove(1);
					diceLR.add(1, diceUD.get(1));
					diceLR.removeLast();
					diceLR.offer(diceUD.getLast());
				} else {
					// down
					diceUD.addFirst(diceUD.removeLast());
					diceLR.removeLast();
					diceLR.offer(diceUD.getLast());
					diceLR.remove(1);
					diceLR.add(1, diceUD.get(1));
				}

				// 주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
				// 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
				if (map[x][y] != 0) {
					diceUD.removeLast();
					diceLR.removeLast();
					diceUD.offer(map[x][y]);
					diceLR.offer(map[x][y]);
					map[x][y] = 0;
				} else {
					map[x][y] = diceLR.getLast();
				}

				
				sb.append(diceUD.get(1) + "\n");
			}
		}
		// 주사위는 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있으며, 놓여져 있는 곳의 좌표는 (x, y) 이다.
		// 주사위는 지도의 바깥으로 이동시킬 수 없다.

		// 이동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력한다.
		// 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.
		System.out.println(sb);
		br.close();
	}
}