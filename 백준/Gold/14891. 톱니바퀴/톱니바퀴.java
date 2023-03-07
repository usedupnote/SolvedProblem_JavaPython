import java.io.*;
import java.util.*;

public class Main {
	static int K;
	static LinkedList<Integer>[] gears;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 상태는 8개의 정수로 이루어져 있고, 12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.
        // 톱니바퀴의 상태
        gears = new LinkedList[5];
        for (int i = 1; i <= 4; i++) {
        	gears[i] = new LinkedList<>();
			char[] ch = br.readLine().toCharArray();
        	for (int j = 0; j < 8; j++) {
				gears[i].add(ch[j] - '0');
			}
		}

        //다섯째 줄에는 회전 횟수 K(1 ≤ K ≤ 100)
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());	// 1 ≤ K ≤ 100
        
        // K개 줄에는 회전시킨 방법
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
        	int numGear = Integer.parseInt(st.nextToken());	// 회전시킨 톱니바퀴의 번호
        	int dirGear = Integer.parseInt(st.nextToken());	// 회전시킨 톱니바퀴의 방향
        	
        	moveGear(numGear, dirGear, new boolean[5]);
		}
        
        //출력
        //총 K번 회전시킨 이후에 네 톱니바퀴의 점수의 합을 출력한다. 점수란 다음과 같이 계산한다.
		//1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
		//2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
		//3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
		//4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
        int cnt = 1;
        int result = 0;
        for (int i = 1; i <= 4; i++) {
        	result += gears[i].get(0) * cnt;
        	cnt *= 2;
		}
        System.out.println(result);
	}

	private static void moveGear(int numGear, int dirGear, boolean[] v) {
    	// 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.
		v[numGear] = true;
		
		// 톱니바퀴 A를 회전할 때, 
		// 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다.
		if (numGear + 1 <= 4 && !v[numGear + 1] && gears[numGear].get(2) != gears[numGear+1].get(6)) {
			moveGear(numGear + 1, dirGear * (-1), v);
		}
		
		if (0 < numGear - 1 && !v[numGear - 1] && gears[numGear-1].get(2) != gears[numGear].get(6)) {
			moveGear(numGear - 1, dirGear * (-1), v);
		}
		
		if(dirGear != 1) {
			gears[numGear].addLast(gears[numGear].pollFirst());
		} else {
			gears[numGear].addFirst(gears[numGear].pollLast());
		}
        // 2번이 회전하기 때문에, 3번도 동시에 시계 방향으로 회전하게 된다. 4번은 3번이 회전하지만, 맞닿은 극이 같기 때문에 회전하지 않는다.
	}
}