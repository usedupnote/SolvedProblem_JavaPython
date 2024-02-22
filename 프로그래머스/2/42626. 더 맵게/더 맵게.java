import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
    	PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});
        
        for(int i:scoville) {
            pq.offer(i);
        }
        
        while (pq.size() > 1) {
            if (pq.peek() >= K) break;
            answer++;
            int fPoll = pq.poll();
            int sPoll = pq.poll();
            pq.offer(fPoll + (sPoll * 2));
        }
        
    	if (pq.size() < 2 && pq.peek() < K) return answer = -1;
        return answer;
    }
}