package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2 {
    static String [] phone_book;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(br.readLine());
        phone_book = new String[t];
        for(int i = 0; i < t; ++i)
        {
            phone_book[i] = st.nextToken();
        }
        solution(phone_book);
    }
        static boolean solution(String[] phone_book) {
            for(int i = 0; i < phone_book.length; ++i)
            {
                for(int j = 0; j < phone_book.length; ++j)
                {
                    if(i == j) continue;
                    if(phone_book[i].startsWith(phone_book[j])) return false;
                }
            }
            return true;
        }

}
