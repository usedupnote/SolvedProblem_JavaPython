import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i = 0 ; i < r1 ; i++) {
            double check = Math.sqrt((long)2*i*r1-((long)i*i));
            if (check%1 != 0) check += 1;
            answer -= (long) check;
        }
        
        for(int i = 0 ; i < r2 ; i++) {
            double check = Math.sqrt((long)2*i*r2-((long)i*i))+1;
            answer += (long) check;
        }
        
        return answer *= 4;
    }
}