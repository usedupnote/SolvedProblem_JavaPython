import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static boolean[] check;
	static ArrayList<Integer> arr = new ArrayList<>();
	
	static void NandM(int a, int b) {
		for (int i = a; i <= N-b; i++) {
			if (b > 0) {
				if(check[i] == false) {
					arr.add(i + 1);
					check[i] = true;
					NandM(i, b-1);
					arr.remove(arr.size() - 1);
					check[i] = false;
				}
			} else {
				System.out.println(arr.toString().replace("[", "").replace(",", "").replace("]", ""));
				break;
			}
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
		
		check = new boolean[N];

		NandM(0, M);
	}
}