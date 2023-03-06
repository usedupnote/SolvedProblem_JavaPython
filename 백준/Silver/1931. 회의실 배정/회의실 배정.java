import java.io.*;
import java.util.*;

public class Main {
    static int N, M, C, result;
    static int[][] map, honey;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        PriorityQueue<long[]> q = new PriorityQueue<>(new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[1] == o2[1]) {
					return Long.compare(o1[0], o2[0]);
				}
				return Long.compare(o1[1], o2[1]);
			}
		});
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	long A = Long.parseLong(st.nextToken());
        	long B = Long.parseLong(st.nextToken());
            
        	q.offer(new long[] {A,B});
		}
        
        long end = 0;
        long result = 0;
        
        while (!q.isEmpty()) {
        	long[] poll = q.poll();
			if (end <= poll[0]) {
				end = poll[1];
				result++;
			}
		}
        System.out.println(result);
    }
}