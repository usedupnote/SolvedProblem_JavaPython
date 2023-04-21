import java.io.*;
import java.util.*;

public class Main {
	static class problem {
		int deadline;
		long cupnoodle;
		
		public problem(int deadline, long cupnoodle) {
			this.deadline = deadline;
			this.cupnoodle = cupnoodle;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long result = 0;
		
		PriorityQueue<problem> resultQ = new PriorityQueue<>(new Comparator<problem>() {
			@Override
			public int compare(problem o1, problem o2) {
				return Long.compare(o1.cupnoodle, o2.cupnoodle);
			}
		});
		
		PriorityQueue<problem> q = new PriorityQueue<>(new Comparator<problem>() {

			@Override
			public int compare(problem o1, problem o2) {
				if (o2.deadline == o1.deadline) {
					return Long.compare(o2.cupnoodle, o1.cupnoodle);
				}
				return Long.compare(o1.deadline, o2.deadline);
			}
		});
		
		int deadline;
		long cupnoodle;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
 			deadline = Integer.parseInt(st.nextToken());
 			cupnoodle = Long.parseLong(st.nextToken());
 			
			q.offer(new problem(deadline, cupnoodle));
		}
		
		resultQ.offer(q.poll());
		
		while (!q.isEmpty()) {
			problem poll = q.poll();
			
			if (poll.cupnoodle > resultQ.peek().cupnoodle || poll.deadline >= resultQ.peek().deadline) {
				resultQ.offer(poll);
				
				if (resultQ.size() > poll.deadline) {
					resultQ.poll();
				}
			}
		}
		
		while (!resultQ.isEmpty()) {
			result += resultQ.poll().cupnoodle;
		}
		
		System.out.println(result);
		br.close();
	}
}