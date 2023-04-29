import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        int[] todaySplit = new int[3];
        
        StringTokenizer st = new StringTokenizer(today, ".");
        
        for (int i = 0 ; i < 3 ; i++) {
            todaySplit[i] = Integer.valueOf(st.nextToken());
        }
        
        int lenTerms = terms.length;
        HashMap<Character, Integer> tremsLog = new HashMap<>();
        
        for (int i = 0 ; i < lenTerms ; i++) {
            st = new StringTokenizer(terms[i]);
            tremsLog.put(st.nextToken().charAt(0), Integer.valueOf(st.nextToken()));
        }
        
        int lenPrivacies = privacies.length;
        
        String maximumTerm = null;
        int[] maximumTermSplit = new int[3];
        char type;
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0 ; i < lenPrivacies ; i++) {
            st = new StringTokenizer(privacies[i]);
            
            maximumTerm = st.nextToken();
            type = st.nextToken().charAt(0);
                        
            st = new StringTokenizer(maximumTerm, ".");

            for (int j = 0 ; j < 3 ; j++) {
                maximumTermSplit[j] = Integer.valueOf(st.nextToken());
            }
            
            if (tremsLog.get(type) != null) {
                maximumTermSplit[1] += tremsLog.get(type);
                maximumTermSplit[0] += (maximumTermSplit[1]-1) / 12;
                maximumTermSplit[1]  = (maximumTermSplit[1]) % 12 == 0 ? 12 : (maximumTermSplit[1]) % 12;
            }
            
            if (maximumTermSplit[0] >= todaySplit[0]) {
                if (maximumTermSplit[0] > todaySplit[0]) continue;
                if (maximumTermSplit[1] >= todaySplit[1]) {
                    if (maximumTermSplit[1] > todaySplit[1]) continue;
                    if (maximumTermSplit[2] > todaySplit[2]) continue;
                }
            }
            q.offer(i + 1);
        }
        int answerSize = q.size();
        
        answer = new int[answerSize];
        
        for(int i = 0 ; i < answerSize ; i++) {
            answer[i] = q.poll();
        }
        
        return answer;
    }
}