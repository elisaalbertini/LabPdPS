package u06lab.code

import u06lab.code.ConnectThree.Board

import java.util.OptionalInt
import scala.annotation.tailrec
import scala.language.postfixOps
import scala.util.control.Breaks

object ConnectThree extends App:
  val bound = 3
  enum Player:
    case X, O
    def other: Player = this match
      case X => O
      case _ => X

 //TODO SISTEMARE CONTROLLO SULLA VINCITA
 //todo togli la doppia funzione
 //todo togli commenti
 //todo fare test (?)
 //todo controllare le altre classi
  case class Disk(x: Int, y: Int, player: Player)
  /**
   * Board:
   * y
   *
   * 3
   * 2
   * 1
   * 0
   *   0 1 2 3 <-- x
   */
  type Board = Seq[Disk]
  type Game = Seq[Board]

  import Player.*

  def find(board: Board, x: Int, y: Int): Option[Player] =
    board.find(d => d.x == x && d.y == y) match
    case Some(a) => Some(a.player)
    case _ => None

  def firstAvailableRow(board: Board, x: Int): Option[Int] =
    board.filter(d => d.x == x).map(d => d.y).sortWith(_ > _) match
      case rows if rows.nonEmpty => rows.head match
        case r if r == bound => None
        case r => Some(r + 1)
      case _ => Some(0)

  private def newBoard(board: Board, row: Int, player: Player): Board =
    firstAvailableRow(board, row) match
      case Some(c) =>
        board :+ Disk(row, c, player)
      case _ => board

  def placeAnyDisk(board: Board, player: Player): Seq[Board] =
    var boards = Seq[Board]()
    for r <- 0 to bound do
      val newB = newBoard(board, r, player)
      if !newB.equals(board) then boards = boards :+ newB
    boards

  def computeAnyGame(player: Player, moves: Int): LazyList[Game] =
    moves > 0 match
      case true =>
        for
          game <- computeAnyGame(player.other, moves-1)
          board <- placeAnyDisk(game.head, player) //calcolo tutte le combinazioni --> a me interessa solo l'ultima board che è in testa
        yield
          board +: game //aggiungo la nuova board in testa
      case _ => LazyList(Seq(Seq())) //tutte le board vuote --> è l'inizio del gioco

  def compareThree(p1: Option[Player], p2: Option[Player], p3: Option[Player]): Boolean =
    (p1, p2, p3) match
      case (Some(a), Some(b), Some(c)) => a == b && b == c
      case _ => false

  def checkHorizontal(board: Board, x:Int, y: Int): Boolean =
    compareThree(find(board, x, y), find(board, x, y+1), find(board, x, y-1))

  def checkVertical(board: Board, x:Int, y: Int): Boolean =
    compareThree(find(board, x, y), find(board, x+1, y), find(board, x-1, y))

  def checkSinisterDiagonal(board: Board, x:Int, y: Int): Boolean =
    compareThree(find(board, x, y), find(board, x+1, y+1), find(board, x-1, y-1))

  def checkDexterDiagonal(board: Board, x:Int, y: Int): Boolean =
    compareThree(find(board, x, y), find(board, x+1, y-1), find(board, x-1, y+1))

  def checkVictory(board: Board): Boolean =
    var won = false
    for disk <- board do won = won || checkHorizontal(board, disk.x, disk.y)
      || checkVertical(board, disk.x, disk.y)
      || checkSinisterDiagonal(board, disk.x, disk.y)
      || checkDexterDiagonal(board, disk.x, disk.y)
    won

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

  def computeAnyGameStopWhenWin(player: Player, moves: Int): LazyList[Game] =
    moves > 0 match
      case true =>
        for
          game <- computeAnyGameStopWhenWin(player.other, moves-1)
          board <- placeAnyDisk(game.head, player) //calcolo tutte le combinazioni --> a me interessa solo l'ultima board che è in testa
          if !game.exists(b => checkVictory(b)) //todo così cava tutti quelli vincenti --> vanno riaggiunti in qualche modo :/
        yield
          board +: game //aggiungo la nuova board in testa
      case _ => LazyList(Seq(Seq())) //tutte le board vuote --> è l'inizio del gioco

  /*computeAnyGameStopWhenWin(O, 5).foreach { g =>
    printBoards(g)
    println()
  }*/

  def printBoards(game: Seq[Board]): Unit =
    for
      y <- bound to 0 by -1
      board <- game.reverse
      x <- 0 to bound
    do
      print(find(board, x, y).map(_.toString).getOrElse("."))
      if x == bound then
        print(" ")
        if board == game.head then println()

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
