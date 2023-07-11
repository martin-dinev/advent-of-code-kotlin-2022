import java.io.File

var lines = File("input.txt").readLines()
//lines = listOf(
//    "30373",
//    "25512",
//    "65332",
//    "33549",
//    "35390"
//)

val n = lines.size
val m = lines[0].length
val e = (1..n).map { (1..m).map { 0 }.toMutableList() }
for (i in 0 until n) {
    var b = -1
    var u = -1
    for (j in 0 until m) {
        if (lines[i][j] - '0' > b) {
            b = lines[i][j] - '0'
            e[i][j] = 1
        }
        if (lines[i][m - 1 - j] - '0' > u) {
            u = lines[i][m - 1 - j] - '0'
            e[i][m - 1 - j] = 1
        }
    }
}

for (j in 0 until m) {
    var l = -1
    var r = -1

    for (i in 0 until n) {


        if (lines[i][j] - '0' > l) {
            l = lines[i][j] - '0'
            e[i][j] = 1
        }
        if (lines[n - 1 - i][j] - '0' > r) {
            r = lines[n - 1 - i][j] - '0'
            e[n - 1 - i][j] = 1
        }
    }
}
println(e.sumOf { it.sum() })


var mp = -1
for(i in 0 until n){
    for(j in 0 until m){
        var p = 1
        var c = 0
        for(k in i-1 downTo 0){
            c+=1
            if (lines[k][j]>=lines[i][j])
                break
        }
        p *= c
        c = 0
        for(k in i+1 until n){
            c+=1
            if (lines[k][j]>=lines[i][j])
                break
        }
        p *= c
        c = 0
        for(k in j-1 downTo 0){
            c+=1
            if (lines[i][k]>=lines[i][j])
                break
        }
        p *= c
        c = 0
        for(k in j+1 until m){
            c+=1
            if (lines[i][k]>=lines[i][j])
                break
        }
        p *= c
        if (p > mp){
            mp = p
        }
    }
}

println(mp)