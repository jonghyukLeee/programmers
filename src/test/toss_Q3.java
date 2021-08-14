package test;

import java.io.IOException;
import java.util.StringTokenizer;

public class toss_Q3 {
    public static void main(String[] args) throws IOException {
    }
    static boolean solution(String amountText) {
        boolean answer = true;
        try
        {
            if(amountText.charAt(0) == '0')
            {
                if(amountText.length() > 1)
                {
                    return false;
                }
            }
            amountText = "+" + amountText;
            int strToInt = Integer.parseInt(amountText);


        }catch (NumberFormatException e)
        {
            if(!amountText.contains(","))
            {
                return false;
            }
            else
            {
                amountText = amountText.replace("+","");

                if(amountText.charAt(0) == ',' || amountText.charAt(amountText.length()-1) == ',')
                {
                    return false;
                }
                StringTokenizer st = new StringTokenizer(amountText,",");
                String fstStr = st.nextToken();
                while(st.hasMoreTokens())
                {
                    String tmpStr = st.nextToken();
                    if(tmpStr.length() == 3) continue;
                    return false;
                }
            }
            answer = true;
        }
        return answer;
    }
}
