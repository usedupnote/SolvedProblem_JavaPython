import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(st.nextToken());
    	
    	int[] pos;
    	PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});
    	
    	int x, y;
    	for (int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			q.offer(new int[] {x,y});
		}
    	
    	int[] poll;
    	while (!q.isEmpty()){
    		poll = q.poll();
			sb.append(poll[0]).append(" ").append(poll[1]).append("\n");
		}
    	System.out.println(sb);
    }
}