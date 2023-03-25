import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	int d = Integer.parseInt(st.nextToken());
    	int e = Integer.parseInt(st.nextToken());
    	int f = Integer.parseInt(st.nextToken());
    	
    	for (int i = 0; i <= 999; i++) {
    		for (int j = -1; j < 2; j+=2) {
				for (int k = 0; k <= 999; k++) {
					for (int l = -1; l < 2; l+=2) {
						if((a*i*j) + (b*k*l) == c) {
							if((d*i*j) + (e*k*l) == f) {
								System.out.println(i*j + " " + k*l);
								return;
							}
						}
					}
				}
			}
		}
    }
}