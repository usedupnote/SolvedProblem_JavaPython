import java.io.*;
import java.util.*;

public class Main {
	static private final Map<String, int[]> cmdItems = new HashMap<String, int[]>() {
        {
            put("R", new int[] {1,0});
            put("L", new int[] {-1,0});
            put("B", new int[] {0,-1});
            put("T", new int[] {0,1});
            put("RT", new int[] {1,1});
            put("LT", new int[] {-1,1});
            put("RB", new int[] {1,-1});
            put("LB", new int[] {-1,-1});
        }
    };
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        char[] king = st.nextToken().toCharArray();
        char[] stone = st.nextToken().toCharArray();
        int N = Integer.parseInt(st.nextToken());
        
        int[] kingPos = new int[] {king[0] - 'A', Character.getNumericValue(king[1])-1};
        int[] stonePos = new int[] {stone[0] - 'A', Character.getNumericValue(stone[1])-1};
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] cmd = cmdItems.get(st.nextToken());

            int[] tempKing = new int[] {kingPos[0] + cmd[0], kingPos[1] + cmd[1]};
            int[] tempStone = new int[] {stonePos[0] + cmd[0], stonePos[1] + cmd[1]};
            
            if (0<=tempKing[0] && tempKing[0]<8 && 0<=tempKing[1] && tempKing[1]<8) {
            	if (tempKing[0] == stonePos[0] && tempKing[1] == stonePos[1]) {
            		if (0<=tempStone[0] && tempStone[0]<8 && 0<=tempStone[1] && tempStone[1]<8) {
            			stonePos = tempStone.clone();
            		} else {
            			continue;
            		}
				}
            	kingPos = tempKing.clone();
			}
		}

        sb.append((char)(kingPos[0] + 'A')).append(kingPos[1]+1).append("\n");
        sb.append((char)(stonePos[0] + 'A')).append(stonePos[1]+1);
        
        System.out.print(sb);
        
        br.close();
    }
}