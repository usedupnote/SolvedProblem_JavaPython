class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int n = 1 ; n <= number ; n++) {
            int cnt = 1;
            for(int i = 1 ; i < (n / 2) + 1 ; i++) {
                if(n % i == 0) cnt++;
                if(cnt > limit) break;
            }
            if(cnt > limit) answer += power;
            else answer += cnt;
        }
        
        return answer;
    }
}