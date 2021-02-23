package ES;

import java.util.ArrayList;

public class es_1 {
    /**
     * 프로그래머스 코딩테스트 고득점 kit > 완전탐색 > 모의고사
     * 문제 설명
     * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
     * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
     *
     * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
     * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
     * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
     *
     * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
     * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

     */
        static public int[] solution(int[] answers) {
            int[] answer = {};
            int max = 0;
            int [] cnt = new int[3];
            int [] a = new int[]{1,2,3,4,5};
            int [] b = new int[]{2,1,2,3,2,4,2,5};
            int [] c = new int[]{3,3,1,1,2,2,4,4,5,5};

            for(int i =0;i<answers.length;++i)
            {
                if(answers[i] == a[i%5]) cnt[0]++;
                if(answers[i] == b[i%8]) cnt[1]++;
                if(answers[i] == c[i%10]) cnt[2]++;
            }
            for(int i = 0; i < 3; ++i)
            {
                if(max < cnt[i]) max = cnt[i];
            }
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(max == cnt[0]) list.add(1);
            if(max == cnt[1]) list.add(2);
            if(max == cnt[2]) list.add(3);

            answer = new int[list.size()];

            for(int i = 0 ; i<answer.length; ++i)
            {
                answer[i] = list.get(i);
            }
            return answer;
        }
}
