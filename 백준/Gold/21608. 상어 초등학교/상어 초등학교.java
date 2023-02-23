import java.io.*;
import java.util.*;

public class Main {
	static int[] dirX = {-1, 0, 1, 0};	// 상 우 하 좌
	static int[] dirY = {0, 1, 0, -1};
	static int[] setScore = {0, 1, 10, 100, 1000};	//(0 : 0 | 1 : 1 | 2 : 10 | 3 : 100 | 4 : 1000)
    static int N, score;
    static int[] student;
    static int[][] map, likeStudent;	
    static PriorityQueue<bestSeat> queue = new PriorityQueue<bestSeat>();
    
    static class bestSeat implements Comparable<bestSeat> {
    	int x, y;
    	int point;
    	int emptySpace;
    	
		public bestSeat(int x, int y, int point, int emptySpace) {
			this.x = x;
			this.y = y;
			this.point = point;
			this.emptySpace = emptySpace;
		}

		@Override
		public int compareTo(bestSeat o1) {
			// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
			if(this.point == o1.point) {
				// 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
				if(this.emptySpace == o1.emptySpace) {
					// 3-1. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸
					if(this.x == o1.x) {
						// 3-2. 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
						return this.y - o1.y;
					} else {
						return this.x - o1.x;
					}
				} else {
					return o1.emptySpace - this.emptySpace;
				}
			} else {
				return o1.point - this.point;
			}
		}
    }
    
    // 학생의 순서는 고정, 규칙을 이용해 정해진 순서대로 학생의 자리를 정하기
	private static void setTable(int stuNum) {
        queue.clear();
		// 한 칸에는 학생 한 명의 자리
        // |r1 - r2| + |c1 - c2| = 1을 만족하는 두 칸이 (r1, c1)과 (r2, c2)를 인접 [상하좌우]
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0) continue;
				
				int empty = 0;
				int friends = 0;

				for (int d = 0; d < 4; d++) {
					int di = i + dirX[d];
					int dj = j + dirY[d];
					
					if(0<=di && di < N && 0<=dj && dj<N) {
						if(map[di][dj] == 0) {
							empty++;
							continue;
						}
						
						for (int k : likeStudent[stuNum]) {
							if(k == map[di][dj]) {
								friends++;
							}
						}
					}
				}
				queue.add(new bestSeat(i,j,friends, empty));
			}
		}
		bestSeat poll = queue.poll();
		map[poll.x][poll.y] = stuNum;
	}
	
	// 학생의 만족도의 총 합
	private static void getScore() {
        // 학생의 만족도 = 인접한 칸에 앉은 좋아하는 학생의 수 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int di = i + dirX[d];
					int dj = j + dirY[d];
					
					if(0<=di && di < N && 0<=dj && dj<N) {

						for (int k : likeStudent[map[i][j]]) {
							if(k == map[di][dj]) {
								cnt++;
								break;
							}
						}
					}
				}
				score += setScore[cnt];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 교실은 N×N 크기의 격자
	    // 첫째 줄에 N이 주어진다.
        N = Integer.parseInt(st.nextToken());
        
        // 학교에 다니는 학생의 수는 N * N명
        student = new int[N * N];
        likeStudent = new int[N * N + 1][4];
        
        // 학생은 1번부터 N2번까지 번호가 매겨져 있고, (r, c)는 r행 c열을 의미
        for (int i = 0; i < N*N; i++) {
        	st = new StringTokenizer(br.readLine());
        	// 학생 순서 입력
        	student[i] = Integer.parseInt(st.nextToken());
            
        	// 그 학생이 좋아하는 학생 정렬
        	for (int j = 0; j < 4; j++) {
				likeStudent[student[i]][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        // 교실의 가장 왼쪽 윗 칸은 (0, 0)이고, 가장 오른쪽 아랫 칸은 (N-1, N-1)
        map = new int[N][N];
        
        for (int i : student) {
        	setTable(i);
		}
        // 이제 학생의 만족도를 구해야 한다.
        score = 0;
        getScore();

        // 첫째 줄에 학생의 만족도의 총 합을 출력한다.
        System.out.println(score);
	}
}