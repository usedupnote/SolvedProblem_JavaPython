import java.io.*;
import java.util.*;

public class Main {
	static class City{
		int price;
		int costomer;
		
		public City(int price, int costomer) {
			this.price = price;
			this.costomer = costomer;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int result = Integer.MAX_VALUE;
		
		ArrayList<City> citys = new ArrayList<>();
		
		int maxC = 0;		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			citys.add(new City(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			maxC = Integer.max(maxC, citys.get(i).costomer);
		}
        
		int[] map = new int[C+maxC+1]; // 최소고객수+1회당 증가할 수 있는 최대 고객수 까지 더 살펴봐야 함
		for (int i = 1; i < C+maxC+1; i++) map[i] = Integer.MAX_VALUE/2;

		for (int i = 1; i < map.length; i++) {
			for (int j = 0; j < N; j++) {
				if (i-citys.get(j).costomer < 0) continue;
				map[i] = Integer.min(map[i], map[i-citys.get(j).costomer] + citys.get(j).price);
			}
			
			if (i >= C) {
				result = Integer.min(result, map[i]);
			}
		}
		
		System.out.println(result);
        br.close();
    }
}