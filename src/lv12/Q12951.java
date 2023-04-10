package lv12;

public class Q12951 {
    public static void main(String[] args) {
    }

    static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] arr = s.split(" ");

        for (String str : arr) {
            str = str.toLowerCase();

            if (str.length() > 1) {
                String firstChar = str.charAt(0) + "";
                String other = str.substring(1);

                sb.append(firstChar.toUpperCase())
                        .append(other);
            }

            sb.append(" ");
        }
        String answer = sb.toString();

        if(s.charAt(s.length() - 1) == ' '){
            return answer;
        }

        // 맨 마지막 " " 제거하고 sb 반환
        return answer.substring(0, sb.length()-1);
    }
}
