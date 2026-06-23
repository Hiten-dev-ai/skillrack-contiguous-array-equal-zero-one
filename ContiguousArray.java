import java.io.*;
import java.util.*;

public class ContiguousArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> firstIndex = new HashMap<>();
        firstIndex.put(0, -1);
        int balance = 0;
        int best = 0;

        for (int i = 0; i < n; i++) {
            balance += arr[i] == 1 ? 1 : -1;
            if (firstIndex.containsKey(balance)) {
                best = Math.max(best, i - firstIndex.get(balance));
            } else {
                firstIndex.put(balance, i);
            }
        }

        System.out.println(best);
    }
}
