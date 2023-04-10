import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {0,-1,1,0,0};	// 0 상 하 좌 우
	static final int[] dirY = {0,0,0,-1,1};
	
	static int R,C,N;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());		//1 ≤ R, C ≤ 200
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());		//1 ≤ N ≤ 10^9
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = ch[j];	//빈 칸은 '.', 폭탄은 'O'
			}
		}
		
		for (int i = 1; i <= 5; i++) {
			if (i == 3) {
				changeMap();
			}
			if (i == 5) {
				changeMap();
			}
			if(i == N) {
				N %= 2;
				break;
			}
		}
		
		N %= 4;
		
		if(N==1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == 'X') sb.append('.');
					else 				 sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		} 
		else if (N==3) {
			changeMap();
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == 'X') sb.append('.');
					else				 sb.append('O');
				}
				sb.append("\n");
			}
		} 
		else {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append('O');
				}
				sb.append("\n");
			}
		}
		//총 R개의 줄에 N초가 지난 후의 격자판 상태를 출력한다.
		System.out.println(sb);
		br.close();
	}

	private static void changeMap() {
		char[][] copyMap = new char[R][C];

		for (int i = 0; i < R; i++) {
			Arrays.fill(copyMap[i], 'O');
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'O') {
					int dx, dy;
					for (int d = 0; d < 5; d++) {
						dx = i + dirX[d];
						dy = j + dirY[d];
						
						if(0<=dx && dx<R && 0<=dy && dy<C) {
							copyMap[dx][dy] = 'X';
						}
					}
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			map[i] = copyMap[i].clone();
		}
	}

}