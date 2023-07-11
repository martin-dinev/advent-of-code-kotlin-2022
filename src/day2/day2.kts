import java.io.File
val lines = File("input.txt").readLines()
//val lines = listOf("A Y", "B X", "C Z")

val abc = listOf("A", "B", "C")
val xyz = listOf("X", "Y", "Z")
val e = lines.map { it.split(" ").let { abc.indexOf(it[0]) to xyz.indexOf(it[1]) } }

println(e.sumOf { (a, b) -> (b - a + 1 + 3) % 3 * 3 + b + 1 })
println(e.sumOf { (a, b) -> (a + b - 1 + 3) % 3 + 1 + b * 3 })
