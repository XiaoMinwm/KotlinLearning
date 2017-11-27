package com.phicode.xm.testkotlin.delegate

/**
 * Created by XiaoMin on 2017/11/25.
 */
fun main(args: Array<String>) {
    print(Counter(6).plus(8))
}


data class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}