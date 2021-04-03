package Kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {
    static boolean [] isVis;
    static int [] wants;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int [] gift_cards = new int[5];
        wants = new int[5];
        isVis = new boolean[5];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; ++i)
        {
            gift_cards[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; ++i)
        {
            wants[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(gift_cards,wants));
    }
        static int solution(int[] gift_cards, int[] wants) {
            int answer = 0;
            answer = gift_cards.length;
            int cnt = 0;
            for(int i = 0; i < answer; ++i)
            {
                if(gift_cards[i] == wants[i])
                {
                    cnt++;
                    isVis[i] = true;
                }
            }
            for(int i = 0; i < answer ; ++i)
            {
                if(isVis[i]) continue;
                for(int j = 0; j < answer; ++j)
                {
                    if(gift_cards[i] == wants[j] && !isVis[j])
                    {
                        if(i == j)
                        {
                            cnt++;
                            isVis[i] = true;
                            i = 0;
                            break;
                        }
                        cnt++;
                        int tmp = gift_cards[i];
                        gift_cards[i] = gift_cards[j];
                        gift_cards[j] = tmp;
                        isVis[j] = true;
                        i = -1;
                        break;
                    }
                }
            }
            return answer-cnt;
        }
}
