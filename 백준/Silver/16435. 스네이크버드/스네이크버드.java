import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	PriorityQueue<Integer> num = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		num.offer(Integer.parseInt(st.nextToken()));
		}
    	
    	for (int i = 0; i < N; i++) {
			if(M >= num.poll()) M++;
		}
    	System.out.println(M);
        br.close();
    }
}