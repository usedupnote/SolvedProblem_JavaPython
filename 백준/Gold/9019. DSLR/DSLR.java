import java.io.*;
import java.util.*;

public class Main {
	static boolean[] v;
	
	static class State{
		int num;
		long commands;
		
		public State(int num, long commands) {
			this.num = num;
			this.commands = commands;
		}
	}
	
	static int D(int cur) {
		return cur*2%10000;
	}
	static int S(int cur) {
		return (cur + 9999) % 10000;
	}
	static int L(int cur) {
		return ((cur * 10 % 10000) + (cur / 1000))%10000;
	}
	static int R(int cur) {
		return (cur % 10 * 1000) + (cur / 10);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			v = new boolean[10000];
			
			ArrayDeque<State> q = new ArrayDeque<>();
			
			q.add(new State(A, 4));
			v[A] = true;
			
			while (!q.isEmpty()) {
				State poll = q.poll();
				
				if (poll.num == B) {
					StringBuilder b = new StringBuilder();
					
					while (poll.commands != 4) {
						switch ((int)poll.commands%4) {
						case 0:
							b.append("D");
							break;
						case 1:
							b.append("S");
							
							break;
						case 2:
							b.append("L");
							break;
						case 3:
							b.append("R");
							break;
						default:
							break;
						}
						poll.commands>>>=2;
					}
					b.reverse();
					sb.append(b).append("\n");
					break;
				}
				
				int d = D(poll.num);
				int s = S(poll.num);
				int l = L(poll.num);
				int r = R(poll.num);
				poll.commands<<=2;
				
				if(!v[d]) {
					q.add(new State(d, poll.commands));
					v[d] = true;
				}
				if(!v[s]) {
					q.add(new State(s, poll.commands+1));
					v[s] = true;
				}
				if (!v[l] && poll.commands%4 != 3 && poll.commands%64 != 42) {
					q.add(new State(l, poll.commands+2));
					v[l] = true;
				}
				if (!v[r] && poll.commands%4 != 2 && poll.commands%16 != 10 && poll.commands%64 != 63) {
					q.add(new State(r, poll.commands+3));
					v[r] = true;
				}
			}
		}
		System.out.println(sb);
        br.close();
    }
}