import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//온도를 측정한 전체 날짜의 수 (2이상, 100이하)
		int K = Integer.parseInt(st.nextToken());	//K는 합을 구하기 위한 연속적인 날짜의 수 (1과 N 사이의 정수)
		//매일 측정한 온도 (-100이상, 100이하)
		
		int[] degree = new int[N+1];
		st = new StringTokenizer(br.readLine());
		degree[1] = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= N; i++) {
			degree[i] = Integer.parseInt(st.nextToken()) + degree[i-1];
		}
		
		int result = Integer.MIN_VALUE;
		for (int i = K; i <= N; i++) {
			result = Math.max(result, degree[i] - degree[i-K]);
		}
		System.out.println(result);
	}
}