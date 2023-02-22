import java.io.*;
import java.util.*;

public class Main {
	static int N, count ,result;
	static int[][] map;
	static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());

	    map = new int[N][N];
	    for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
	    	for (int j = 0; j < N; j++) {
				if(ch[j] == 'Y') map[i][j] = 1;
				else 			 map[i][j] = 0;
			}
		}
	    
	    result = 0;
	    
	    for (int i = 0; i < N; i++) {
	    	count = 0;
	    	v = new boolean[N];
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					if(map[i][j] == 1) v[j] = true;
					for (int d = 0; d < N; d++) {
						if(map[j][d] == 1) v[d] = true;
					}
				}
			}
			v[i] = false;
			for (int j = 0; j < N; j++) {
				if (v[j]) count++;
			}
			result = Math.max(result, count);
		}
	    System.out.println(result);
	}
}