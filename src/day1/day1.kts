import java.io.File
val lines = File("input.txt").readLines()

// skip
//val e = lines.fold(listOf(listOf<Int>())){ acc, s ->
//    if (s == "") acc + listOf(listOf()) else acc.subList(0, max(0,acc.size-1)) + listOf(acc[acc.size-1] + s.toInt())
//}
//println(e.map { it.sum() }.max())
//println(e.map { it.sum() }.sortedDescending().subList(0,3).sum())


val sums = lines.joinToString("\n").split("\n\n").map { it.split("\n").sumOf { it.toInt() } }
println(sums.max())
println(sums.sortedDescending().subList(0,3).sum())