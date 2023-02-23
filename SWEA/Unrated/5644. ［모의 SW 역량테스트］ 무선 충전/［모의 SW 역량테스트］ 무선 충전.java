import java.io.*;
import java.util.*;

public class Solution {
	// 각각의 숫자는 다음과 같이 매초마다 이동 방향을 의미
	static int[] dirX = {0, -1, 0, 1, 0}; // 0 : 이동하지 않음, 1 : 상, 2 : 우, 3 : 하, 4 : 좌
	static int[] dirY = {0, 0, 1, 0, -1};
	static int N, A, result;
	static int[] perPosA, perPosB;
	static int[][] m, listBC;
	
	static void move(int dir, int j) {
		perPosA[0] += dirX[dir] * ((j + 1) % 2);
		perPosA[1] += dirY[dir] * ((j + 1) % 2);
		perPosB[0] += dirX[dir] * ((j	 ) % 2);
		perPosB[1] += dirY[dir] * ((j	 ) % 2);
	}
	
	public static void main(String[] args) throws IOException {
		// 초기 설정 부분
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb   = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());	

		// 테스트 케이스의 수 T가 주어진다.
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 테스트 케이스의 첫 번째 줄에는 총 이동 시간(M), BC의 개수(A)가 주어진다.
			st = new StringTokenizer(br.readLine());	
			N = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			// 한 사용자의 이동 정보는 M개의 숫자로 구성
			// 그 다음 2개의 줄에는 각각 사용자 A와 B의 이동 정보가 주어진다.
			m = new int[2][N];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N ; j++) {	
					m[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 그 다음 줄에는 A개의 줄에 걸쳐 BC의 정보가 주어진다.
			// 하나의 BC 정보는 좌표(X, Y), 충전 범위(C), 처리량(P)로 구성된다.
			listBC = new int[A][4];
			for (int i = 0; i <A; i++) {
				st = new StringTokenizer(br.readLine());	

				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				listBC[i] = new int[] {Y, X, C, P};
			}
			
			Arrays.sort(listBC, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[3] - o1[3];
				}
			});
			
			perPosA = new int[] {1, 1}; 
			perPosB = new int[] {10, 10};
			result = 0;

			// 이동 진행
			for (int i = 0; i <= N; i++) {
				int cntAll = 0;
				int cntA = 0;
				int cntB = 0;

				// 매 이동마다 2명이 포함된 곳이 어디인지 파악
				for (int j = 0; j < A; j++) {
					int farA = Math.abs(listBC[j][0] - perPosA[0]) + Math.abs(listBC[j][1] - perPosA[1]);
					int farB = Math.abs(listBC[j][0] - perPosB[0]) + Math.abs(listBC[j][1] - perPosB[1]);
					
					if(farA <= listBC[j][2] && farB <= listBC[j][2]) {
						result += listBC[j][3];
						cntAll++;
					} else {
						if(cntA == 0 && farA <= listBC[j][2]) {
							cntA++;
							cntAll++;
							result += listBC[j][3];
						} 
						if(cntB == 0 && farB <= listBC[j][2]) {
							cntB++;
							cntAll++;
							result += listBC[j][3];
						}
					}
					
					if(cntAll == 2) break;
				}
				
				if(i == N) break;
				
				// 2명의 위치 파악
				perPosA[0] += dirX[m[0][i]];
				perPosA[1] += dirY[m[0][i]];
				perPosB[0] += dirX[m[1][i]];
				perPosB[1] += dirY[m[1][i]];
			}
			sb.append("#" + test_case + " " + result + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}