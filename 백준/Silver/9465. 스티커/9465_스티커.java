import java.io.*;
import java.util.*;
 
public class Main {
    static int[][] map;
     
    static Set<Integer> list;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        //테스트 케이스의 개수 T
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            
            map = new int[2][N];
            
            for (int i = 0; i < 2; i++) {
            	st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
            
            if(N == 1) {
            	sb.append(Math.max(map[0][0], map[1][0]) + "\n");
            	continue;
            }
            
            for (int j = 0; j < 2; j++) {
				map[j][1] += map[(j + 1) % 2][0];
			}
            
            if (N == 2) {
            	
            }

            for (int i = 2; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					map[j][i] += Math.max(map[(j + 1) % 2][i - 1], map[(j + 1) % 2][i - 2]);
				}
			}
            
            sb.append(Math.max(map[0][N-1], map[1][N-1]) + "\n");
		}
        System.out.println(sb);
        br.close();
 
    }
}