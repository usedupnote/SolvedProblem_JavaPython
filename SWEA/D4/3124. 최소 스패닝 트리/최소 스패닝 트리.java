import java.io.*;
import java.util.*;
 
public class Solution {
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
         
        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
     
    static int V;
    static Edge[] edgeList;
    static int[] p;     //
     
    static void makeSet() {
        p = new int[V];
        for (int i = 0; i < V; i++) p[i] = i;
    }
     
    static int findSet(int a) {
        if(p[a] == a) return a;
        return p[a] = findSet(p[a]);
    }
     
    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
         
        if(aRoot == bRoot) return false;
        p[bRoot] = aRoot;
        return true;
    }
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(st.nextToken());
         
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            // 정점의 개수 V(1≤V≤100,000)
            // 간선의 개수 E(1≤E≤200,000)
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
             
            edgeList = new Edge[E];
             
            // 간선에 대한 정보 (A, B, C)
            for (int i = 0; i < E; i++) {
                //A번 정점과 B번 정점이 가중치 C인 간선으로 연결
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()) - 1;
                int B = Integer.parseInt(st.nextToken()) - 1;
                int C = Integer.parseInt(st.nextToken());
                 
                edgeList[i] = new Edge(A, B, C);
            }
            //C는 음수일 수도 있으며, 절대값이 1,000,000을 넘지 않는다.
             
            Arrays.sort(edgeList);
             
            makeSet();
             
            long result = 0, cnt = 0;
            for (Edge edge: edgeList) {
                if(union(edge.from, edge.to)) {
                    result += edge.weight;
                    if(++cnt == V-1) break;
                }
            }
            sb.append("#" + test_case + " " + result + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}