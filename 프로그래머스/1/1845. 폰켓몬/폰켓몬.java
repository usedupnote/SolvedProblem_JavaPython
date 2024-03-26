import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        HashSet<Integer> numSet = new HashSet<>();
        for(int i : nums) numSet.add(i);
        answer = Math.min(numSet.size(), answer);
        return answer;
    }
}