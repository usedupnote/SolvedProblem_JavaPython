import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int pLen = priorities.length;
        
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        
        for(int prioritie : priorities) q.offer(prioritie);
        
        int pos = 0;
        
        while(!q.isEmpty()) {
            if (priorities[pos] == q.peek()){
                answer++;
                
                if(pos == location) break;
                
                q.poll();
                priorities[pos] = -1;
            }
            pos = (pos + 1) % pLen;
        }
        return answer;
    }
}