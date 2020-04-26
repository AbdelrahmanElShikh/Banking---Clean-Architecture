package com.abdelrahman.data.model


/**
 *@author: Abdel-Rahman El-Shikh on 19-Apr-20.
 */
data class TransactionData(
    val transactionId: String,
    val type: String,
    val amountInCents: Long,
    val commaSeparatedTags: String,
    val timestamp: Long,
    val flagged: Boolean,
    val remarks: String
)