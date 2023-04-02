import java.io.*;
import java.util.*;

public class Main {
	static int N, result;
	static int[][] Eggs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

        st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//계란의 수를 나타내는 N(1 ≤ N ≤ 8)
		Eggs = new int[N][];
		
		//계란의 내구도와 무게
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int Si = Integer.parseInt(st.nextToken());	//계란의 내구도 Si(1 ≤ Si ≤ 300)
			int Wi = Integer.parseInt(st.nextToken());	//계란의 무게 Wi(1 ≤ Wi ≤ 300)
			
			Eggs[i] = new int[] {Si,Wi};
		}
		result = 0;
		brockenEgg(0, Eggs);
		
		System.out.println(result);
		br.close();
	}

	private static void brockenEgg(int current, int[][] eggs) {
		if (current == N) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (eggs[i][0] <= 0) {
					cnt++;
				}
			}
			result = Math.max(result, cnt);
			return;
		}
		
		if(eggs[current][0] <= 0) {
			brockenEgg(current+1, eggs);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (i == current) continue;
			if (eggs[i][0] <= 0) {
				brockenEgg(current+1, eggs);
			}
			else {
				eggs[i][0] -= eggs[current][1];
				eggs[current][0] -= eggs[i][1];
				brockenEgg(current+1, eggs);
				eggs[i][0] += eggs[current][1];
				eggs[current][0] += eggs[i][1];
			}
		}
	}
}