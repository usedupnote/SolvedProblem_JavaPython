import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken()) * 2;
		int C = Integer.parseInt(st.nextToken()) * 3;
		int[] score = new int[] {0,A,B,C};
		
		int price = 0;
		int[] time = new int[101];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int sta = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for (int j = sta; j < end; j++) {
				time[j]++;
			}
		}
		for (int i = 0; i < 101; i++) {
			price += score[time[i]];
		}
		System.out.println(price);
        br.close();
	}
}