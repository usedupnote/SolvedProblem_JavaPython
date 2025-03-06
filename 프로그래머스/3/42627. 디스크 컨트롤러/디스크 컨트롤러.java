import java.util.*;

class Solution {
    private static class Work {
        int durationTime;  // 작업 소요시간
        int inputTime;     // 작업 요청시간
        int inputNumber;   // 작업 번호
        
        public Work(int durationTime, int inputTime, int inputNumber) {
            this.durationTime = durationTime;
            this.inputTime = inputTime;
            this.inputNumber = inputNumber;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int jobsLen = jobs.length;
        
        // 대기 큐 (작업)
		PriorityQueue<Work> prepareWork = new PriorityQueue<>(new Comparator<Work>() {
			@Override
			public int compare(Work o1, Work o2) {
                return Integer.compare(o1.inputTime, o2.inputTime);
            }
		});
        
        // 작업 시간순 정렬
        for(int i = 0 ; i < jobsLen ; i++) {
            prepareWork.offer(new Work(jobs[i][1], jobs[i][0], i));
        }
        
        // 대기 큐
		PriorityQueue<Work> prepareQueue = new PriorityQueue<>(new Comparator<Work>() {
			@Override
			public int compare(Work o1, Work o2) {
                if(o1.durationTime == o2.durationTime) {
                    if(o1.inputTime == o2.inputTime) {
                        return Integer.compare(o1.inputNumber, o2.inputNumber);
                    }
                    return Integer.compare(o1.inputTime, o2.inputTime);
                }
                return Integer.compare(o1.durationTime, o2.durationTime);
            }
		});
        
        prepareQueue.offer(prepareWork.poll());
        int curTime = prepareQueue.peek().inputTime;
            
        while(!prepareWork.isEmpty() && prepareWork.peek().inputTime <= curTime) {
            prepareQueue.offer(prepareWork.poll());
            System.out.println(prepareQueue.peek().durationTime);
        }
        
        while(!prepareQueue.isEmpty()) {
            Work peek = prepareQueue.peek();
            
            curTime = (peek.inputTime>curTime?peek.inputTime:curTime) + peek.durationTime;
            answer += curTime - peek.inputTime;
            prepareQueue.poll();
            
            if(prepareQueue.isEmpty() && !prepareWork.isEmpty()) {
                curTime = curTime>prepareWork.peek().inputTime?curTime:prepareWork.peek().inputTime;
            }
            
            while(!prepareWork.isEmpty() && prepareWork.peek().inputTime <= curTime) {
                prepareQueue.offer(prepareWork.poll());
                System.out.println(prepareQueue.peek().durationTime);
            }
        }
		
        return answer/jobsLen;
    }
}