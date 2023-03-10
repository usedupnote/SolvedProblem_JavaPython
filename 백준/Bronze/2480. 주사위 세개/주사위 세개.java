package com.SSAFY.cd;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int result = 0;

		if		(A==B && B==C) result = 10000 + A * 1000;
		else if (A!=B && B!=C && A!=C) {
			result = 100 * Math.max(A, Math.max(B, C));
		}
		else {
			if(A==B) {
				result = 1000 + A * 100;
			} else {
				result = 1000 + C * 100;
			}
		}
		System.out.println(result);
	}
}