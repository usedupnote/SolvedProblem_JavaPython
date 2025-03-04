import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        ArrayList<Deque<Integer>> q = new ArrayList<>();
        
        for(int i=0 ; i<=n ; i++) {
            q.add(new LinkedList<>());
        }
        
        for(int[] road : roads) {
            q.get(road[0]).add(road[1]);
            q.get(road[1]).add(road[0]);
        }
        
        int[] v = new int[n+1];
        
        v[destination] = 1;
        Deque<Integer> dq = new LinkedList<>();
        dq.add(destination);
        while(!dq.isEmpty()) {
            int poll = dq.poll();
            while(!q.get(poll).isEmpty()) {
                int cur = q.get(poll).poll();
                if (v[cur] == 0) {
                    v[cur] = v[poll] + 1;
                    dq.add(cur);
                }
            }
        }
        
        for(int i = 0 ; i < sources.length ; i++) {
            answer[i] = v[sources[i]]-1;
        }

        return answer;
    }
}