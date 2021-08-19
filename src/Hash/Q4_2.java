package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Album
{
    int idx,cnt;

    public Album(int idx, int cnt)
    {
        this.idx = idx;
        this.cnt = cnt;
    }
}
public class Q4_2 {
    static String [] genres;
    static int [] plays;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        genres = new String[n];
        plays = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            genres[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            plays[i] = Integer.parseInt(st.nextToken());
        }

        for(int i : solution(genres,plays))
        {
            System.out.print(i+" ");
        }
    }
    static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList<Integer> answerAl = new ArrayList<>();
        HashMap<String,Integer> total = new HashMap<>();
        HashMap<String,ArrayList<Album>> genHm = new HashMap<>();

        for(int i = 0; i < genres.length; ++i)
        {
            String gen = genres[i];
            int playCnt = plays[i];

            if(total.containsKey(gen))
            {
                total.put(gen,total.get(gen)+playCnt);
            }
            else
            {
                total.put(gen,playCnt);
                ArrayList<Album> tmp = new ArrayList<>();
                genHm.put(gen,tmp);
            }
            genHm.get(gen).add(new Album(i,playCnt));
        }
        int cnt = total.size();
        answer = new int[cnt*2];
        while(cnt-- > 0)
        {
            int maxValue = Collections.max(total.values());
            String maxGen = "";
            for(String key : total.keySet())
            {
                if(total.get(key) == maxValue)
                {
                    maxGen = key;
                    break;
                }
            }
            ArrayList<Album> tmpAl = genHm.get(maxGen);
            if(tmpAl.size() < 2) answerAl.add(tmpAl.get(0).idx);
            else
            {
                tmpAl.sort(new Comparator<Album>() {
                    @Override
                    public int compare(Album o1, Album o2) {
                        return o2.cnt - o1.cnt;
                    }
                });

                for(int i = 0; i < 2; ++i)
                {
                    answerAl.add(tmpAl.get(i).idx);
                }
            }
            total.replace(maxGen,0);
        }

        answer = new int[answerAl.size()];

        for(int i = 0; i < answerAl.size(); ++i)
        {
            answer[i] = answerAl.get(i);
        }

        return answer;
    }
}
