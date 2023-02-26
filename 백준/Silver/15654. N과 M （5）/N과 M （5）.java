import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] num, b;
	static PriorityQueue<int[]> result;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());

	    num = new int[N];
	    b = new int[M];
	    result = new PriorityQueue<>(new Comparator<int[]>() {

	    	@Override
			public int compare(int[] o1, int[] o2) {
	    		for (int i = 0; i < M; i++) {
	    			if(o1[i] == o2[i]) continue;
					return o1[i] - o2[i];
				}
				return 0;
			}
		});
	    
	    st = new StringTokenizer(br.readLine());

	    for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	    
	    v = new boolean[N];
	    prem(0);
	    
	    while (!result.isEmpty()) {
			sb.append(Arrays.toString(result.poll()).replace("]", "").replace("[", "").replace(",", "") + "\n");
		}
	    System.out.println(sb);
	}

	static void prem(int cnt) {
		if (cnt == M) {
			int[] a = b.clone();
			result.add(a);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[cnt] = num[i];
			prem(cnt+1);
			v[i] = false;
		}
	}
}