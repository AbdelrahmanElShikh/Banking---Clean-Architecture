package com.abdelrahman.presentation.model


/**
 *@author: Abdel-Rahman El-Shikh on 16-Apr-20.
 */
data class TransactionUi(
    val transactionId: String,
    val type: String,
    val amountInCents: Long,
    val commaSeparatedTags: String,
    val timestamp: Long,
    val flagged: Boolean,
    val remarks: String,
    val isHVT: Boolean
)