import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1,1,0,0};	//상하좌우
	static int[] dirY = {0,0,-1,1};
	static int[][] map;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	map = new int[9][9];
    	
    	for (int i = 0; i < 9; i++) {
        	st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	makeMap(0,0);
		//9개의 줄에 9개의 숫자로 답을 출력한다. 답이 여러 개 있다면 그 중 사전식으로 앞서는 것을 출력한다. 즉, 81자리의 수가 제일 작은 경우를 출력한다.
    	for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
    	System.out.println(sb);
    	br.close();
	}

	private static boolean makeMap(int x, int y) {
		if(x == 9) return true;
		
		if(map[x][y] != 0) {
			return makeMap(x + (y + 1)/9, (y + 1)%9);
		}
		
		boolean[] v = new boolean[10];
		
		// 가로 세로 검증
		for (int i = 0; i < 9; i++) v[map[x][i]] = true;
		for (int i = 0; i < 9; i++) v[map[i][y]] = true;
		
		// 3x3 사각형 검증
		int dx = (x/3)*3, dy = (y/3)*3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				v[map[dx + i][dy + j]] = true;
			}
		}
		
		for (int i = 1; i <= 9; i++) {
			if (v[i]) continue; 
			map[x][y] = i;
			if(makeMap(x + (y + 1)/9, (y + 1)%9)) return true;
		}
		map[x][y] = 0;
		return false;
	}
}