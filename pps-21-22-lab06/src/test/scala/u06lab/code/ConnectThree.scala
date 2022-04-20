package u06lab.code

import org.junit.Test
import org.junit.Assert.*
import u06lab.code.*

/*class ConnectThree {
  @Test
  def Ex1() =
    assertTrue(Some(X), find(List(Disk(0, 0, X)), 0, 0))


println() // Some(X)
  println(find(List(Disk(0, 0, X), Disk(0, 1, O), Disk(0, 2, X)), 0, 1)) // Some(O)
  println(find(List(Disk(0, 0, X), Disk(0, 1, O), Disk(0, 2, X)), 1, 1)) // None
}*/

/*// Exercise 1: implement find such that..
println("EX 1: ")
println(find(List(Disk(0, 0, X)), 0, 0)) // Some(X)
println(find(List(Disk(0, 0, X), Disk(0, 1, O), Disk(0, 2, X)), 0, 1)) // Some(O)
println(find(List(Disk(0, 0, X), Disk(0, 1, O), Disk(0, 2, X)), 1, 1)) // None*/

// Exercise 2: implement firstAvailableRow such that..
/*println("EX 2: ")
println(firstAvailableRow(List(), 0)) // Some(0)
println(firstAvailableRow(List(Disk(0, 0, X)), 0)) // Some(1)
println(firstAvailableRow(List(Disk(0, 0, X), Disk(0, 1, X)), 0)) // Some(2)
println(firstAvailableRow(List(Disk(0, 0, X), Disk(0, 1, X), Disk(0, 2, X)), 0)) // Some(3)
println(firstAvailableRow(List(Disk(0, 0, X), Disk(0, 1, X), Disk(0, 2, X), Disk(0, 3, X)), 0)) // None*/
// Exercise 2: implement placeAnyDisk such that..
/*printBoards(placeAnyDisk(List(), X))
// .... .... .... ....
// .... .... .... ....
// .... .... .... ....
// ...X ..X. .X.. X...
println("___________________")
printBoards(placeAnyDisk(List(Disk(0, 0, O)), X))
// .... .... .... ....
// .... .... .... ....
// .... .... .... X...
// O..X O.X. OX.. O...*/

/*println("EX 3: ")
// Exercise 3 (ADVANCED!): implement computeAnyGame such that...
computeAnyGame(O, 4).foreach { g =>
  printBoards(g)
  println()
}
//  .... .... .... .... ...O
//  .... .... .... ...X ...X
//  .... .... ...O ...O ...O
//  .... ...X ...X ...X ...X
//
//
// .... .... .... .... O...
// .... .... .... X... X...
// .... .... O... O... O...
// .... X... X... X... X...

// Exercise 4 (VERY ADVANCED!) -- modify the above one so as to stop each game when someone won!!*/

/*//prova vincita/perdita
  val winningH = List(Disk(1,1,X), Disk(1,2,X), Disk(1,0,X), Disk(3,3,X), Disk(2,0,X))
  val winningV = List(Disk(2,1,O), Disk(1,1,O), Disk(0,1,O), Disk(3,3,X), Disk(2,0,X))
  val winningD1 = List(Disk(1,1,O), Disk(2,2,O), Disk(3,3,O), Disk(3,1,X), Disk(2,0,X))
  val winningD2 = List(Disk(2,1,O), Disk(1,2,O), Disk(0,3,O), Disk(3,3,X), Disk(2,0,X))
  val loosingB = List(Disk(3,0,X), Disk(3,1,O), Disk(3,2,X), Disk(3,3,O), Disk(2,0,O))
  println("Vittoria H --> " + checkVictory(winningH))
  println("Vittoria V --> " + checkVictory(winningV))
  println("Vittoria D1 --> " + checkVictory(winningD1))
  println("Vittoria D2 --> " + checkVictory(winningD2))
  println("Sconfitta --> "+ checkVictory(loosingB))*/
