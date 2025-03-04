import java.io.*;
import java.util.*;

public class Main {
	private static class Friend {
		public Friend parent;  // 자기 자신을 가리키는 참조
		public int FriendCnt;  // 이 그룹의 친구 수
		
    // 생성자
		public Friend() {
			this.parent = this;
			this.FriendCnt = 1;
		}
		
    // 루트 노드 찾기 및 경로 압축
		public Friend Find() {
			if(this.parent != this) {
				this.parent = this.parent.Find();
			}
			return this.parent;
		}
		
    // 두 그룹 합치기 (순서/크기 상관없어서 먼저 들어온 입력값으로 몰아줌)
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
		
    // Test Case 횟수
		int n = Integer.parseInt(st.nextToken());
		
		for (int d = 0; d < n ; d++) {
			st = new StringTokenizer(br.readLine());
			int F = Integer.parseInt(st.nextToken());   // 입력받을 친구관계 수
			
			HashMap<String, Friend> hm = new HashMap<>(); // 저장할 친구들
			
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String[] s = new String[2];
				
        // 입력된 친구 중 기존 친구관계가 없는 친구를 HashMap에 저장
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
	}
}