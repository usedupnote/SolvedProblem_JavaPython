import java.io.*;
import java.util.*;

public class Main {
	static int result;
	static int[][] map;
	static boolean[][] v;
	static int[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		result = Integer.MAX_VALUE;
		map = new int[10][10];
		v = new boolean[10][10];
		
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				//총 10개의 줄에 종이의 각 칸에 적힌 수가 주어진다.
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1. 전체탐색
		makeMap();
		
		// 2. searchMap()
		check = new int[] {0,5,5,5,5,5};
		searchMap(0,0,0);
		
		System.out.println(result==Integer.MAX_VALUE?-1:result);
	}
	private static void searchMap(int x, int y, int cnt) {
		if (x > 9) {
            result = Math.min(result, cnt);
            return;
        }
		
		if (result <= cnt) {
            return;
        }
		
		if (map[x][y] != 0 && !v[x][y]) {
			for (int k = 1; k <= map[x][y]; k++) {
				if(check[k]<=0 || isAttach(x,y,k)) continue;
				check[k]--;
				setVisited(x, y, k);
				searchMap(x+((y+1)/10),(y+1)%10, cnt+1);
				check[k]++;
				setVisited(x, y, k);
			}
		} else {
			searchMap(x+((y+1)/10),(y+1)%10, cnt);
		}
	}
	
	static boolean isAttach(int x, int y, int cnt) {
		if (x+cnt > 10 || y+cnt > 10) return true;
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt; j++) {
				if (map[x+i][y+j] == 0 || v[x+i][y+j]) return true;
			}
		}
		return false;
	}
	
	private static void setVisited(int x, int y, int cnt) {
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt; j++) {
				v[x+i][y+j] = (v[x+i][y+j] == false);
			}
		}
	}
	private static void makeMap() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					for (int k = 2; k <= 5; k++) {
						if (setMap(i,j,k)) break;
						map[i][j] = k;
					}
				}
			}
		}
	}
	private static boolean setMap(int x, int y, int cnt) {
		int dx, dy;
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt; j++) {
				dx = x + i;
				dy = y + j;
				
				if(dx>=10 || dy>=10 || map[dx][dy] == 0) return true;
			}
		}
		return false;
	}
}