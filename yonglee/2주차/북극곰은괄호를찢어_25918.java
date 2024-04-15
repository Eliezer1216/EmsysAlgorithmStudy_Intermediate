/*
-> stack 문제
처음에 queue로 풀었으나 시간초과로 stack으로 풀었다.
큐로는 괄호를 모두 넣은 뒤 값을 비교해 푸시, 팝하는 방식으로 했으나
스택으로는 배열과 스택에 있는 값만 비교하여 다른지 같은지만 판단하는 논리로 풀기때문에 시간복잡도도 적었따
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> mystack = new Stack<>();
        int ans = -1; // 홀수일 경우 -1

        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 0) {
            char[] arr = br.readLine().toCharArray();
            for (int i = 0; i < n; i++) {
                if (mystack.isEmpty() || mystack.peek().equals(arr[i])) { //스택이 비어있거나 스택 top과 같을 시 push
                    mystack.push(arr[i]);
                } else { //다를 시 pop
                    mystack.pop();
                }
                ans = Math.max(ans, mystack.size()); //스택의 사이즈와 ans와 비교해 큰 값을 ans로 설정
                                                       처음에 스택에 쌓이는 만큼 횟수를 반복할 것이라 stack.size를 그 값으로 함 
            }
            if (!mystack.isEmpty()) { //스택이 비지 않았다면 (,)가 같은 숫자임을 충족하지 못하므로 -1
                ans = -1;
            }

        }
        System.out.println(ans);
    }
}
