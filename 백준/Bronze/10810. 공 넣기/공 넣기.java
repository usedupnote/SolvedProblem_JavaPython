package com.SSAFY.cd;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int test_case = 0; test_case < M; test_case++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			int C = Integer.parseInt(st.nextToken());
			
			q.push(new int[] {A,B,C});
		}
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int i = poll[0]; i <= poll[1]; i++) {
				if(num[i] == 0) {
					num[i] = poll[2];
				}
			}
		}
		
		for(int i : num) {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
	}
}