import java.io.*;
import java.util.*;
 
public class Solution {
    static StringBuilder sb = new StringBuilder();
	static int N, R, C;
	static int x, y;
	static LinkedList<Integer> password;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        start : for (int test_case = 1; test_case <= 10; test_case++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            
        	password = new LinkedList<Integer>();
            
        	st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
            	password.offer(Integer.parseInt(st.nextToken()));
			}
            

            st = new StringTokenizer(br.readLine());

            C = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());

            while (true) {
            	if(!st.hasMoreTokens()) {
            		sb.append("#" + test_case + " ");
            		for (int i = 0; i < 10; i++) {
                		sb.append(password.poll() + " ");
					}
            		sb.append("\n");
            		continue start;
            	}

        		String str = st.nextToken();
            	if(str.equals("I")) {
            		x = Integer.parseInt(st.nextToken());
            		y = Integer.parseInt(st.nextToken());
            	} else {
            		password.add(x++, Integer.parseInt(str));
            	}
            	//R =  Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(sb);
        br.close();
    }
}