import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] text    = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		ArrayDeque<Integer>	q = new ArrayDeque<>();
		
		int tLength = text.length, pLength = pattern.length;
		
		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){
	        while(j > 0 && pattern[i] != pattern[j]) j = pi[j-1]; 
	        if(pattern[i] == pattern[j]) pi[i] = ++j;
	        else pi[i] = 0;
	    }
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0,j=0; i<tLength; ++i) { 			
			while(j>0 && text[i] != pattern[j]) j = pi[j-1]; 
			
			if(text[i] == pattern[j]) {
				if(j == pLength-1) {
					q.offer(i-j+1);
					j=pi[j]; 
				}else { 
					j++;
				}
			}
		}
		sb.append(q.size()+"\n");
		
		while (!q.isEmpty()) {
			sb.append(q.poll()+ " ");
		}
		
		System.out.println(sb);
	}
}