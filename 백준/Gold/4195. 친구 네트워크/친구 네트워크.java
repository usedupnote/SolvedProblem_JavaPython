import java.io.*;
import java.util.*;

public class Main {
	private static class Friend {
		public Friend parent;
		public int FriendCnt;
		
		public Friend() {
			this.parent = this;
			this.FriendCnt = 1;
		}
		
		public Friend Find() {
			if(this.parent != this) {
				this.parent = this.parent.Find();
			}
			return this.parent;
		}
		
		public static void union(Friend a, Friend b) {
			Friend A = a.Find();
			Friend B = b.Find();
			
			if(A != B) {
				B.parent = A;
				A.FriendCnt += B.FriendCnt;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		for (int d = 0; d < n ; d++) {
			st = new StringTokenizer(br.readLine());
			int F = Integer.parseInt(st.nextToken());
			
			HashMap<String, Friend> hm = new HashMap<>();
			
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String[] s = new String[2];
				
				for (int j = 0; j < 2; j++) {
					s[j] = st.nextToken();
					if (!hm.containsKey(s[j])) {
						hm.put(s[j], new Friend());
					}
				}
				
				Friend.union(hm.get(s[0]), hm.get(s[1]));
				
				sb.append(hm.get(s[0]).Find().FriendCnt).append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}