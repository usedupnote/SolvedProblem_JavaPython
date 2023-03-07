import java.io.*;
import java.util.*;

public class Main {	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
			map[0][i] = Integer.parseInt(st.nextToken());
		}

        int[] current = new int[3];
        for (int i = 1; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 3; j++) {
        		current[j] = Integer.parseInt(st.nextToken());
			}
			map[i][0] = current[0] + Math.min(map[i-1][1], map[i-1][2]);
			map[i][1] = current[1] + Math.min(map[i-1][0], map[i-1][2]);
			map[i][2] = current[2] + Math.min(map[i-1][0], map[i-1][1]);
		}
        System.out.println(Math.min(map[N-1][0], Math.min(map[N-1][1], map[N-1][2])));
	}
}