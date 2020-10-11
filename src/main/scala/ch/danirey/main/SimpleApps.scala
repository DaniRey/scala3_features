package ch.danirey.main

/**
 * https://dotty.epfl.ch/docs/reference/changed-features/main-functions.html
 */
@main def helloWorld = println("Hello World")

@main def greet(name: String) = println(s"Hello $name")