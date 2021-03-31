package com.example.coroutinesapi

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun printFibonacciSeries(lastTerm: Int) {
    var first = 0; var second = 1; var third = 0;
    for (i in 1..lastTerm) {
        print(" $first")
        third = first + second;
        first = second;
        second = third;
        delay(300) //delay of 300ms
    }
}
suspend fun main() {
    GlobalScope.launch { // to launch a coroutine in background and continue
        printFibonacciSeries(10) // print series after delay
    }
    println("Fibonacci Series:")//main thread continues here immediately
    delay(2000)// delay for 2 seconds to keep JVM alive
}