import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-2,-2,-1,1,2,2,1,-1};  // 상2 우2 하2 좌2
	static int[] dirY = {-1,1,2,2,1,-1,-2,-2};  
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;			
		
		int T = Integer.parseInt(br.readLine());
				
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			boolean[][] map = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			int strX = Integer.parseInt(st.nextToken());
			int strY = Integer.parseInt(st.nextToken());
			
			ArrayDeque<int[]> point = new ArrayDeque<>();
			point.offer(new int[] {strX, strY, 0});
			
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			//bfs
			int dx, dy;
			while (!point.isEmpty()) {
				int[] poll = point.poll();
				
				if (poll[0]==endX && poll[1]==endY) {
					sb.append(poll[2]).append("\n");
					break;
				}
				
				if (map[poll[0]][poll[1]]) continue;

                for (int d = 0; d < 8; d++) {
					dx = poll[0] + dirX[d];
					dy = poll[1] + dirY[d];
					
					if (0<=dx && dx<N && 0<=dy && dy<N) {
						map[poll[0]][poll[1]] = true;
						point.offer(new int[] {dx,dy,poll[2]+1});
					}
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
}