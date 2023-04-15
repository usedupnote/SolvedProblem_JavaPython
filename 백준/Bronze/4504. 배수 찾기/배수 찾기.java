import java.io.*;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Main {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T 가 주어지고,
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		int N = 0;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//( 6 ≤ N ≤ 20 )
			if(N == 0) break;
			
			sb.append(N);

			if(N % T == 0) 	sb.append(" is a multiple of ");
			else			sb.append(" is NOT a multiple of ");
			
			sb.append(T + ".\n");
		}
		System.out.println(sb);
		br.close();
	}
}