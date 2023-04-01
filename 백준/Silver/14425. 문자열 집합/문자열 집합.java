import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		Map<Character, Node> chiledNode = new HashMap<Character, Node>();    // 자식노드
		boolean endOfword;    // 단어의 끝인지 아닌지 체크
	}
	
	static class CodingNojam_Trie {
		Node rootNode = new Node();    // Trie자료구조를 생성할 떄 rootNode는 기본적으로 생성

		// Trie에 문자열 저장
		void insert(String str) {
			Node node = this.rootNode;    // Trie자료구조는 항상 rootNode부터 시작 
			
			// 문자열의 각 단어마다 가져와서 자식노드 중에 있는지 체크
			// 없으면 자식노드 새로 생성
			for(int i=0; i<str.length(); i++) {
				node = node.chiledNode.computeIfAbsent(str.charAt(i), key -> new Node());
			}
			// 저장 할 문자열의 마지막 단어에 매핑되는 노드에 단어의 끝임을 명시
			node.endOfword = true;
		}
		
		// Trie에서 문자열 검색
		boolean search(String str) {
			// Trie자료구조는 항상 rootNode부터 시작
			Node node = this.rootNode;
				
			// 문자열의 각 단어마다 노드가 존재하는지 체크 
			for(int i=0; i<str.length(); i++) {
				// 문자열의 각 단어에 매핑된 노드가 존재하면 가져오고 아니면 null
				node = node.chiledNode.getOrDefault(str.charAt(i), null);
				if(node == null) {
					// node가 null이면 현재 Trie에 해당 문자열은 없음
					return false;
				}
			}
			// 문자열의 마지막 단어까지 매핑된 노드가 존재한다고해서 무조건 문자열어 존재하는게 아님
			// busy를 Trie에 저장했으면, bus의 마지막 s단어에 매핑 된 노드는 존재하지만 Trie에 저장된건 아님
			// 그러므로 현재 노드가 단어의 끝인지 아닌지 체크하는 변수로 리턴
			return node.endOfword;
		}
	}
	
	public static void main(String[] args) throws IOException {
		//총 N개의 문자열로 이루어진 집합 S가 주어진다.
		//입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)
		int M = Integer.parseInt(st.nextToken());

		// Trie 자료구조 생성
		CodingNojam_Trie trie = new CodingNojam_Trie();
		
		//다음 N개의 줄에는  집합 S에 포함되어 있는 문자열들이 주어진다.
		String S = null;
		for (int i = 0; i < N; i++) {
			S = br.readLine();
			trie.insert(S);
		}
		
		int result = 0;
		
		//다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.
		for (int i = 0; i < M; i++) {
			S = br.readLine();
			if (trie.search(S)) result++;
		}

		//입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.

		//첫째 줄에 M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력한다.
		System.out.println(result);
		br.close();
	}
}