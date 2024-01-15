class Solution {
    public int solution(String[] order) {
        int len = order.length;
        int answer = len * 4500;
        
        for(String s : order) {
            if (s.contains("cafelatte")) {
                answer += 500;
                continue;
            }
    	}
        
        return answer;
    }
}