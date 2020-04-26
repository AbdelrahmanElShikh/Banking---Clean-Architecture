package com.abdelrahman.data.mapper

import com.abdelrahman.data.model.TransactionData
import com.abdelrahman.domain.entities.TransactionDomain
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 19-Apr-20.
 */
class TransactionDataMapper @Inject constructor() : Mapper<TransactionData, TransactionDomain>() {
    override fun map(input: TransactionData?): TransactionDomain {
        return TransactionDomain(
            input!!.transactionId,
            input.type,
            input.amountInCents,
            input.commaSeparatedTags,
            input.timestamp,
            input.flagged,
            input.remarks
        )
    }


}