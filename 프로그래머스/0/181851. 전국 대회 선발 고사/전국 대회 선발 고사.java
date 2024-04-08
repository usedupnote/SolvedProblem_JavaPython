import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        
        for(int i = 0 ; i < rank.length ; i++) {
            if (attendance[i]) q.offer(new int[] {rank[i], i});
        }
        
        for(int i = 2 ; i >= 0 ; i--){
            int poll = q.poll()[1];
            for(int j = 0 ; j < i ; j++) poll *= 100;
            answer += poll;
        }
        
        return answer;
    }
}