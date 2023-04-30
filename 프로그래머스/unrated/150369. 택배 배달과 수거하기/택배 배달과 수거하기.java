
import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int deliveriePeeker = n-1;
        int pickupPeeker    = n-1;
        
        while (deliveriePeeker >= 0 || pickupPeeker >= 0) {
            int max = -1;
            
            int deliverieCap = cap;
            int pickupCap    = cap;
            
            while (deliveriePeeker >= 0) {
                if(deliveries[deliveriePeeker] != 0){
                    max = Math.max(max, deliveriePeeker);
                    if(deliveries[deliveriePeeker] >= deliverieCap) {
                        deliveries[deliveriePeeker] -= deliverieCap;
                        deliverieCap = 0;
                        break;
                    } else {
                        deliverieCap -= deliveries[deliveriePeeker];
                        deliveries[deliveriePeeker] = 0;
                    }
                }
                deliveriePeeker--;
            }
            
            while (pickupPeeker >= 0) {
                if(pickups[pickupPeeker] != 0){
                    max = Math.max(max, pickupPeeker);
                    
                    if(pickups[pickupPeeker] >= pickupCap) {
                        pickups[pickupPeeker] -= pickupCap;
                        pickupCap = 0;
                        break;
                    } else {
                        pickupCap -= pickups[pickupPeeker];
                        pickups[pickupPeeker] = 0;
                    }
                }
                pickupPeeker--;
            }
            answer += ((max + 1) * 2);
        }
        
        return answer;
    }
}