import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        PriorityQueue<Integer> leftq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
        PriorityQueue<Integer> rightq = new PriorityQueue<>(new Comparator<Integer>() {
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		return Integer.compare(o1, o2);
        	}
        });

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            
            if (leftq.isEmpty()) {
            	leftq.add(n);
				sb.append(n).append("\n");
				
				continue;
			}
            
            if (leftq.peek() >= n) {
				leftq.add(n);
				if (leftq.size() > rightq.size()+1) {
					rightq.add(leftq.poll());
				}
			} else {
				rightq.add(n);
				if (leftq.size() < rightq.size()) {
					leftq.add(rightq.poll());
				}
			}
            
            sb.append(leftq.peek()).append("\n");
		}
        System.out.println(sb);
        
        br.close();
    }
}