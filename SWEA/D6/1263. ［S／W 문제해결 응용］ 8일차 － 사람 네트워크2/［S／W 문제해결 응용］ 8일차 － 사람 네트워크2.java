import java.io.*;
import java.util.*;

public class Solution {
	static final int INF = 9999999;
	static int N,distance[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			distance = new int[N][N];
			for(int i=0; i<N; ++i) {
				for(int j=0; j<N; ++j) {
					distance[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && distance[i][j]==0) {//자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
						distance[i][j]=INF;
					}
				}
			}
			for(int k=0; k<N; ++k) {
				for(int i=0; i<N; ++i) {
					if(i==k) continue;
					for(int j=0; j<N; ++j) {
						if(i==j || k==j) continue;
						if(distance[i][j] > distance[i][k]+distance[k][j]) {
							distance[i][j] = distance[i][k]+distance[k][j];
						}
					}
				}
			}
			int result = 999999;
			for (int i = 0; i < N; i++) {
				int compare = 0;
				for (int j = 0; j < N; j++) {
					compare += distance[i][j];
				}
				result = Math.min(result, compare);
			}
			sb.append("#" + TC + " " + result + "\n");
		}
		System.out.println(sb);
	}
}