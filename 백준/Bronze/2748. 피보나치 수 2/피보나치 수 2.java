<<<<<<< HEAD
package com.SSAFY.cd;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	
    	long[] num = new long[N + 1];
    	
    	for (int i = 0; i <= N; i++) {
			if(i == 0) {
				num[i] = 0;
			} else if (i == 1) {
				num[i] = 1;
			} else {
				num[i] = num[i-1] + num[i-2];
			}
		}
    	
    	System.out.println(num[N]);
	}
=======
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	
    	long[] num = new long[N + 1];
    	
    	for (int i = 0; i <= N; i++) {
			if(i == 0) {
				num[i] = 0;
			} else if (i == 1) {
				num[i] = 1;
			} else {
				num[i] = num[i-1] + num[i-2];
			}
		}
    	System.out.println(num[N]);
	}
>>>>>>> 6a478f6bfe213942b57a00a2cb12d6159551f101
}