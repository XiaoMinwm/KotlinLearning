package com.phicode.xm.testkotlin.delegate

import java.lang.reflect.Type
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by XiaoMin on 2017/11/22.
 */
class Example {
    var p: String by Delegate()
}

// 委托的类
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 这里委托了 ${property.name} 属性"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}

val lazyValue: String by lazy {
    val aa = "kkk"     // 第一次调用输出，第二次调用不执行
    println(aa)
    "Hello"
    "jj"
}

class Foo {
    var notNullBar: String by Delegates.notNull<String>()
}

class C {
    var prop: Type by MyDelegate()
}

class MyDelegate : ReadWriteProperty<C, Type> {
    override fun getValue(thisRef: C, property: KProperty<*>): Type {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setValue(thisRef: C, property: KProperty<*>, value: Type) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

fun main(args: Array<String>) {
    /*val e = Example()
    println(e.p)     // 访问该属性，调用 getValue() 函数

    e.p = "Runoob"   // 调用 setValue() 函数
    println(e.p)*/
//    println(lazyValue)   // 第一次执行，执行两次输出表达式
//    println(lazyValue)   // 第二次执行，只输出返回值
    val foo = Foo()
    foo.notNullBar = "bar"
    println(foo.notNullBar)
}