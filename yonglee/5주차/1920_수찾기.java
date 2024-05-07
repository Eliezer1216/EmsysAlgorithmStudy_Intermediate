/*
이분탐색, 정렬 문제
정렬한 후에 이분탐색으로 시간 단축
일반 배열 탐색시 O(N)의 시간복잡도, 이분 탐색 시 O(log N)
일반 배열 순회 시 O(N^2), 정렬 후 이분 탐색 시 O(N log N)
Arrays.sort()와 Arrays.binarySearch()사용
*/


import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr); //정렬(O(logN)

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int ans;
        split = br.readLine().split(" ");
        for (int i = 0; i < T; i++) {
            ans = Integer.parseInt(split[i]);
            int in = Arrays.binarySearch(arr, ans); //이분탐색

            if (in < 0) { //없는 값일 시
                sb.append(0 + "\n");
            } else { // 값이 존재할 시
                sb.append(1 + "\n");
            }

        }
        System.out.println(sb);
    }
}
