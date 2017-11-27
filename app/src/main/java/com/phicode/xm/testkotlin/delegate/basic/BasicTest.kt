package com.phicode.xm.testkotlin.delegate.basic

import java.lang.Integer.parseInt

/**
 * Created by XiaoMin on 2017/11/25.
 */
fun vars(vararg vars: Int) {
    for (a in vars) {
        println(a)
    }
}

fun main(args: Array<String>) {
    /*f (args.size < 2) {
        print("Two integers expected")
        return
    }
    val x = parseInt2(args[0])
    val y = parseInt2(args[1]);
    // 直接使用 `x * y` 会导致错误, 因为它们可能为 null.
    if (x != null && y != null) {
        // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
        print(x * y)
    }
    print("ss")*/

    /*//[1,2,3]
    val a = arrayOf(1, 2, 3)
    //[0,2,4]
    val b = Array(3, { i -> (i * 2) })

    //读取数组内容
    println(a[0])    // 输出结果：1
    println(b[1])    // 输出结果：2*/

    //print(hasPrefix("prefixDD"))
    val fruits = listOf("apple", "banana", "orange")
    for (fruit in fruits) {
        println(fruit)
    }

    for (i in fruits.indices) {
        println("fruit at $i is ${fruits[i]}")
    }
}

fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}

fun parseInt2(str: String): Int? {
    val s: Int
    try {
        s = parseInt(str)
    } catch (e: NumberFormatException) {
        return null
    }
    return s
}
