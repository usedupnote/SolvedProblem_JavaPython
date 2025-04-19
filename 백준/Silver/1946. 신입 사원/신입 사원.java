import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int cnt = 0;
        	
        	PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
        		@Override
        		public int compare(int[] o1, int[] o2) {
        			return Integer.compare(o1[0], o2[0]);
        		}
			});
        	
        	for (int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
				q.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
        	
        	int cur = Integer.MAX_VALUE;
        	while (!q.isEmpty()) {
				int[] poll = q.poll();
				
				if (cur > poll[1]) {
					cur = poll[1];
					cnt++;
				}
			}
        	sb.append(cnt).append("\n");
		}
        
        System.out.println(sb);
        br.close();
	}
}