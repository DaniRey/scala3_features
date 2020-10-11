package ch.danirey.givens

import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.{ArrayBlockingQueue, ThreadPoolExecutor}

import scala.concurrent.{ExecutionContext, Future}

object ImportAllGiven extends App {
  import scala.concurrent.ExecutionContext.Implicits._

  Future(3 * 3)
    .onComplete(x => println(x))
}

object ImportASingleGiven extends App {
  import scala.concurrent.ExecutionContext.Implicits.global

  Future(3 * 3)
    .onComplete(x => println(x))
}

object DefiningOurOwnGiven extends App {
  given ExecutionContext = ExecutionContext.fromExecutor(
    new ThreadPoolExecutor(1, 1, 100, MILLISECONDS, new ArrayBlockingQueue[Runnable](10)))

  Future(3 * 3)
    .onComplete(x => println(x))
}