import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] C = a.toCharArray();
        
        for (char c : C) {
            if (c <= 90){
                sb.append((char)(c+32));
            } else {
                sb.append((char)(c-32));
            }
        }
        System.out.println(sb);
    }
}