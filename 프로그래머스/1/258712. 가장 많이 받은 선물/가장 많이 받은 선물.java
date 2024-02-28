import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
    	int friend_length = friends.length;
    	
    	int[][] map = new int[friend_length][friend_length];
    	
    	Map<String, int[]> friendMap = new HashMap<String, int[]>();
    	
    	for (int i = 0; i < friend_length; i++) {
			friendMap.put(friends[i], new int[] {i, 0});
		}
    	
    	int gift_length = gifts.length;
    	for (int i = 0; i < gift_length; i++) {
    		String[] gift = gifts[i].split("\\s");

    		friendMap.get(gift[1])[1] -= 1;
    		friendMap.get(gift[0])[1] += 1;
    		
    		map[friendMap.get(gift[0])[0]][friendMap.get(gift[1])[0]] += 1;
		}
    	
    	// for (int i = 0; i < friend_length; i++) {
		// 	for (int j = 0; j < friend_length; j++) {
		// 		System.out.print(map[i][j]);
		// 		System.out.print(" ");
		// 	}
		// 	System.out.println();
		// }

    	// for (String friend : friends) {
		// 	System.out.print(friendMap.get(friend)[0] + ", ");
		// 	System.out.println(friendMap.get(friend)[1]);
		// }

        int answer = 0;
    	
    	for (String fromFriend : friends) {
            int compare = 0;

        	for (String toFriend : friends) {
        		int[] from = friendMap.get(fromFriend);
        		int[] to   = friendMap.get(toFriend);

                if (from[0] == to[0]) {
					continue;
				}
        		
                if (map[from[0]][to[0]] > map[to[0]][from[0]]) {
                    compare++;
                } else if (map[from[0]][to[0]] == map[to[0]][from[0]]) {
                    if (friendMap.get(fromFriend)[1] > friendMap.get(toFriend)[1]) {
                        compare++;
                    }
                }
        	}
            if (answer < compare) answer = compare;
		}
    	
        return answer;
    }
}