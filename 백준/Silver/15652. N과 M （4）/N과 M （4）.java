import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] num;
	
	static void NandM(int a, int start) {
		if (a == 0) {
			System.out.println(Arrays.toString(num).replace("[", "").replace(",", "").replace("]", ""));
			return;
		}
		for (int i = start; i < N; i++) {
			num[M - a] = i + 1;
			NandM(a - 1, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 입출력을 위한 기본 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 자연수 N과 M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[M];
		
		NandM(M, 0);
	}
}