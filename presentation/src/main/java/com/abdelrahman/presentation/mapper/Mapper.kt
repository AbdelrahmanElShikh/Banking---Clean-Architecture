package com.abdelrahman.presentation.mapper

import java.util.*


/**
 *@author: Abdel-Rahman El-Shikh on 16-Apr-20.
 */
abstract class Mapper<INPUT, OUTPUT> {
    abstract fun map(input: INPUT?): OUTPUT
    fun map(inList: List<INPUT>?): List<OUTPUT> {
        val outList: ArrayList<OUTPUT> = ArrayList()
        for (input in inList!!)
            outList.add(map(input))
        return outList
    }
}