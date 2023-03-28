import java.io.*;
import java.util.*;

// BFS
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄부터 T개의 테스트 케이스가 주어진다.
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());	//TestCase 수
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			int day1 = Integer.parseInt(st.nextToken());		// 1일 이용권의 요금
			int month1 = Integer.parseInt(st.nextToken());		// 1달 이용권의 요금
			int month3 = Integer.parseInt(st.nextToken());		// 3달 이용권의 요금
			int year1 = Integer.parseInt(st.nextToken());		// 1년 이용권의 요금

			//그 다음 줄에는 1월부터 12월까지의 이용 계획이 주어진다.
			st = new StringTokenizer(br.readLine());
			
			int[] howToUse = new int[13];
			for (int i = 1; i <= 12; i++) {
				howToUse[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] price = new int[13];
			
			Arrays.fill(price, Integer.MAX_VALUE);
			price[0] = 0;
			
			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]);
				}
			});
			
			q.offer(new int[] {0,0});		// month, totalPrice
			
			while (!q.isEmpty()) {
				int[] poll = q.poll();
				
				if (poll[0] > 12) continue;
				
				if(poll[1] == 3) {
					price[poll[0]] = Math.min(price[poll[0]], price[poll[0] - 3] + month3);
				}
				else if(poll[1] == 1) {
					price[poll[0]] = Math.min(price[poll[0]], price[poll[0] - 1] + Math.min(day1 * howToUse[poll[0]], month1));
				}
				q.offer(new int[] {poll[0] + 1, 1});
				q.offer(new int[] {poll[0] + 3, 3});
			}
			
			sb.append("#" + test_case + " " + Math.min(price[12], year1) + "\n");
		}
		System.out.println(sb);
	}
}

/*
//DP
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄부터 T개의 테스트 케이스가 주어진다.
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());   //TestCase 수
         
        for (int test_case = 1; test_case <= T; test_case++) {
             
            st = new StringTokenizer(br.readLine());
            int day1 = Integer.parseInt(st.nextToken());        // 1일 이용권의 요금
            int month1 = Integer.parseInt(st.nextToken());      // 1달 이용권의 요금
            int month3 = Integer.parseInt(st.nextToken());      // 3달 이용권의 요금
            int year1 = Integer.parseInt(st.nextToken());       // 1년 이용권의 요금
 
            //그 다음 줄에는 1월부터 12월까지의 이용 계획이 주어진다.
            st = new StringTokenizer(br.readLine());
             
            int[] price = new int[13];
             
            Arrays.fill(price, Integer.MAX_VALUE);
            price[0] = 0;
             
            for (int i = 1; i <= 12; i++) {
                int num = Integer.parseInt(st.nextToken());
                if(i == 1) {
                    price[1] = Math.min(num * day1, month1);
                    continue;
                }
                price[i] = Math.min((num * day1) + price[i-1], month1 + price[i-1]);
                if(i < 3) continue;
                price[i] = Math.min(price[i], month3 + price[i-3]);
            }
             
            sb.append("#" + test_case + " " + Math.min(price[12], year1) + "\n");
        }
        System.out.println(sb);
    }
}
*/