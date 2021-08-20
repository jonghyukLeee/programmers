package Kakao2021;

public class Q1_2 {
    public static void main(String[] args) {
        System.out.print(solution("...!@BaT#*..y.abcdefghijklm"));
    }
    static String solution(String new_id) {
        String answer = new_id;

        //1단계
        answer = answer.toLowerCase();

        //2단계
        answer = answer.replaceAll("[^-_.a-z0-9]","");

        //3단계
        answer = answer.replaceAll("[.]+",".");

        //4단계
        answer = answer.replaceAll("^[.]|[.]$","");

        //5단계
        if(answer.length() < 1) answer = "a";

        //6단계
        if(answer.length() >= 16)
        {
            answer = answer.substring(0,15);
            answer = answer.replaceAll("^[.]|[.]$","");
        }

        //7단계
        if(answer.length() <= 2)
        {
            char c = answer.charAt(answer.length()-1);
            while(answer.length() < 3) answer += c;
        }
        return answer;
    }
}
