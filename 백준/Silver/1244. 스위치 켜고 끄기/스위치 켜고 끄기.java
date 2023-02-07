import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int student;
	static int gender, position;
	static int[] toggle;
	
	static void man(int P) {
		int pos = P;
		
		while (pos <= N) {
			toggle[pos] = (toggle[pos] + 1)%2;
			pos += P;
		}
	}
	
	static void women(int P) {
		toggle[P] = (toggle[P] + 1) % 2;
		
		int posF = P + 1;
		int posL = P - 1;
		
		while (posF <= N && posL > 0) {
			if(toggle[posF] == toggle[posL]) {
				toggle[posF] = (toggle[posF++] + 1) % 2;
				toggle[posL] = (toggle[posL--] + 1) % 2;
				continue;
			}
			break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 스위치 상태 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		toggle = new int[N+1];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			toggle[i] = Integer.parseInt(st.nextToken());
		}

		// 학생 수 입력
		st = new StringTokenizer(br.readLine());
		
		student = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < student ; i++) {
			st = new StringTokenizer(br.readLine());
			
			gender = Integer.parseInt(st.nextToken());
			position = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				man(position);
			} else {
				women(position);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(toggle[i] +" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}