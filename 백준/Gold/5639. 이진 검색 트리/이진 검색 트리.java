import java.io.*;
import java.util.*;
 
public class Main {
	static class Node {
		int th;
		Node left, right;
		
		public Node(int th) {
			this.th = th;
			this.left = null;
			this.right = null;
		}
	}
	
	static ArrayList<Node> treeNode;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		treeNode = new ArrayList<>();
		
		// 초기값 설정
		String input = br.readLine();
		int N = Integer.parseInt(input);
		treeNode.add(new Node(N));
		
		while (true) {
			try {
				input = br.readLine();
				N = Integer.parseInt(input);
				setNode(treeNode.get(0), N);
			}catch (Exception e) {
				break;
			}
		}

		treeoutput(treeNode.get(0));
		
		System.out.println(sb);
	}

	private static void setNode(Node node, int n) {
		if (node.th > n) {
			if(node.left == null) {
				node.left = new Node(n);
			} else {
				setNode(node.left, n);
			}
		} else { 
			if(node.right == null) {
				node.right = new Node(n);
			} else {
				setNode(node.right, n);
			}
		}
	}

	static void treeoutput(Node current) {
		if (current.left != null) treeoutput(current.left);
		if(current.right != null) treeoutput(current.right);
		sb.append(current.th + "\n");
	}
}