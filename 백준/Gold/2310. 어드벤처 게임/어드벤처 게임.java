import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static ArrayList<Room> miro;
	
	static class Room {
		char type;
		int coin;
		int visited;
		ArrayList<Integer> connectedRoom;
		
		public Room(char type, int coin) {
			this.type = type;
			this.coin = coin;
			this.visited = -1;
			connectedRoom = new ArrayList<>();
		}
	}
	
	static boolean dfs(int position, int coin) {
		Room room = miro.get(position);
		switch (room.type) {
		case 'L':
			coin = Integer.max(coin, room.coin);
			break;
		case 'T':
			coin -= room.coin;					
			break;
		}
		
		if (coin < 0 || coin <= room.visited) return false;	// 돈이 없는 경우, 불가능이므로 pass | 이미 같은 상황(같은 방에 같은 돈으로 방문한 기록O)인 경우 pass
		room.visited = coin;	// 방문처리
		if (position == n-1) {		// 돈도 있고, 도착에 성공한 경우, 로직의 success true로 변경
			return true;
		}
		
		int connectedRoomSize = room.connectedRoom.size();
		
		for (int i = 0; i < connectedRoomSize; i++) {
			if(dfs(room.connectedRoom.get(i), coin)) return true;
		}
		
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while(true) {
			st = new StringTokenizer(br.readLine());
			boolean success = false;
			n = Integer.parseInt(st.nextToken());
			if (n == 0) break;		// 종료조건
			miro = new ArrayList<>();
			
			// 미로 지도 생성
			for (int i = 0; i < n; i++) {
				// E,L,T : 금액 문번호1 문번호2 ... 문번호n 0
				// 실패조건 (순환, 조건은 없지만 보유자금음수?)
				st = new StringTokenizer(br.readLine());
				
				miro.add(new Room(st.nextToken().toCharArray()[0], Integer.parseInt(st.nextToken())));
				
				while (true) {
					int connectedRoomNum = Integer.parseInt(st.nextToken());
					if (connectedRoomNum == 0) break;
					miro.get(i).connectedRoom.add(connectedRoomNum-1);
				}
			}
			
			if (dfs(0,0)) sb.append("Yes\n");
			else sb.append("No\n");
		}
		
		System.out.println(sb);
        br.close();
    }
}