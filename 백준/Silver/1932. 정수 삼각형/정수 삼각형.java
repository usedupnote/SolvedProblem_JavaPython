import java.io.*;
import java.util.*;

public class Main {	
	static final int[] dir = {0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N + 1][N];
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
				int max = 0;
				for (int d = 0; d < 2; d++) {
					int dj = j + dir[d];
					if(0<=dj) {
						max = Math.max(max, map[i-1][dj]);
					}
				}
				map[i][j] = Integer.parseInt(st.nextToken()) + max;
			}
		}
        
        int result = 0;
        for (int i = 0; i < N; i++) {
        	result = Math.max(result, map[N][i]);
		}
        
        System.out.println(result);
	}
}