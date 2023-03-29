import java.io.*;
import java.util.*;

public class Solution {
	static int N, K, result;
	static ArrayDeque<int[]> ad;
	static int[][] bag;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;

    	st = new StringTokenizer(br.readLine());
    	int T = Integer.parseInt(st.nextToken());	//TestCase 수
    	
    	for (int TC = 1; TC <= T; TC++) {
    		st = new StringTokenizer(br.readLine());
    		
    		N = Integer.parseInt(st.nextToken());	//물품의 수 N(1 ≤ N ≤ 100)
    		K = Integer.parseInt(st.nextToken());	//버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)
    		
    		ad = new ArrayDeque<>();
    		
    		for (int i = 0; i < N; i++) {
    			st = new StringTokenizer(br.readLine());
    			int W = Integer.parseInt(st.nextToken()); //물건의 무게 W(1 ≤ W ≤ 100,000)
    			int V = Integer.parseInt(st.nextToken()); //해당 물건의 가치 V(0 ≤ V ≤ 1,000)
    			ad.offer(new int[] {W, V});
    		}
    		
    		bag = new int[N][K + 1];
    		
    		int[] poll = ad.poll();
    		for (int i = 0; i <= K; i++) {
    			if(i >= poll[0]) {
    				bag[0][i] = poll[1];
    			}
    		}
    		
    		if(N != 1) {
    			for (int i = 1; i < N; i++) {
    				poll = ad.poll();
    				for (int j = 0; j <= K; j++) {
    					if(j >= poll[0]) {
    						bag[i][j] = Math.max(bag[i-1][j], bag[i-1][j - poll[0]] + poll[1]);
    					} else {
    						bag[i][j] = bag[i-1][j];
    						
    					}
    				}
    			}
    		}
    		//한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다.
    		sb.append("#" + TC + " " + bag[N -1][K] + "\n");
		}
    	
    	System.out.println(sb);
    	br.close();
	}
}