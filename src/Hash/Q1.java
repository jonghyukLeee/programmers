package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1 {
    static String [] part;
    static String [] comp;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        part = new String[t];
        comp = new String[t-1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < part.length; ++i)
        {
            part[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < comp.length; ++i)
        {
            comp[i] = st.nextToken();
        }
        sb.append(solution(part,comp));
        System.out.print(sb.toString());
    }
    static public String solution(String[] part, String[] comp)
    {
        Arrays.sort(part);
        Arrays.sort(comp);
        int i;
        for(i = 0; i < comp.length; ++i)
        {
            if(!comp[i].equals(part[i])) return part[i];
        }
        return part[i];
    }
}
