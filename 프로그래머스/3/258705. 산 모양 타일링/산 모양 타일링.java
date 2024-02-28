import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] tops) {
    	int[] result = new int[] {1, 0};
    	
    	for (int i = 0; i < n; i++) {
			int[] current = new int[2];
			
			if (tops[i] == 0) {
				current[0] += ((result[0] * 2) + result[1]) % 10007;
				current[1] += (result[0] + result[1]) % 10007;
			} else {
				current[0] =  (current[0] + (result[0] * 3) + (result[1] * 2)) % 10007;
				current[1] = (current[1] + result[0] + result[1]) % 10007;
			}
			
			result = current.clone();
		}
    	
        int answer = (result[0] + result[1])%10007;
        return answer;
    }
}