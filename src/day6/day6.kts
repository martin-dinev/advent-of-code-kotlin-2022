import java.io.File

var lines = File("input.txt").readLines()
//
//lines = listOf(
//    "bvwbjplbgvbhsrlpgdmjqwftvncz",
//    "nppdvjthqldpwncqszvftbrmjlhg",
//    "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg",
//    "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
//)

println(lines.sumOf { it.windowed(4).indexOfFirst { it.toSet().size == 4 } + 4} )
println(lines.sumOf { it.windowed(14).indexOfFirst { it.toSet().size == 14 } + 14} )


val numbers = listOf(5, 2, 10, 4)
val sumEvenRight = numbers.foldRightIndexed(0) { idx, element, sum -> if (idx % 2 == 0) sum + element else sum }
