import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int i = 0; i < 3; i++) {
        	q.offer(Integer.parseInt(st.nextToken()));
		}
        
        while (!q.isEmpty()) {
			sb.append(q.poll() + " ");
		}
        System.out.println(sb);
        br.close();
    }
}