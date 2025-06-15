import java.io.*;
import java.util.*;

public class Main {
	static int[] map;
	static int reach100() {
		boolean[] v = new boolean[101];
		
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        q.add(new int[] {1, 0});
        
        while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int i = 1; i <= 6; i++) {
				int cur = map[poll[0] + i];
				
				if (v[cur]) continue;
				v[cur] = true;
				
				if (cur == 100) return poll[1] + 1;
				q.add(new int[] {cur, poll[1] + 1});
			}
		}
		return -1;
	}
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        map = new int[101];
        
        for (int i = 0; i < 101; i++) {
			map[i] = i;
		}
        
        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            
            map[start] = dest;
		}
        
        System.out.println(reach100());
        br.close();
    }
}