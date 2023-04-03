import java.io.*;
import java.util.*;

public class Solution {
	static int K;
	static int[][] magnetic;
	static boolean[] rotateCheck;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());	//최대 50
		
		for (int TC = 1; TC <= T; TC++) {
			//각 테스트 케이스의 첫 번째 줄에는 자석을 회전시키는 횟수 K 가 주어진다.
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());	//자석을 회전시키는 횟수 K ( 1 ≤ K ≤ 20 )

			magnetic = new int[4][8];	//자석의 개수는 4 개이며, 각 자석은 8 개의 날
			
			for (int i = 0; i < 4; i++) {
				//다음 4 개의 줄에는 1 번 자석부터 4 번 자석까지 각각 8 개 날의 자성정보
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnetic[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				//그 다음 K 개의 줄에는 자석을 1 칸씩 회전시키는 회전 정보가 주어진다.
				//자석의 회전 정보는 회전시키려는 자석의 번호, 회전방향으로 구성되어 있다.
				int num = Integer.parseInt(st.nextToken()) - 1;
				int rot = Integer.parseInt(st.nextToken()) * -1;		//회전방향은 1 일 경우 시계방향이며, -1 일 경우 반시계방향이다.
				
				rotateCheck = new boolean[4];
				
				rotate(num, rot);
			}

			//- 1 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 1 점을 획득한다.
			//- 2 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 2 점을 획득한다.
			//- 3 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 4 점을 획득한다.
			//- 4 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 8 점을 획득한다.
			int result = 0;
			for (int i = 0; i < 4; i++) result += magnetic[i][0] * (1<<i);
			
			//정답은 모든 자석의 회전이 끝난 후 획득한 점수의 총 합이다.
			sb.append("#"+TC+" " + result + "\n");
		}
		
		//하나의 자석이 1 칸 회전될 때, 붙어 있는 자석은 서로 붙어 있는 날의 자성이 다를 경우에만 반대 방향으로 1 칸 회전된다.
		//5. 자석을 회전시키는 방향은 시계방향이 1 로, 반시계 방향이 -1 로 주어진다.
		//6. 날의 자성은 N 극이 0 으로, S 극이 1 로 주어진다.
		System.out.println(sb);
		br.close();
	}
	private static void rotate(int num, int rot) {
		rotateCheck[num] = true;
		if(num+1 < 4 && !rotateCheck[num+1]) {
			if(magnetic[num][2] != magnetic[num+1][6]) {
				rotate(num+1, rot * -1);
			}
		}
		if(num-1 >= 0 && !rotateCheck[num-1]) {
			if(magnetic[num][6] != magnetic[num-1][2]) {
				rotate(num-1, rot * -1);
			}
		}
		
		for (int i = 0; i < 7; i++) {
			int changeTo = ((i * rot) + 8)%8;
			int changeFrom = ((i * rot) + 9)%8;
			magnetic[num][changeTo] += magnetic[num][changeFrom];
			magnetic[num][changeFrom] = magnetic[num][changeTo] - magnetic[num][changeFrom];
			magnetic[num][changeTo] -= magnetic[num][changeFrom];
		}
	}
}