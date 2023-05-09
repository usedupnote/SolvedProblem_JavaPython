import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        PriorityQueue<Long> qStart = new PriorityQueue<>();
        PriorityQueue<Long> qEnd   = new PriorityQueue<>();
        
        long result = Long.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
        	long num = Long.parseLong(br.readLine());
        	qStart.offer(num);
        	qEnd  .offer(num);
		}
        
        long pollStart, pollEnd;
        pollEnd = qEnd.poll();
        label : while (!qStart.isEmpty()) {
        	pollStart = qStart.poll();
        	
        	while (pollStart + M > pollEnd) {
        		if (qEnd.isEmpty()) break label;
            	pollEnd = qEnd.poll();
			}
        	result = Math.min(result, pollEnd - pollStart);
        	
        	if (result == M) break;
		}
        System.out.println(result);
        br.close();
    }
}