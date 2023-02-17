import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 배송할 설탕량 입력
		
		int result = -1;		// 결과값 출력을 위한 값 초기화
								// (값 재할당이 안될 경우 -1로 출력하기 위해 -1로 초기화)
	
		for (int i = 0; i < 5; i++) {
			if((N-(i * 3)) % 5 == 0 && (N-(i * 3)) >= 0) {    // 3kg 봉투의 갯수에 따라서 나누어떨어지는지 확인
				result = (N+(i * 2)) / 5;    // 결과값에 전체 봉투의 갯수 출력				}
				break; // 반복문 탈출
			}
		}
		System.out.println(result);
		
		sc.close();
	}
}