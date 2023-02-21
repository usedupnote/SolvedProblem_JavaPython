import java.io.*;
import java.util.*;

public class Main {
    static int[] dir = {-1, 0, 1}; // 우상 우 우하
    static int R, C, result;
    static boolean[][] map;

    static boolean dfs(int x, int y) {
        if(0 > x || x >= R) return false;
        if(y == C-1) return true;
        if(!map[x][y]) return false;
        map[x][y] = false;

	    if(dfs(x + dir[0], y + 1)) return true;
	    if(dfs(x + dir[1], y + 1)) return true;
	    if(dfs(x + dir[2], y + 1)) return true;
	    return false;
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    
	    map = new boolean [R][C];
	    
	    for (int i = 0; i < R; i++) {
	        char[] ch = br.readLine().toCharArray();
	        for (int j = 0; j < C; j++) {
	            if(ch[j] == 'x') map[i][j] = false;
	            else             map[i][j] = true;
	        }
	    }
	    
	    for (int i = 0; i < R; i++) {
	        if(dfs(i, 0)) result++;
	    }
	    System.out.println(result);
	}
}