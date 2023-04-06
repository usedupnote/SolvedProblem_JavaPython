import java.io.*;
import java.util.*;

public class Solution {
	static int[] dirX = {-1, 1, 0, 0};	// 상 하 좌 우
	static int[] dirY = {0, 0, -1, 1};
	static int N, coreCnt;
	/**
	 * result[0] = 연결된 코어 갯수
	 * result[1] = 연결된 코어 길이
	 * */
	static int[] result;
	static int[][] map;
	static int[][] cores;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    int T = Integer.parseInt(st.nextToken());
	    
	    for (int TC = 1; TC <= T; TC++) {
	    	st = new StringTokenizer(br.readLine());
	    	N = Integer.parseInt(st.nextToken());	//7 ≤  N ≤ 12
	    	
	    	map = new int[N][N];
	    	cores = new int[12][2];
	    	coreCnt = 0;
	    	result = new int[] {0,0};
	    	
	    	for (int i = 0; i < N; i++) {
	    		st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					//초기 상태로는 아래와 같이 전선을 연결하기 전 상태의 멕시노스 정보가 주어진다.
					map[i][j] = Integer.parseInt(st.nextToken());
					//(멕시노스의 가장자리에 위치한 Core는 이미 전원이 연결된 것으로 간주한다.)
					if(map[i][j] == 0) continue;
					if(i*j==0 || i==N-1 || j==N-1) continue;
					cores[coreCnt  ][0] = i;
					cores[coreCnt++][1] = j;// 1 <= Core의 개수 <= 12
				}
			}
	    	check = new boolean[coreCnt];

	    	comb(0,0,0,map);
	    	
	    	sb.append("#").append(TC).append(" ").append(result[1]).append("\n");
		}

	    //최대한 많은 Core에 전원을 연결하였을 경우, 전선 길이의 합을 구하고자 한다.
		//   단, 여러 방법이 있을 경우, 전선 길이의 합이 최소가 되는 값을 구하라.
		//위 예제의 정답은 12가 된다.
		// 최대한 많은 Core에 전원을 연결해도, 전원이 연결되지 않는 Core가 존재할 수 있다.

		//각 테스트 케이스마다 '#X'를 찍고, 한 칸 띄고, 정답을 출력한다.
	    System.out.println(sb);
	    br.close();
	}
	private static void comb(int count, int checkCnt, int current, int[][] v) {

		if(current == coreCnt) {	// 코어 갯수만큼 돌았을 때
			if(result[0] < count) {
				result[0] = count;
				result[1] = checkCnt;
			}
			else if(result[0] == count) {
				if(result[1] >= checkCnt) {
					result[1] = checkCnt;
				}
			}
			
			return;
		}
		
		if(result[0] > (coreCnt-current) + count) return;
		
		for (int i = current; i < coreCnt; i++) {
			if (check[i])continue;
			
			int x = cores[i][0];
			int y = cores[i][1];
			// 사방탐색하고 쭉 가서 벽에 닿으면 check해주고, 결과값 늘려줌
			int dx, dy;
			
			for (int d = 0; d < 4; d++) {
				dx = x;
				dy = y;
				int countWire = 0;
				int[][] copyMap = new int[N][N];
				
				for (int j = 0; j < N; j++) {
					copyMap[j] = v[j].clone();
				}
				
				while (true) {
					dx = dx + dirX[d];
					dy = dy + dirY[d];
					
					if(0<=dx && dx<N && 0<=dy && dy<N) {
						// 맵 안에서 다음 갈 곳이 0이 아닌 경우 (비지 않았을 때)
						if(copyMap[dx][dy] != 0) break;
						copyMap[dx][dy] = 2;
						countWire++;
					} else {
						check[i] = true;
						comb(count+1, checkCnt+countWire, i+1, copyMap);
						check[i] = false;
						break;
					}
				}
			}
		}
		comb(count, checkCnt, current+1, v);
	}
}