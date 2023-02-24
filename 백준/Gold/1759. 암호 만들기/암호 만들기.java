import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static char[] printChar, saveChar, checkGather = {'a', 'e', 'i', 'o', 'u'};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15) 
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// 다음 줄에는 C개의 문자들이 공백으로 구분되어 주어진다.
		// 주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.
		
		st = new StringTokenizer(br.readLine());
		saveChar = new char[C];
		
		for (int i = 0; i < C; i++) {
			saveChar[i] = st.nextToken().toCharArray()[0];
		}

		Arrays.sort(saveChar);
		
		printChar = new char[L];
		comb(0, 0);
		
        // 암호
            // 서로 다른 L개의 알파벳 소문자들로 구성
		    // 최소 한 개의 모음(a, e, i, o, u)
            // 최소 두 개의 자음으로 구성
		    // 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열
        
        //각 줄에 하나씩, 사전식으로 가능성 있는 암호를 모두 출력한다.
		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {
		if (cnt == L){
			int cntA = 0;
			int cntB = 0;
			
			label : for (int i = 0; i < L; i++) {
				for (char j : checkGather) {
					if(printChar[i] == j) {
						cntA++;
						continue label;
					}
				}
				cntB++;
			}
			if (cntB >= 2 && cntA >= 1) {
				for (int j = 0; j < L; j++) {
					sb.append(printChar[j]);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		for (int i = start; i < C; i++) {
			printChar[cnt] = saveChar[i];
			comb(cnt+1, i+1);
		}
	}

}