import java.io.*;
import java.util.*;

public class Main {
	static boolean check;
	static int N;
	static int L;
	static int R;
	static int result;
	static int[][] map;
	static int[][] union;
	static int[][] unionMap;
	
	static void searchUnion(int i, int j) {
		
		if (i != 0) {
			if (unionMap[i][j] != unionMap[i-1][j] && Math.abs(map[i][j] - map[i-1][j]) >= L && Math.abs(map[i][j] - map[i-1][j]) <= R) {
				unionMap[i-1][j] = unionMap[i][j];
				check = true;
				searchUnion(i-1, j);
			}
		}
		
		if (j != 0) {
			if(unionMap[i][j] != unionMap[i][j-1] && Math.abs(map[i][j] - map[i][j-1]) >= L && Math.abs(map[i][j] - map[i][j-1]) <= R) {
				unionMap[i][j-1] = unionMap[i][j];
				check = true;
				searchUnion(i, j-1);
			}
		}

		if (i != N-1) {
			if (unionMap[i][j] != unionMap[i+1][j] && Math.abs(map[i][j] - map[i+1][j]) >= L && Math.abs(map[i][j] - map[i+1][j]) <= R) {
				unionMap[i+1][j] = unionMap[i][j];
				check = true;
				searchUnion(i+1, j);
			}
		}
		
		if (j != N-1) {
			if(unionMap[i][j] != unionMap[i][j+1] && Math.abs(map[i][j] - map[i][j+1]) >= L && Math.abs(map[i][j] - map[i][j+1]) <= R) {
				unionMap[i][j+1] = unionMap[i][j];
				check = true;
				searchUnion(i, j+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		result = 0;
		
		map = new int[N][N];
		union = new int[N * N][2];
		unionMap = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				unionMap[i][j] = (N * i) + j;
			}
		}
		
		while (true) {
			check = false;

			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < N ; j++) {
					searchUnion(i, j);
				}
			}
			
			if (check == false) {
				System.out.println(result);
				break;
			}
			
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < N ; j++) {
					union[unionMap[i][j]][0] += 1;
					union[unionMap[i][j]][1] += map[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = union[unionMap[i][j]][1] / union[unionMap[i][j]][0];
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					unionMap[i][j] = (N * i) + j;
				}
			}
			
			for (int i = 0; i < N*N; i++) {
				union[i][0] = 0;
				union[i][1] = 0;
			}
			result += 1;
		}
	}
}