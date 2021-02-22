package Greedy;

public class greedy_2 {
    /**
     * 프로그래머스 코딩테스트 고득점 kit > 탐욕법(Greedy) > 큰 수 만들기
     * 문제 설명
     * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
     *
     * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
     *
     * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
     * number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
     */
    static public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int len = number.length();
        for(int i = 0; i< k;++i)
        {
            for(int j = 0;j < len;++j)
            {
                if(sb.charAt(j)-'0'<sb.charAt(j+1)-'0')
                {
                    sb.deleteCharAt(j);
                    len--;
                    break;
                }
                else
                {
                    if(j == len-2)
                    {
                        sb.deleteCharAt(j+1);
                        len--;
                        break;
                    }
                }
            }
        }
        return sb.toString();
        }

    public static void main(String[] args) {
        System.out.println(solution("54321",2));
    }
}
