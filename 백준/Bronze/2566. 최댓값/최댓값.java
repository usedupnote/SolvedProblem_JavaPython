package com.SSAFY.cd;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int[] result = new int[3];
        int N = 0;
        
        for (int i = 0; i < 9; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 9; j++) {
        		N = Integer.parseInt(st.nextToken());
				if(result[0] < N) {
					result[0] = N;
					result[1] = i;
					result[2] = j;
				}
			}
		}
        System.out.println(result[0] + "\n" + (result[1] + 1) + " " + (result[2] + 1));
    }
}