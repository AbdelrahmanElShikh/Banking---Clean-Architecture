package com.abdelrahman.reomte.mapper

import com.abdelrahman.data.model.TransactionData
import com.abdelrahman.reomte.model.TransactionRemote
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 19-Apr-20.
 */
class TransactionRemoteMapper @Inject constructor() : Mapper<TransactionRemote, TransactionData>() {
    override fun map(input: TransactionRemote): TransactionData {
        return TransactionData(
            input.transactionId,
            input.type,
            input.amountInCents,
            input.commaSeparatedTags,
            input.timestamp,
            input.flagged,
            input.remarks
        )
    }
}