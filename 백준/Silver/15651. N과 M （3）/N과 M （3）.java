import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static ArrayList<Integer> arr = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	static void NandM(int b) {
		for (int i = 0; i < N; i++) {
			if (b > 0) {
				arr.add(i + 1);
				NandM(b-1);
				arr.remove(arr.size() - 1);
			} else {
				sb.append(arr.toString().replace("[", "").replace(",", "").replace("]", "") + "\n");
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 입출력을 위한 기본 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 자연수 N과 M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		NandM(M);
		
		System.out.println(sb.toString());
	}
}