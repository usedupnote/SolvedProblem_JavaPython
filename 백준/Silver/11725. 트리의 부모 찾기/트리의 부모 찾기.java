import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    int N = Integer.parseInt(st.nextToken());

	    ArrayList<Integer>[] al = new ArrayList[N + 1];
	    
	    for (int i = 0; i <= N; i++) {
			al[i] = new ArrayList<>();
		}

	    for (int i = 1; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	al[a].add(b);
	    	al[b].add(a);
		}
	    
	    int[] v = new int[N + 1];
	    
	    ArrayDeque<Integer> ad = new ArrayDeque<>();
	    
	    ad.offer(1);
	    
	    while (!ad.isEmpty()) {
	    	int poll = ad.poll();
	    	for (int i : al[poll]) {
	    		if(v[i] != 0) continue;
	    		v[i] = poll;
	    		ad.offer(i);
			}
		}
	    for (int i = 2; i <= N; i++) {
	    	sb.append(v[i] + "\n");
		}
	    System.out.println(sb);
	    br.close();
	}
}