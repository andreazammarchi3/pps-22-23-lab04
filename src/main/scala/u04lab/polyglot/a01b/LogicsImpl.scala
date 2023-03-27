package u04lab.polyglot.a01b
import scala.jdk.javaapi.OptionConverters
import u04lab.polyglot.{OptionToOptional, Pair}
import u04lab.code.Option
import u04lab.code.Option.*
import u04lab.code.List
import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01b/sol2/ */
class LogicsImpl(private val size: Int, private val mines: Int) extends Logics:
  private var minesSet = List.empty[Tuple]
  private var selected = List.empty[Tuple]

  while (List.length(minesSet) != mines)
    minesSet = List.cons(Tuple2(Random.nextInt(size-1), Random.nextInt(size-1)), minesSet)
  println(minesSet.toString)

  private def neighbours(x: Int, y: Int): Int =
    var mines: Int = 0
    for col <- x-1 to x+1 do
      for row <- y-1 to y+1 do
        if List.contains(minesSet, Tuple2(col, row)) then mines = mines + 1
    mines

  def hit(x: Int, y: Int): java.util.Optional[Integer] =
    if List.contains(minesSet, Tuple2(x, y)) then return OptionToOptional(None())
    selected = List.cons(Tuple2(x, y), selected)
    OptionToOptional(Option.Some(neighbours(x, y)))

  def won: Boolean =
    List.length(selected) + List.length(minesSet) == size * size
