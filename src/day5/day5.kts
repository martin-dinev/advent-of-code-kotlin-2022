import java.io.File
import java.util.stream.IntStream.range

var lines = File("input.txt").readLines()
//lines = listOf(
//    "    [D]    ",
//    "[N] [C]    ",
//    "[Z] [M] [P]",
//    " 1   2   3 ",
//    "",
//    "move 1 from 2 to 1",
//    "move 3 from 1 to 3",
//    "move 2 from 2 to 1",
//    "move 1 from 1 to 2"
//)

var skipLine = " 1   2   3   4   5   6   7   8   9 "
//skipLine = " 1   2   3 "


var stacks = range(0, 10).mapToObj { ArrayDeque<Char>() }.toList()

lines.takeWhile { it != skipLine }.forEach {
    it.chunked(4).forEachIndexed { i, s -> if (s[1] != ' ') stacks[i + 1].addFirst(s[1]) }
}
lines.dropWhile { it != "" }.drop(1).forEach { ss ->
    ss.split("move ", " from ", " to ").drop(1).map(String::toInt).let {
        range(0, it[0]).forEach { _ ->
            stacks[it[2]].add(stacks[it[1]].removeLast())
        }
    }
}

println(stacks.map { if (it.isNotEmpty()) it.removeLast() else "" }.joinToString(""))


stacks = range(0, 10).mapToObj { ArrayDeque<Char>() }.toList()
lines.takeWhile { it != skipLine }.forEach {
    it.chunked(4).forEachIndexed { i, s -> if (s[1] != ' ') stacks[i + 1].addFirst(s[1]) }
}
lines.dropWhile { it != "" }.drop(1).forEach { ss ->
    ss.split("move ", " from ", " to ").drop(1).map(String::toInt).let {
        range(0, it[0]).mapToObj { _ -> stacks[it[1]].removeLast() }.toList().asReversed().forEach { ch ->
            stacks[it[2]].add(ch)
        }
    }
}
println(stacks.map { if (it.isNotEmpty()) it.removeLast() else "" }.joinToString(""))
