import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        
        q.offer(5);
        
        ArrayList<Integer> al = new ArrayList<>();
        
        while(!q.isEmpty()){
            int poll = q.poll();
            if (poll > r) break;
            if (poll >= l) al.add(poll);
            q.offer(poll*10);
            q.offer(poll*10 + 5);
        }
        if(al.size() == 0) {
            answer = new int[] {-1};
        } else {
            answer = new int[al.size()];
            for(int i = 0 ; i < answer.length ; i++){
                answer[i] = al.get(i);
            }
        }
        return answer;
    }
}