/*
-> 스택 문제(이유 : (,)를 스택에 담아 푸시, 팝을 활용해 막대기 갯수를 계산하기 위해서 )
-> 문제에는 두가지 유형이 있는데 하나는 레이저, 하나는 막대기이다.
  () 레이저가 나온다면 막대기 갯수를 더하고 (를 팝한다.
   ) 그냥 막대기라면 팝하고 끝난 막대기 하나만을 더한다.
   즉 스택에는 (만 들어가고 )는 팝하는 용도로 사용했다.
*/


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int ans=0;

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<arr.length;i++){
            if (arr[i] == ')') {
                if (arr[i-1] == '(') {
                    stack.pop();
                    ans += stack.size();
                } else {
                    stack.pop();
                    ans += 1;
                }
            } else {
                stack.push('(');
            }
        }

        System.out.println(ans);

    }
}
