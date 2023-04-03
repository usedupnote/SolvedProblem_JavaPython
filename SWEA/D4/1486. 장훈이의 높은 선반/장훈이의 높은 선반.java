import java.io.*;
import java.util.*;

// 양의 가중치 버전
public class Solution {
	static final int INF = 9999999;
	static int N, B, result;
	static int[] height;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//N, B(1 ≤ N ≤ 20, 1 ≤ B ≤ 점원들 키의 합)
			B = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			height = new int[N];
			
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());	// 각 점원의 키 Hi (1 ≤ Hi ≤ 10,000)
			}
			result = 200001;
			v = new boolean[N];
			comb(0,0,0);
			
			sb.append("#" + TC + " " + (result - B) + "\n");
		}
		
		//서점에는 높이가 B인 선반이 하나 있는데 장훈이는 키가 매우 크기 때문에, 선반 위의 물건을 자유롭게 사용할 수 있다.
		//어느 날 장훈이는 자리를 비웠고, 이 서점에 있는 N명의 점원들이 장훈이가 선반 위에 올려놓은 물건을 사용해야 하는 일이 생겼다.
		//각 점원의 키는 Hi로 나타나는데, 점원들은 탑을 쌓아서 선반 위의 물건을 사용하기로 하였다.

		//탑의 높이는 점원이 1명일 경우 그 점원의 키와 같고, 2명 이상일 경우 탑을 만든 모든 점원의 키의 합과 같다.
		//탑의 높이가 B 이상인 경우 선반 위의 물건을 사용할 수 있는데 탑의 높이가 높을수록 더 위험하므로 높이가 B 이상인 탑 중에서 높이가 가장 낮은 탑을 알아내려고 한다.

		//[출력]
		//각 테스트 케이스마다 첫 번째 줄에는 ‘#t’(t는 테스트 케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 만들 수 있는 높이가 B 이상인 탑 중에서 탑의 높이와 B의 차이가 가장 작은 것을 출력한다.

		System.out.println(sb);
	}
	private static void comb(int current, int cnt, int sumHeight) {
		if(sumHeight >= B) {
			result = Math.min(result, sumHeight);
			return;
		}
		if(cnt == N || current == N) return;
		for (int i = current; i < N; i++) {
			if(v[i]) continue;
			v[i] = true;
			comb(i + 1, cnt + 1, sumHeight + height[i]);
			v[i] = false;
		}
	}
}