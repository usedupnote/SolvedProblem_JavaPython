import java.io.*;
import java.sql.Array;
import java.util.*;

public class Solution {
	static final int[] dirX = {-1, 0, 1, 0};	// 상 우 하 좌
	static final int[] dirY = {0, 1, 0, -1};
	static int N, K;
	static int[][] map;
	
	static PriorityQueue<Integer> list;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        //방의 크기 N,M
        st = new StringTokenizer(br.readLine());
        //테스트 케이스의 개수 T
        int T = Integer.parseInt(st.nextToken());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());		// 숫자의 개수 N (8 ≤ N ≤ 28, 4의 배수)
    		K = Integer.parseInt(st.nextToken());		// 크기 순서 K
			
    		//그 다음 줄에는 16진수 0~F 숫자가 공백 없이 N개 주어진다.
    		char[] ch = br.readLine().toCharArray();
    		
    		list = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
			});
    		for (int i = 0; i < N; i++) {
    			//각 변에 다음과 같이 16진수 숫자(0~F)가 적혀 있는 보물상자가 있다.
    			//보물 상자의 뚜껑은 시계방향으로 돌릴 수 있고, 한 번 돌릴 때마다 숫자가 시계방향으로 한 칸씩 회전한다.
    			//각 변에는 동일한 개수의 숫자가 있고, 시계방향 순으로 높은 자리 숫자에 해당하며 하나의 수를 나타낸다.
    			String hexInput = "";
    			for (int j = 0; j < N/4; j++) {
    				hexInput += Character.toString(ch[(i + j) % N]);
				}
    			list.offer(Integer.parseInt(hexInput,16));
			}
    		
    		int current = 0;
    		// 보물상자의 비밀번호는 보물 상자에 적힌 숫자로 만들 수 있는 모든 수 중,
    		// K번째로 큰 수를 10진 수로 만든 수이다.
    		for (int i = 0; i < K; i++) {
    			int poll = list.poll();
    			//(서로 다른 회전 횟수에서 동일한 수가 중복으로 생성될 수 있다.
    			// 크기 순서를 셀 때 같은 수를 중복으로 세지 않도록 주의한다.)
				if (current == poll) {
					i--;
				} else {
					current = poll;
				}
			}
    		// N개의 숫자가 입력으로 주어졌을 때, 보물상자의 비밀 번호를 출력하는 프로그램을 만들어보자.
    		//출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
    		//(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
    		sb.append("#" + test_case + " " + current + "\n");
		}
        System.out.println(sb);
        br.close();

	}
}