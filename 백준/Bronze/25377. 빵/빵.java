package com.SSAFY.cd;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int result = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            if(A <= B && result > B) {
        		result = B;
            }
		}
        System.out.println(result == Integer.MAX_VALUE ? -1:result);
    }
}