import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<> ();
        HashMap<String, Integer> msgDic = new HashMap<String, Integer>();
        
        for(int i = 0 ; i < 26 ; i++) msgDic.put(Character.toString((char)('A'+i)), i+1);
                
        for(int i = 0 ; i < msg.length() ; i++) {
            for(int j = i+1 ; j <= msg.length() ; j++) {
                
                if (j == msg.length()) {
                    answerList.add(msgDic.get(msg.substring(i, j)));
                    i = j-1;
                    break;
                }
                
                String msgSubstring = msg.substring(i, j+1);
                int msgResult = msgDic.getOrDefault(msgSubstring, 0);
                
                if (msgResult != 0) continue;
                
                answerList.add(msgDic.get(msg.substring(i, j)));
                msgDic.put(msgSubstring, msgDic.size() + 1);
                i = j-1;
                break;
            }
        }
        
        answer = new int[answerList.size()];
        
        for (int i = 0 ; i < answerList.size() ; i++) answer[i] = answerList.get(i);
        
        return answer;
    }
}