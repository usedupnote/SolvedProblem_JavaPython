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
		
		int result = (N + 1) * (N / 2) + (((N / 2) + 1) * (N % 2));
		
		
		System.out.println(result);
	}
}