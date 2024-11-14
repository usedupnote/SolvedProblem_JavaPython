import java.util.*;

class Solution {
    private boolean checkWalletInBill (int[] wallet, int[] bill) {
        if (Math.min(wallet[0], wallet[1]) >= Math.min(bill[0], bill[1]) && Math.max(wallet[0], wallet[1]) >= Math.max(bill[0], bill[1])) return true;
        return false;
    }
    
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (true) {
            if (checkWalletInBill(wallet, bill)) break;
            answer++;
            if (bill[0] > bill[1]) bill[0] /= 2;
            else bill[1] /= 2;
        }
        
        return answer;
    }
}