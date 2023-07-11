import java.io.File
val lines = File("input.txt").readLines()
//val lines = listOf("2-4,6-8", "2-3,4-5", "5-7,7-9", "2-8,3-7", "6-6,4-6", "2-6,4-8")

val e = lines.map { it.split(",").map { it.split('-').map(String::toInt) } }

println(e.count { (it + it).zipWithNext().any { (a, b) -> a.all { it in b[0]..b[1] } } })
println(e.count { (it + it).zipWithNext().any { (a, b) -> a.any { it in b[0]..b[1] } } })

