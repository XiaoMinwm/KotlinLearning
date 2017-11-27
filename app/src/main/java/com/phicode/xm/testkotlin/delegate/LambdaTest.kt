package com.phicode.xm.testkotlin.delegate

/**
 * Created by XiaoMin on 2017/11/25.
 */
fun foo(ints:List<Int>) {
    ints.forEach {
        if (it == 0) return@forEach
        print(it)
    }
}

fun <T> max(collection: Collection<T>, less: (T, T) -> Boolean): T? {
    var max: T? = null
    for (it in collection)
        if (max == null || less(max, it))
            max = it
    return max
}

fun main(args: Array<String>) {
    //foo(listOf(1,2,3,0,4))
    val less:(Int, Int)->Boolean = {x,y-> x<y }
    val ints = listOf(1,2,3)

    val max = max(ints, less)
    println(max)
}