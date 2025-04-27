import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        
        Stack<int[]> s = new Stack<>();
        
        s.add(new int[] {100_000_001, 0});
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			int[] pop = s.pop();
        	while (pop[0] < height) {
        		pop = s.pop();
			}
        	s.add(pop);
			sb.append(s.peek()[1]).append(" ");
			s.add(new int[] {height, i});
		}
        
        System.out.println(sb);
        br.close();
	}
}