import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] ch1 = br.readLine().toCharArray();
		char[] ch2 = br.readLine().toCharArray();
		
		int lenCh1 = ch1.length;
		int lenCh2 = ch2.length;
		
		int result = 0;
		
		int[][] map = new int[lenCh1+1][lenCh2+1];
		
		// ch 1에 대해서 ch2를 다 돌면서 길이 분석		
		for (int i = 0; i < lenCh1; i++) {
			for (int j = 0; j < lenCh2; j++) {
				if (ch1[i] == ch2[j]) {
					map[i+1][j+1] = map[i][j] + 1;
					result = Math.max(result, map[i+1][j+1]);
				}
			}
		}
		System.out.println(result);
		br.close();
	}
}