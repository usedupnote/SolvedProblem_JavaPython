import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {1,0,-1,0};	//하좌우상
	static final int[] dirY = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	
    	int x = 0, y = 0;
    	int dir = 0;
    	int minX = 0, maxX = 0, minY = 0, maxY = 0;
    	
    	char[] move = br.readLine().toCharArray();
    	
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	
    	q.offer(new int[] {0,0});
    	
    	for (int i = 0; i < N; i++) {
			if (move[i] == 'R') {
				dir = (dir + 1) % 4;
			} else if (move[i] == 'L') {
				dir = (dir + 3) % 4;
			} else {
				x += dirX[dir];
				y += dirY[dir];

				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
				
				q.offer(new int[] {x, y});
			}
		}
    	
    	int lenX = maxX - minX + 1;
    	int lenY = maxY - minY + 1;
		int[][] map = new int[lenX][lenY];
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			map[poll[0] - minX][poll[1] - minY] = 1;
		}
		
		for (int i = 0; i < lenX; i++) {
			for (int j = 0; j < lenY; j++) {
				sb.append(map[i][j]==0?'#':'.');
			}
			sb.append("\n");
		}
    	
        System.out.println(sb);
        br.close();
    }
}