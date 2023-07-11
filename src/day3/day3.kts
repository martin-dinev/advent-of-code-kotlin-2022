import java.io.File
val lines = File("input.txt").readLines()
//val lines = listOf(
//    "vJrwpWtwJgWrhcsFMMfFFhFp",
//    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
//    "PmmdzqPrVvPwwTWBwg",
//    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
//    "ttgJtRGJQctTZtZT",
//    "CrZsJsPPZsGzwwsLwLmpwMDw"
//)

val lit = { ch: Char -> ch.code + 1 - if (ch.isLowerCase()) 'a'.code else 'A'.code - 26 }

val inp = lines.map { it.chunked(it.length / 2).map { it.map(lit).toSet() } }
println(inp.sumOf { (it[0] intersect it[1]).sum() })
println(inp.chunked(3).map { it.fold((1..52).toSet()) { a, b -> a intersect (b[0] union b[1]) } }.sumOf { it.sum() })

