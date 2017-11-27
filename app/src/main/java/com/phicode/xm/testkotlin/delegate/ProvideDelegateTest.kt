package com.phicode.xm.testkotlin.delegate

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by XiaoMin on 2017/11/25.
 */
class ResourceID() {
    val image_id: String = "101"
    val text_id: String = "102"
}

class ResourceLoader<T>(id: ResourceID) {
    val d: ResourceID = id
    operator fun provideDelegate( thisRef: MyUI, prop: KProperty<*> ): DellImpl {
        if(checkProperty(thisRef, prop.name)){
            return DellImpl(d)
        }else{
            throw Exception("Error ${prop.name}")
        }
    }

    private fun checkProperty(thisRef: MyUI, name: String):Boolean {
        if(name.equals("image") || name.equals("text")){
            return true
        }else{
            return false
        }
    }
}

class DellImpl(d: ResourceID) : ReadOnlyProperty<MyUI, String> {
    val id: ResourceID = d
    override fun getValue(thisRef: MyUI, property: KProperty<*>): String {
        if(property.name.equals("image"))
            return property.name+"  "+id.image_id
        else
            return property.name+"  "+id.text_id
    }
}

fun  <T> bindResource(id: ResourceID): ResourceLoader<T> {
    return ResourceLoader(id)
}

class MyUI {
    val image by bindResource<String>(ResourceID())
    val text by bindResource<String>(ResourceID())
    //val webview by bindResource(ResourceID())
}

fun main(args: Array<String>) {
    try{
        var ui = MyUI()
        println(ui.image)
        println(ui.text)
    }catch(e: Exception) {
        println(e.message)
    }
}