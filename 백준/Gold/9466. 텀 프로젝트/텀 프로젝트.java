import java.io.*;
import java.util.*;

public class Main {
	static int[] map, v;
	
	static int DFS(int cur, int cnt) {
		if(v[cur] > 0) {
			return cnt - v[cur];
		} else if (v[cur] < 0) {
			return -1;
		}
		v[cur] = cnt;
		int result = DFS(map[cur], cnt+1);
		if(result > 0) {
			v[cur] = -1;
		} else {
			v[cur] = -2;
		}
		return result - 1;
	}
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(st.nextToken());
        
        for (int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	
        	int result = 0;
        	
        	map = new int[N];
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
        		map[i] = Integer.parseInt(st.nextToken()) - 1;
			}
        	
        	v = new int[N];
        	for (int i = 0; i < N; i++) {
        		if (v[i] != 0) continue;
        		DFS(i, 1);
    		}
        	
        	for (int i = 0; i < N; i++) {
				if(v[i] == -2) result += 1;
			}
        	
        	sb.append(result).append("\n");
		}
        
        System.out.println(sb);
        br.close();
	}
}