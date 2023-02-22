import java.io.*;
import java.util.*;

public class Main {
	static int score;
	static int[][] map;
	
	static boolean match(int x, int y, int cnt) {
		if(cnt == 15) {
			return true;
		}

		if(y == 6) {
			x += 1;
			y = x + 1;
		}
		if(x == 5) return false;
		// x팀 승리
		map[x][0] -= 1; map[y][2] -= 1;
		if(map[x][0] >= 0 && map[y][2] >= 0) {
			if(match(x, y+1, cnt+1)) return true;
		}
		map[x][0] += 1; map[y][2] += 1;

		// 동점
		map[x][1] -= 1; map[y][1] -= 1;
		if(map[x][1] >= 0 && map[y][1] >= 0) {
			if(match(x, y+1, cnt+1)) return true;
		}
		map[x][1] += 1; map[y][1] += 1;

		// x팀 패배
		map[x][2] -= 1; map[y][0] -= 1;
		if(map[x][2] >= 0 && map[y][0] >= 0) {
			if(match(x, y+1, cnt+1)) return true;
		}
		map[x][2] += 1; map[y][0] += 1;
		
		return false;
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	start : for (int test_case = 0; test_case < 4; test_case++) {
    		score = 0;
    		map = new int[6][3];
    		
    		st = new StringTokenizer(br.readLine());
    		
    		for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
    		for (int i = 0; i < 6; i++) {
				int teamMatch = 0;
    			for (int j = 0; j < 3; j++) {
					teamMatch += map[i][j];
				}
    			if (teamMatch > 5) {
    				sb.append(0 + " ");
    				continue start;
    			}
			}
    		// 전 경기 진행
    		sb.append((match(0, 1, 0)?1:0) + " ");
		}
    	System.out.println(sb);
    	br.close();
    }
}