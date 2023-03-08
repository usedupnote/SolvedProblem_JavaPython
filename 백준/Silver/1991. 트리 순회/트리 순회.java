import java.io.*;
import java.util.*;
 
public class Main {
	static class Node {
		char th;
		int left, right;
		
		public Node(char th, int left, int right) {
			this.th = th;
			this.left = left;
			this.right = right;
		}
	}
	
	static ArrayList<Node> treeNode;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		treeNode = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			treeNode.add(new Node('0', -19, -19));
		}
		
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			treeNode.set(c[0] - 'A', new Node(c[0], c[2] - 'A', c[4] - 'A'));
		}

		treeoutput1(0);
		sb.append("\n");
		treeoutput2(0);
		sb.append("\n");
		treeoutput3(0);
		sb.append("\n");
		
		System.out.println(sb);
	}

	static void treeoutput1(int current) {
		Node get = treeNode.get(current);
		
		sb.append(get.th);
		if (get.left != -19) treeoutput1(get.left);
		if(get.right != -19) treeoutput1(get.right);
	}

	static void treeoutput2(int current) {
		Node get = treeNode.get(current);
		
		if (get.left != -19) treeoutput2(get.left);
		sb.append(get.th);
		if(get.right != -19) treeoutput2(get.right);
	}

	static void treeoutput3(int current) {
		Node get = treeNode.get(current);
		
		if (get.left != -19) treeoutput3(get.left);
		if(get.right != -19) treeoutput3(get.right);
		sb.append(get.th);
	}
}