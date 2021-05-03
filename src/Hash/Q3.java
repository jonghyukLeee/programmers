package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q3 {
    static String [][] clothes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        clothes = new String[t][2];
        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            clothes[i][0] = st.nextToken();
            clothes[i][1] = st.nextToken();
        }
        System.out.print(solution(clothes));
    }

        static int solution(String[][] clothes) {
            HashMap<String, Integer> hm = new HashMap();
            int answer = 1;
            for (int i = 0; i < clothes.length; i++) {
                hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 1) + 1);
            }

            for (int i : hm.values()) {
                System.out.printf("%d * %d = %d\n",answer,i,answer*i);
                answer *= i;
            }
            return answer-1;
        }

}
