import java.io.*;
import java.util.*;

public class Main {	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt((st.nextToken()));
    	ArrayDeque<Integer> al = new ArrayDeque<>();
    	
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	String order = st.nextToken();
        	
        	switch (order) {
			case "push":
				al.add(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop":
				if (!al.isEmpty()) sb.append(al.pop());
				else sb.append(-1);
				sb.append("\n");
				break;
				
			case "size":
				sb.append(al.size()).append("\n");
				break;
				
			case "empty":
				if (!al.isEmpty()) sb.append(0);
				else sb.append(1);
				sb.append("\n");
				break;
				
			case "front":
				if (!al.isEmpty()) sb.append(al.getFirst());
				else sb.append(-1);
				sb.append("\n");
				break;
				
			case "back":
				if (!al.isEmpty()) sb.append(al.getLast());
				else sb.append(-1);
				sb.append("\n");
				break;
			}
		}
        System.out.println(sb);
        br.close();
    }
}