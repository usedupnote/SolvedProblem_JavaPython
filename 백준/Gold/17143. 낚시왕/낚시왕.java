import java.io.*;
import java.util.*;

public class Main {		
	public static void main(String[] args) throws Exception {
		// 기본 설정 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		// 첫재 줄에 대한 정보 수집
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken());	// 행의 수
		int C = Integer.parseInt(st.nextToken());	// 열의 수
		int M = Integer.parseInt(st.nextToken());	// 상어의 수
		
		int[][] Map 	= new int[R][C];		// 상어의 위치를 저장할 지도 배열
		int[][] Sharks 	= new int[M][5];		// 상어의 정보를 저장할 배열
		
		// 상 하 우 좌 방향 설정
		int[] dirX = {0, 0, 1, -1};
		int[] dirY = {-1, 1, 0, 0};
		
		int result = 0;							// 잡은 상어의 무게를 저장할 값
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			// Sharks의 각 위치에 값 저장
			Sharks[i][0] = Integer.parseInt(st.nextToken()) - 1;
			Sharks[i][1] = Integer.parseInt(st.nextToken()) - 1;
			Sharks[i][2] = Integer.parseInt(st.nextToken());
			Sharks[i][3] = Integer.parseInt(st.nextToken()) - 1;
			Sharks[i][4] = Integer.parseInt(st.nextToken());
			
			Sharks[i][2] = Math.abs((Sharks[i][2] % ((C-1) * 2) * dirX[Sharks[i][3]]) + (Sharks[i][2] % ((R-1) * 2) * dirY[Sharks[i][3]]));
			
            Map[Sharks[i][0]][Sharks[i][1]] = Sharks[i][4];		// 주어진 조건 상 최초 입력에는 겹치는 상어 없음
		}
		
		for (int i = 0; i < C; i++) {
            
			// 1. 낚시
			label : for (int j = 0; j < R; j++) {
				if (Map[j][i] != 0) {					// 기본적으로 Map에는 0이 저장되는데 아닌 위치만 확인
					for  (int sh = 0 ; sh < Sharks.length ; sh++) {
						if (Sharks[sh][4] == Map[j][i]) {
							result += Sharks[sh][4];
							Sharks[sh][4] = 0;
							Map[j][i] = 0;				// 상어를 잘 잡았는지 확인을 위한 코드 (실제로 사용X)
							break label;
						}
					}
				}
			}
            
			// Map 초기화
			Map = new int[R][C];
            
			// 2. 상어의 움직임
			for (int j = 0; j < Sharks.length; j++) {
				if (Sharks[j][4] != 0) {
					
					int Si = (Sharks[j][0] + (dirY[Sharks[j][3]] * Sharks[j][2])) % ((R - 1) * 2);
					int Sj = (Sharks[j][1] + (dirX[Sharks[j][3]] * Sharks[j][2])) % ((C - 1) * 2);
					
                    // 변화량만큼 더하기
					Sharks[j][0] = Math.abs((Sharks[j][0] + (dirY[Sharks[j][3]] * Sharks[j][2])) % ((R - 1) * 2)); 
					Sharks[j][1] = Math.abs((Sharks[j][1] + (dirX[Sharks[j][3]] * Sharks[j][2])) % ((C - 1) * 2));
					
					// 방향 바꾸기
					if (dirY[Sharks[j][3]] * Sharks[j][2] != 0) {
						if (Si  <= -(R - 1)) {
							Sharks[j][3] = 0;
							Sharks[j][0] = ((R - 1) * 2) - Sharks[j][0];
						} else if (Si < 0) {
							Sharks[j][3] = 1;
						} else if (Si <= R - 1) {
							Sharks[j][3] = Sharks[j][3];
						} else if (Si <= (R - 1) * 2) {
							Sharks[j][3] = 0;
							Sharks[j][0] = ((R - 1) * 2) - Sharks[j][0];
						} else {
							Sharks[j][3] = 1;
							Sharks[j][0] = Sharks[j][0] - ((R-1) * 2);
						}
					} else {
						if (Sj  <= -(C - 1)) {
							Sharks[j][3] = 3;
							Sharks[j][1] = ((C-1) * 2) - Sharks[j][1];
						} else if (Sj < 0) {
							Sharks[j][3] = 2;
						} else if (Sj < C - 1) {
							Sharks[j][3] = Sharks[j][3];
						} else if (Sj < (C - 1) * 2) {
							Sharks[j][3] = 3;
							Sharks[j][1] = ((C-1) * 2) - Sharks[j][1];
						} else {
							Sharks[j][3] = 2;
							Sharks[j][1] = Sharks[j][1] - ((C-1) * 2);
						}
					}
					
					// 최종 위치에 가장 무게가 높은 상어의 크기를 넣어줌
					Map[Sharks[j][0]][Sharks[j][1]] = Math.max(Map[Sharks[j][0]][Sharks[j][1]], Sharks[j][4]);
				}
			}
			
			// 3. 한 지점에 나보다 무게가 큰 상어가 있는지 확인
			for (int j = 0; j < Sharks.length; j++) {
				if (Sharks[j][4] != Map[Sharks[j][0]][Sharks[j][1]]) {
					Sharks[j][4] = 0;
				}
			}
		}
		System.out.println(result);
		br.close();
	}
}