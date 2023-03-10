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
		
		for (int i = 0; i < N; i++) {
			num[i] = i + 1;
		}
		
		for (int test_case = 0; test_case < M; test_case++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			
			while (A < B) {
				num[A] += num[B];
				num[B] = num[A] - num[B];
				num[A] -= num[B];
				A++; B--;
			}
		}
		
		for(int i : num) {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
	}
}