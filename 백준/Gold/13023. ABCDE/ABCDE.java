import java.io.*;
import java.util.*;

public class Main {
	static class Friend{
		int name;
		ArrayList<Integer> relation;
		
		public Friend(int name) {
			this.name = name;
			relation = new ArrayList<>();
		}
		
		public void setFriend(int friendName) {
			relation.add(friendName);
		}
	}

	static int N, M;
	static Friend[] friends;
	static boolean[] v;
	
	static int relationship() {
		for (int i = 0; i < N; i++) {
			v[i] = true;
			if (checkRelationship(1, i)) return 1;
			v[i] = false;
		}
		return 0;
	}
	
	static boolean checkRelationship(int cnt, int pos) {
		if (cnt == 5) {
			return true;
		}
		
		for (int i = 0; i < friends[pos].relation.size(); i++) {
			int cur = friends[pos].relation.get(i);
			if (v[cur]) continue;
			v[cur] = true;
			if (checkRelationship(cnt+1, cur)) return true;
			v[cur] = false;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		friends = new Friend[N];
		
		for (int i = 0; i < N; i++) {
			friends[i] = new Friend(i);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			friends[left].setFriend(right);
			friends[right].setFriend(left);			
		}
		
		v = new boolean[N];
		
		System.out.println(relationship());
        br.close();
    }
}