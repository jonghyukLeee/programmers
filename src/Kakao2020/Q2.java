package Kakao2020;

public class Q2 {
    public static void main(String[] args) {
        System.out.print(solution("(()())()"));
    }
    static String solution(String p) {
        if(p.equals("")) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(make(p));
        return sb.toString();
    }
    static String make(String str) // ))((  ()
    {
        if(str.length() == 0) return "";
        String [] sep = separate(str);
        String u = sep[0], v = sep[1]; // (()()) , ()
        if(isCorrect(u))
        {
            return u + make(v);
        }
        else
        {
            StringBuilder tmp = new StringBuilder();
            tmp.append("(").append(make(v)).append(")");
            String tmpU = u.substring(1,u.length()-1);
            tmpU = reverse(tmpU);
            tmp.append(tmpU);
            return tmp.toString();
        }
    }
    static String [] separate(String str)
    {
        String [] arr = new String[2];
        int left = 0, right = 0,end = 0;
        for(int i = 0; i < str.length(); ++i)
        {
            String tmp = str.charAt(i)+"";
            if(tmp.equals("(")) left++;
            else right++;
            if(left == right)
            {
                end = i;
                break;
            }
        }
        arr[0] = str.substring(0,end+1);
        arr[1] = str.substring(end+1);

        return arr;
    }
    static boolean isCorrect(String str)
    {
        if(str.length() ==0) return false;
        int cnt = 0; //())
        for(int i = 0; i < str.length(); ++i)
        {
            String tmp = str.charAt(i)+"";
            if(tmp.equals("(")) cnt++;
            else cnt--;
            if(cnt < 0) return false;
        }
        return true;
    }
    static String reverse(String str)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); ++i)
        {
            String cur = str.charAt(i)+"";
            if(cur.equals("(")) sb.append(")");
            else sb.append("(");
        }
        return sb.toString();
    }
}
