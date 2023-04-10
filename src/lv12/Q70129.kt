package lv12

class Q70129 {
}

fun main() {
    for (i in solution("110010101001")) {
        println(i)
    }
}

fun solution(s: String): IntArray {
    val answer: IntArray = intArrayOf(0, 0)

    var str = s
    while (str != "1") {
        answer[0]++
        val beforeLen = str.length
        str = str.replace("0", "")
        val afterLen = str.length
        answer[1] += (beforeLen - afterLen)

        str = Integer.toBinaryString(afterLen)
    }

    return answer
}