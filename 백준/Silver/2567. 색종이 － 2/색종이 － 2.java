// 제약조건
//  사용가능한언어Java
//  제한시간1초
//  메모리제한128MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dirX = {1, 0}; // 상 우
		int[] dirY = {0, 1};
		//검은 스카프의 수 ( <= 100)
		int N = Integer.parseInt(st.nextToken());
		
		//검은색 스카프가 흰색천 밖으로 나가는 경우는 없음 (하지만 탐색의 편의를 위해서 102로 설정)
		// 100x100에는 101칸의 공간이 필요하지만, 상 우 탐색을 진행하면서 공간이 바뀌는 것을 체크하기 위해 빈 하나의 공간을 추가로 할당
		int[][] map = new int[102][102];

		// 한 줄에 하나씩 검은색 스카프를 놓은 위치
		for (int T = 0; T < N; T++) {
			st = new StringTokenizer(br.readLine());
			//첫번째 자연수 = 검은색 스카프의 왼쪽 변과 흰색천의 왼쪽 변 사이의 거리
			int x = Integer.parseInt(st.nextToken());
			//두번째 자연수 = 아래쪽 변과 흰색천의 아래쪽 변 사이의 거리
			int y = Integer.parseInt(st.nextToken());
			
			// map에서 스카프가 올라간 위치를 1로 변경해서 구분
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		// 맵을 순회하면서 둘레의 길이 구하기
		int result = 0;
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				for (int d = 0; d < 2; d++) {//이방향 탐색을 위한 d 반복
					int di = i + dirX[d];
					int dj = j + dirY[d];
					
					// map에서 상/우 를 탐색하며 새로운 영역에 들어가면 변의 길이 1 추가
					if(map[di][dj] == map[i][j]) continue;
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}