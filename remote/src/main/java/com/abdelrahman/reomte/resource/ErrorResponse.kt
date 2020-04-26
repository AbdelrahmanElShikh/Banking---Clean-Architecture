package com.abdelrahman.reomte.resource

import com.google.gson.annotations.SerializedName


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
data class ErrorResponse(
    @SerializedName(value = "error_description") val errorMsg:String,
    @SerializedName("additional") val extras:HashMap<String, Any>
)