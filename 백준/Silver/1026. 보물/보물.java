import java.io.*;
import java.util.*;

public class Main {		
	static int N, result;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		result = 0;
        
		PriorityQueue<Integer> A = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
			}
		});
        
		PriorityQueue<Integer> B = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
			}
		});
        
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N ; i++) {
            A.offer(Integer.parseInt(st.nextToken()));
        }
        
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N ; i++) {
            B.offer(Integer.parseInt(st.nextToken()));
        }
        
        for (int i = 0 ; i < N ; i++) {
            int pollA = A.poll();
            int pollB = B.poll();
            
            result += pollA * pollB;
        }
        System.out.println(result);
		br.close();
	}
}
