import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
        
        for(int[] line : lines) {
            q.offer(new int[] {line[0], 1});
            q.offer(new int[] {line[1], -1});
        }
        
        int point = 0;
        int pos = lines[0][0];
        
        while(!q.isEmpty()){
            int[] poll = q.poll();
            
            if(point > 1){
                // System.out.println(answer + " " + poll[0] + " " + pos + " " + (poll[0] - pos));
                answer += poll[0] - pos;
            }
            
            point += poll[1];
            pos = poll[0];
        }
        
        return answer;
    }
}