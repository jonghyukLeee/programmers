package lv12;

import java.util.Arrays;
import java.util.Comparator;


public class Q17686 {
    public static void main(String[] args) {
        String[] files = {"F B 5 tt", "F A 5 tt"};
        for (String s : solution(files)) {
            System.out.println(s);
        }
    }

    static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String file1, String file2) {
                String[] arr1 = fileToArr(file1);
                String[] arr2 = fileToArr(file2);

                int compareResult = arr1[0].compareTo(arr2[0]);

                if (compareResult == 0) {
                    return Integer.parseInt(arr1[1]) - Integer.parseInt(arr2[1]);
                }
                return compareResult;
            }
        });

        return files;
    }

    static String[] fileToArr(String file) {
        int fileSize = file.length();
        int i = 0;
        String tmpHead = "";
        for (; i < fileSize; i++) {
            char cur = file.charAt(i);
            if (cur >= '0' && cur <= '9') {
                break;
            }
            tmpHead += cur;
        }

        String tmpNumber = "";
        for (; i < fileSize; i++) {
            char cur = file.charAt(i);
            if (cur < '0' || cur > '9') {
                break;
            }
            tmpNumber += cur;
        }

        String tmpTail = "";
        for (; i < fileSize; i++) {
            tmpTail += file.charAt(i);
        }
        return new String[]{tmpHead.toLowerCase(), tmpNumber, tmpTail};

    }
}
