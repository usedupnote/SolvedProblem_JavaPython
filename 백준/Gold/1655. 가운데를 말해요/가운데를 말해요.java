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
        int T = Integer.parseInt(st.nextToken());
        
        leftq.offer(Integer.parseInt(br.readLine()));
        sb.append(leftq.peek()).append("\n");
        
        for (int i = 1; i < T; i++) {
        	int num = Integer.parseInt(br.readLine());
        	
        	if(leftq.peek() < num) rightq.offer(num);
        	else leftq.offer(num);
        	
        	if (leftq.size() == rightq.size() + 2) {
				rightq.offer(leftq.poll());
			}
        	if (leftq.size() + 1 == rightq.size()) {
        		leftq.offer(rightq.poll());
			}
        	sb.append(leftq.peek()).append("\n");
		}
        
        System.out.println(sb);
    }
}