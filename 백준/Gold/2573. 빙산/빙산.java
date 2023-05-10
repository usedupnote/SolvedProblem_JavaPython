import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {1,0,-1,0};	//하좌우상
	static final int[] dirY = {0,-1,0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        int result = 0;
        int cnt = 0;
        year: while(true) {
        	result++;
        	int[][] v = new int[N][M];
        	int dx, dy;
        	for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) continue;
					
					v[i][j] = map[i][j];
					for (int d = 0; d < 4; d++) {
						dx = i + dirX[d]; 
						dy = j + dirY[d]; 
						
						if (0<=dx && dx<N && 0<=dy && dy<M && map[dx][dy] == 0) {
							v[i][j] -= 1;
						}
					}
					if (v[i][j] <= 0) {
						v[i][j] = 0;
					} else {
						cnt++;
					}
				}
			}
        	
        	if (cnt == 0) {
        		result = 0;
				break;
			}
        	
        	for (int i = 0; i < N; i++) {
				map[i] = v[i].clone();
			}
        	
        	for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (v[i][j] == 0) continue;
					ArrayDeque<int[]> q = new ArrayDeque<>();
					
					q.offer(new int[] {i,j});
					v[i][j] = 0;
					cnt--;
					
					while (!q.isEmpty()) {
						int[] poll = q.poll();
						for (int d = 0; d < 4; d++) {
							dx = poll[0] + dirX[d]; 
							dy = poll[1] + dirY[d];
							
							if (0<=dx && dx<N && 0<=dy && dy<M && v[dx][dy] != 0) {
								q.offer(new int[] {dx,dy});
								v[dx][dy] = 0;
								cnt--;
							}
						}
					}
					if (cnt != 0) {
						break year;
					} else {
						continue year;
					}
				}
			}
        }
        System.out.println(result);
        br.close();
    }
}