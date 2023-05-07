import java.util.*;

class Solution {
    static int[] percent = {10, 20, 30, 40};
    static int userCnt, emoticonCnt;
    static int[][] usersStatic;
    static int[] emoticonsStatic;
    
    static PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o2[0], o1[0]);
        }
	});
    
    
    static void typeOfEvent(int cnt, int[][] emoticonPercent) {
        if (cnt == emoticonCnt){
            int subs = 0, prices = 0;
            
            for(int[] user : usersStatic) {
                int currentPrice = 0;
                for(int[] emoticon : emoticonPercent) {
                    if(emoticon[0] >= user[0]) {
                        currentPrice += emoticon[1];
                    }
                }
                if(user[1] <= currentPrice){
                    subs++;
                } else {
                    prices += currentPrice;
                }
            }
            
            q.offer(new int[] {subs, prices});
            return;
        }
        
        for (int d = 0; d < 4; d++){
            emoticonPercent[cnt][0] = percent[d];
            emoticonPercent[cnt][1] = emoticonsStatic[cnt] * (100 - percent[d]) / 100;
            
            typeOfEvent(cnt + 1, emoticonPercent);
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer;
        
        userCnt = users.length;
        emoticonCnt = emoticons.length;
        
        usersStatic = users;
        emoticonsStatic = emoticons;
        
        typeOfEvent(0, new int[userCnt][2]);
        answer = q.poll();
        
        return answer;
    }
}