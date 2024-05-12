import java.util.*;

class Solution {
    static class StageState {
        int pos, failedPersons, persons;
        
        StageState(int pos, int failedPersons, int persons) {
            this.pos = pos;
            this.failedPersons = failedPersons;
            this.persons = persons;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageList = new int[N+2];
        
        int lenStage = stages.length;
        
        for(int stage : stages) stageList[stage] += 1;
        
        PriorityQueue<StageState> q = new PriorityQueue<>(new Comparator<StageState>() {
            @Override
            public int compare(StageState s1, StageState s2) {
                if (1.0 * s1.failedPersons/s1.persons > 1.0 * s2.failedPersons/s2.persons) {
                    return -1;
                }
                else if (1.0 * s1.failedPersons/s1.persons == 1.0 * s2.failedPersons/s2.persons) {
                    return Integer.compare(s1.pos, s2.pos);
                }
                return 1;
            }
        });
        
        for(int i = 1 ; i <= N ; i++) {
            if(lenStage == 0) {
                q.offer(new StageState(i, 0, 1));
                continue;
            }
            q.offer(new StageState(i, stageList[i], lenStage));
            lenStage -= stageList[i];
        }
        
        int cnt = 0;
        while(!q.isEmpty()){
            answer[cnt++] = q.poll().pos;
        }
        
        return answer;
    }
}