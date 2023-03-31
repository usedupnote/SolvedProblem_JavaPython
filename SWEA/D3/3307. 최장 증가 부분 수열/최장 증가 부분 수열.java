import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int TC = 1; TC <= T; TC++) {
			//각 테스트 케이스의 첫째 줄에는 수열의 길이 N(1≤N≤1,000)이 주어진다. 
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
					
			long[] LIS = new long[N];
			int temp = 0;
			int max = 0;
			
			//둘째 줄에는 수열의 원소 N개가 공백을 사이에 두고 순서대로 주어진다.
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				long current = Long.parseLong(st.nextToken());
				temp = Arrays.binarySearch(LIS, 0, max, current);
				if(temp < 0) temp = Math.abs(temp) - 1;
				LIS[temp] = current;
				if(max == temp) max++;
			}
			//각 테스트 케이스마다 ‘#T’(T는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 최대 증가 부분 수열의 길이를 출력한다.
			sb.append("#" + TC + " " + max + "\n");
		}
		//각 수열의 원소는 1 이상 231-1 이하의 자연수이다.
		
		System.out.println(sb);
	}
}