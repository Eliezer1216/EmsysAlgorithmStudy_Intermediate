/*
-> 스택
*/
import java.util.*;

public class baek1874 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>(); //스택 초기화

        int n = sc.nextInt();
        int start = 0;

        while (n-- > 0) {//n이 0보다 클때
            int value = sc.nextInt();

            if (value > start) { //value가 start보다 클때
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = value;
            } else if (stack.peek() != value) { //value가 stack의 맨 위값과 다를때
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }

}
