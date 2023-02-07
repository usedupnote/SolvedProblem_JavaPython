import java.io.*;
import java.util.*;

public class Main {
	static int result;
	static StringBuilder sb = new StringBuilder();
	
	static void hanoi (int n, int from, int mid, int to) {
		if(n == 0) {
			return;
		} else {
			result+=1;
			hanoi(n-1, from, to, mid);
			sb.append(from + " " + to + "\n");
			hanoi(n-1, mid,from,to);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 입출력을 위한 기본 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 스위치 상태 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		hanoi(N, 1, 2, 3);
		
		System.out.println(result + "\n" + sb.toString());
	}
}