import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o2[0], o1[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        for(int i : numlist) q.offer(new int[] {i, Math.abs(i - n)});
        
        int pos = 0;
        while(!q.isEmpty()) answer[pos++] = q.poll()[0];
        
        return answer;
    }
}