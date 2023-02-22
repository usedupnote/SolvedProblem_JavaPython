import java.io.*;
import java.util.*;

public class Solution {
	static int N, result;
	static int[][] pos, sep;
	static boolean[] v;
	
	static void prem(int to, int cnt, int checkPoint) {
        if (checkPoint > result) return;
		if (cnt == N + 1) {
			checkPoint += sep[to][1];
			result = Math.min(result, checkPoint);
            return;
		}
		for (int i = 2; i < N + 2; i++) {
			if(v[i]) continue;
			v[i] = true;
			prem(i, cnt + 1, checkPoint + sep[to][i]);
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 초기 설정 부분
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb   = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());	

		// 테스트 케이스의 수 T가 주어진다.
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			// 고객의 수 N은 2≤N≤10 이다.
			st = new StringTokenizer(br.readLine());	
			N = Integer.parseInt(st.nextToken());
			
			// 회사의 좌표,집의 좌표, N명의 고객의 좌표가 차례로 나열
			// 회사의 좌표, 집의 좌표를 포함한 모든 N+2개의 좌표는 서로 다른 위치에 있음 (0<= 좌표 <= 100)
			pos = new int[N + 2][2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < 2; j++) {
					pos[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 각 지점 별 떨어진 거리 기록
			sep = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {
				for (int j = i+1; j < N + 2; j++) {
					sep[i][j] = sep[j][i] = Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]);
				}
			}
			v = new boolean[N + 2];

			// 1(회사),2(집) 번 위치는 고정
			v[0] = v[1] = true;
			
			// result 값 초기화
			result = 987654321;
			
			prem(0, 1, 0);
			
			// 각 줄은 ‘#x’로 시작하고 공백을 하나 둔 다음 최단 경로의 이동거리를 기록한다. 여기서 x는 테스트 케이스의 번호다.
			sb.append("#" + test_case + " " + result + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}