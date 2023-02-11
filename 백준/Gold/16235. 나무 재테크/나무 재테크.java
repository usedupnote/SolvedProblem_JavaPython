import java.io.*;
import java.util.*;

public class Main {
	// 상도는 나무 재테크로 더 큰 돈을 벌기 위해 M개의 나무를 구매해 땅에 심었다.
	// 같은 1×1 크기의 칸에 여러 개의 나무가 심어져 있을 수도 있다.
	static int N, M, K;				// N : 땅의 크기, M : 나무의 개수, K : 시뮬레이션 횟수
	static int[] posi = {0,1,1,1,0,-1,-1,-1};			// 상 상우 우 우하 하 좌하 좌 좌상
	static int[] posj = {-1,-1,0,1,1,1,0,-1};
	static int[][] map;				// map : 지금 양분 상태를 저장
	static int[][] nutritionMap;	// nutritionMap : 겨울마다 추가할 양분을 저장
	static ArrayDeque<int[]> trees = new ArrayDeque<>(); 	// tree : 나무의 갯수를 저장

	static void season() {
		// 1. 봄 시작
		// 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다. 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다.
		// 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
		// 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
		if (trees.size() == 0) return;
		
		int treesNumInThisSeason = trees.size();			// 나무의 갯수를 저장

		ArrayDeque<int[]> liveTrees = new ArrayDeque<>(); 	// liveTrees : 죽은 나무 저장
		ArrayDeque<int[]> deadTrees = new ArrayDeque<>(); 	// deadTrees : 죽은 나무 저장
		
		for (int i = 0; i < treesNumInThisSeason; i++) {
			int[] checker = trees.poll();
			if (map[checker[0]][checker[1]] >= checker[2]) {
				map[checker[0]][checker[1]] -= checker[2];
				checker[2] += 1;
				liveTrees.offer(checker);
			} else {
				deadTrees.offer(checker);
			}
		}
		
		for (int[] i : liveTrees) {
			trees.offer(i);
		}
		// -- 봄 끝

		// 2. 여름 시작
		if (deadTrees.size() != 0) {
			for (int[] i : deadTrees) {
				// 여름에는 봄에 죽은 나무가 양분으로 변하게 된다. 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점 아래는 버린다.
				map[i[0]][i[1]] += i[2] / 2;
			}
		}
		// -- 여름 끝
		
		if (trees.size() == 0) return;
		
		// 가을 시작

		ArrayDeque<int[]> A = new ArrayDeque<>(); 	// liveTrees : 죽은 나무 저장
		treesNumInThisSeason = trees.size();			// 나무의 갯수를 저장
		// 가을에는 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며, 
		// 인접한 8개의 칸에 나이가 1인 나무가 생긴다.상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
		for (int i = 0; i < treesNumInThisSeason; i++) {
			int[] checker = trees.poll();
			
			if (checker[2] % 5 == 0) {
				for (int j = 0; j < 8; j++) {
					int di = checker[0] + posi[j];
					int dj = checker[1] + posj[j];
					if (di >= 0 && di < N  && dj >= 0 && dj < N) {
						trees.offer(new int[] {di, dj, 1});
					}
				}
			}
			A.offer(checker);
		}

		for (int[] i : A) {
			trees.offer(i);
		}
		// -- 가을 끝
		
		if (trees.size() == 0) return;
		
		// 겨울 시작
		// 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다.
		// 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += nutritionMap[i][j];
			}
		}
		// -- 겨울 끝
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기 값들 설정
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 땅 관련 값들 설정
		map = new int[N][N];
		nutritionMap = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				nutritionMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기 나무 값들 설정
		
		for (int i = 0; i < M; i++) {
			int[] tree = new int[3];
			st = new StringTokenizer(br.readLine());
			tree[0] = Integer.parseInt(st.nextToken()) - 1;
			tree[1] = Integer.parseInt(st.nextToken()) - 1;
			tree[2] = Integer.parseInt(st.nextToken());
			
			trees.offer(tree);
		}
		
		// K년이 지난 후 상도의 땅에 살아있는 나무의 개수를 구하는 프로그램을 작성하시오.
		for (int i = 0; i < K; i++) {
			season();
		}
		
		System.out.println(trees.size());
	}
}