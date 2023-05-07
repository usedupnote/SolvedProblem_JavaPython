import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer;
        
        HashMap<String, Integer> idList = new HashMap<>();
        
        int idListLen = id_list.length;
        
        int[][] map = new int[idListLen][idListLen];
        
        for (int i = 0; i < idListLen; i++) {
            idList.put(id_list[i], i);
		}
        
        int reportLen = report.length;
        int[] reportCnt = new int[idListLen];
        
        for (int i = 0; i < reportLen ; i++) {
            String[] rep = report[i].split(" ");
            
            int x = idList.get(rep[0]);
            int y = idList.get(rep[1]);
            if(map[x][y] == 1) continue;
            reportCnt[y] += 1;
            map[x][y] = 1;
        }
        
        answer = new int[idListLen];
        
        for (int i = 0; i < idListLen; i++) {
            for (int j = 0; j < idListLen; j++) {
                if (map[i][j] == 0 || reportCnt[j] < k) continue;
                answer[i] += 1;
		    }
		}
        
        return answer;
    }
}