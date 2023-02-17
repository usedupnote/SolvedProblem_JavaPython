import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// belt 설정
		int[] belt = new int[N * 2];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N * 2; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		int startPoint = 0;
		int endPoint   = N;
		boolean[] robot = new boolean[N*2];
		
		while (K > 0) {
			result++;
			// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			if (--startPoint < 0) startPoint = N * 2 - 1;
			if (--endPoint   < 0) endPoint   = N * 2 - 1;
			
			// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
			//    2-1. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
			
			int checkPoint = endPoint;
			int nextPoint = (checkPoint + 1) % (N * 2);

			robot[endPoint - 1 < 0?2 * N - 1:endPoint - 1] = false;
			
			while (startPoint != checkPoint) {
				checkPoint--;
				nextPoint--;
				if(checkPoint < 0) {
					checkPoint = (N * 2) - 1;
				} else if (nextPoint < 0) {
					nextPoint = (N * 2) - 1;
				}
				
				if (belt[nextPoint] == 0||!robot[checkPoint] || robot[nextPoint])  continue;
				
				robot[nextPoint] = true;
				robot[checkPoint] = false;
				belt[nextPoint] -= 1;
				if(belt[nextPoint] == 0) K--;
			}
			robot[endPoint] = false;
			
			// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if (belt[startPoint] == 0) continue;
			
			robot[startPoint] = true;
			belt[startPoint] -= 1;
			if(belt[startPoint] == 0) K--;
				
			// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
		}
		System.out.println(result);
		br.close();
	}
}