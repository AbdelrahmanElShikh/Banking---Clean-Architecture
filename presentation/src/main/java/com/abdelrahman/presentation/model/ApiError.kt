package com.abdelrahman.presentation.model


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class ApiError(
    val errorMsg : String?,
    val errorCode : Int?,
    val extras : Map<String,Any>?
)