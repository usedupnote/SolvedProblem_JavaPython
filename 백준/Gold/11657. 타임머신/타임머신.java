import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static final int INF = (int) 1e9;
    static int v, e;
    static List<Edge> edges = new ArrayList<>();
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());  // 노드 수
        e = Integer.parseInt(st.nextToken());  // 간선 수

        distance = new long[v + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }

        boolean hasNegativeCycle = bellmanFord(1);

        if (hasNegativeCycle) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= v; i++) {
                if (distance[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        }

        br.close();
    }

    static boolean bellmanFord(int start) {
        distance[start] = 0;

        for (int i = 0; i < v; i++) {
            for (Edge edge : edges) {
                int from = edge.from;
                int to = edge.to;
                int cost = edge.cost;

                if (distance[from] != INF && distance[to] > distance[from] + cost) {
                    distance[to] = distance[from] + cost;

                    if (i == v - 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}