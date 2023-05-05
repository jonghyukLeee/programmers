package lv12

class Q87946 {
}

fun main() {
    val dungeons = arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10))
    println(solution(80, dungeons))
}
var answer = 0;
fun solution(k: Int, dungeons: Array<IntArray>): Int {
    dfs(dungeons, k, 0, Array(dungeons.size){false})
    return answer
}
fun dfs(map: Array<IntArray>, tired: Int, count: Int, isVisited: Array<Boolean>) {
    if (count > answer) answer = count

    for ((idx, value) in map.withIndex()) {
        if (!isVisited[idx] && value[0] <= tired) {
            isVisited[idx] = true
            dfs(map, tired - value[1], count + 1, isVisited)
            isVisited[idx] = false
        }
    }
}