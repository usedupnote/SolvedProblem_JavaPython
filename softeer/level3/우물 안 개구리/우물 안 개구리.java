import java.io.*;
import java.util.*;

public class Main {
	public static class member {
		int my;
		boolean state;

		public member(int my, boolean state) {
			this.my = my;
			this.state = state;
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int result = 0;
    	
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
				
		st = new StringTokenizer(br.readLine());
		member[] personList = new member[n+1];
		
		for (int i = 1; i <= n; i++) {
			int weight = Integer.parseInt(st.nextToken());
			personList[i] = new member(weight, true);
		}
		
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if (personList[A].my < personList[B].my) {
				personList[A].state = false;
			} else if (personList[A].my == personList[B].my) {
				personList[A].state = personList[B].state = false;
			}
			else {
				personList[B].state = false;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (personList[i].state) {
				result++;
			}
		}
    	
    	System.out.println(result);
    }
}