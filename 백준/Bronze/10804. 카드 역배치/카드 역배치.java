import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int[] card = new int[21];
        
        for (int i = 1; i <= 20; i++) {
			card[i] = i;
		}
        
        int start, end;
        
        for (int i = 0; i < 10; i++) {
        	st = new StringTokenizer(br.readLine());
        	start = Integer.parseInt(st.nextToken());
        	end	  = Integer.parseInt(st.nextToken());
        	
        	while (start < end) {
        		card[start] += card[end];
        		card[end] = card[start] - card[end];
        		card[start++] -= card[end--];
			}
		}

        for (int i = 1; i <= 20; i++) {
        	sb.append(card[i] + " ");
        }
        
        System.out.println(sb);
        br.close();
    }
}