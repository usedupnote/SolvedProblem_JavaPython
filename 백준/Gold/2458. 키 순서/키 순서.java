import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 99999999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		//학생들의 수 N이 주어진다. (2 ≤ N ≤ 500)
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		//두 학생의 키를 비교한 횟수 M이 주어진다. (0 ≤ M ≤ N*(N-1)/2)
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], INF);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			//각 테스트 케이스의 세 번째 줄부터 M개의 줄에 걸쳐 두 학생의 키를 비교한 결과를 나타내는 두 양의 정수 a, b가 주어진다.
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			//이는 번호가 a인 학생이 번호가 b인 학생보다 키가 작은 것을 의미한다. 이 때, 입력은 항상 모순이 없도록 주어진다.
			map[a][b] = 1;
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				if((map[i][j] & map[j][i]) != INF) {
					cnt++;
					continue;
				}
				break;
			}
			if(cnt == N) result++;
		}
		
		//자신이 키가 몇 번째인지 알 수 있는 학생이 모두 몇 명인지를 출력한다.
		System.out.println(result);
		br.close();
	}
}