import java.io.*;
import java.util.*;

public class Solution {
	static char[] dir = {'^', 'v', '<', '>'};
	static int[] dirX = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dirY = {0, 0, -1, 1};
	static int H, W;
	static int[] tank;
	static char[][] map;
	
//	문자의미
//	.	평지(전차가 들어갈 수 있다.)
//	*	벽돌로 만들어진 벽
//	#	강철로 만들어진 벽
//	-	물(전차는 들어갈 수 없다.)
//	^	위쪽을 바라보는 전차(아래는 평지이다.)
//	v	아래쪽을 바라보는 전차(아래는 평지이다.)
//	<	왼쪽을 바라보는 전차(아래는 평지이다.)
//	>	오른쪽을 바라보는 전차(아래는 평지이다.)
//	다음 표는 사용자가 넣을 수 있는 입력의 종류를 나타낸다.
//	 
//	동작
// 아무런 일도 안일어나는 경우 : 전차가 맵 밖으로 이동을 하려고 할 때
//	포탄을 발사 : 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진
//	포탄이 벽돌벽에 부딪히면 : 포탄은 소멸하고, 벽은 파괴되어 칸은 평지로 변경
//  포탄이 강철벽에 부딪히면 : 포탄은 소멸하고, 벽은 아무 일도 일어나지 않는다.
    

	static void tankAction(char c) {
		map[tank[0]][tank[1]] = dir[tank[2]];
		int dx = tank[0];
		int dy = tank[1];
		switch (c) {
		case 'U'://	U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
			tank[2] = 0;
			break;

		case 'D'://	D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
			tank[2] = 1;
			break;

		case 'L'://	L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
			tank[2] = 2;
			break;

		case 'R'://	R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
			tank[2] = 3;
			break;

		default://	S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
			break;
		}
		if(c != 'S') {
			dx += dirX[tank[2]];
			dy += dirY[tank[2]];
			if(0 <= dx && dx < H && 0 <= dy && dy < W && map[dx][dy] == '.') {
				map[tank[0]][tank[1]] = '.';
				tank[0] = dx;
				tank[1] = dy;
			}
		} else {
			while ( 0 <= dx && dx < H && 0 <= dy && dy < W) {
				if(map[dx][dy] == '*') {
					map[dx][dy] = '.';
					break;
				}else if (map[dx][dy] == '#') {
					break;
				}
				
				dx += dirX[tank[2]];
				dy += dirY[tank[2]];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 초기 설정 부분
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		// 테스트 케이스의 수 T가 주어진다.
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			// 두 정수 H[맵의 높이], W[맵의 너비] (2 ≤ H, W ≤ 20)
			st = new StringTokenizer(br.readLine());	
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			tank = new int[3];
			map = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				// 다음 H개의 각각의 줄에는 길이가 W인 문자열로 입력
				// 각각의 문자는 위의 게임 맵 구성 요소 표에 있는 문자들만 포함 (전차는 단 하나)
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					map[i][j] = ch[j];
					for (int d = 0; d < 4; d++) {
						if(map[i][j] == dir[d]) tank = new int[] {i, j, d};
					}
				}
			}
			
			st = new StringTokenizer(br.readLine());	
			
			// 사용자가 넣을 입력의 개수를 나타내는 정수 N(0 < N ≤ 100)
			int N = Integer.parseInt(st.nextToken());
			
			// 길이가 N인 문자열 (각각의 문자는 위의 사용자가 넣을 수 있는 입력의 종류를 나타내는 표에 있는 문자들만 포함)
			char[] in = br.readLine().toCharArray();
			for (int i = 0; i < N; i++) {
				tankAction(in[i]);
			}
			map[tank[0]][tank[1]] = dir[tank[2]];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}