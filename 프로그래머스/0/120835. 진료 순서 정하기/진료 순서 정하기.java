import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o2[0], o1[0]);
            }
        });
        
        for (int i = 0 ; i < emergency.length ; i++) {        
            q.offer(new int[] {emergency[i], i});
        }
        
        int cnt = 1;
        while(!q.isEmpty()){
            int[] poll = q.poll();
            answer[poll[1]] = cnt++;
        }
        
        return answer;
    }
}