import java.io.*;
import java.util.*;
 
public class Main {
	static class Node {
		int start, end, weight;

		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	
	static final int MAX_VAL= Integer.MAX_VALUE;
	static int[] visited;
	static ArrayList<Node>[] nodeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()) - 1;
		
		nodeList = new ArrayList[V];
		
		for (int i = 0; i < V; i++) {
			nodeList[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			nodeList[u].add(new Node(u, v, w));
		}
		
		visited = new int[V];
		
		Arrays.fill(visited, MAX_VAL);
		
		visited[K] = 0;
		
		root(K, V);
		
		for (int i = 0; i < V; i++) {
			sb.append((visited[i] == MAX_VAL?"INF":visited[i]) + "\n");
		}
		
		System.out.println(sb);
	}

	private static void root(int current, int cnt) {
		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
		});
		
		for(Node N : nodeList[current]) {
			q.offer(N);
		}
		
		while (!q.isEmpty()) {
			if (cnt == 0) break;
			Node poll = q.poll();
			
			if(visited[poll.end] != MAX_VAL) continue;
			visited[poll.end] = poll.weight;

			for(Node N : nodeList[poll.end]) {
				if (visited[N.end] == MAX_VAL) {
					N.weight += visited[poll.end];
					q.offer(N);
				}
			}
			cnt--;
		}
	}
}