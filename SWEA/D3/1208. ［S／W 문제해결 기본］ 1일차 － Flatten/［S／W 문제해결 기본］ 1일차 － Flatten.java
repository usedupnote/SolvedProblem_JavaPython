import java.io.*;
import java.util.*;
 
public class Solution {
    static int highN;
    static int lowN;
    static int high, low;
    static int[] height;
     
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 기본 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int test_case = 1; test_case <= 10; test_case++) {
        	height = new int[101];
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	highN = Integer.parseInt(st.nextToken());
        	lowN = highN;
        	
        	st = new StringTokenizer(br.readLine());
        	
        	for (int i = 0; i < 100; i++) {
				height[Integer.parseInt(st.nextToken())] += 1;
			}
        	
        	high = 100;
        	low = 0;
        	
        	while (highN >= 0) {
        		height[high-1] += height[high];
        		highN -= height[high--];
        		
        	}
        	
        	while (lowN >= 0) {
        		height[low+1] += height[low];
        		lowN -= height[low++];
        	}
        	
        	high++;
        	low--;
        	
            sb.append("#" + test_case + " "+(high - low <= 0 ? 0 : high - low) + "\n");
        }
        System.out.println(sb.toString());
    }
}