package com.abdelrahman.presentation.mapper

import com.abdelrahman.domain.entities.TransactionDomain
import com.abdelrahman.presentation.model.TransactionUi
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 16-Apr-20.
 */
class TransactionUiMapper @Inject constructor():Mapper<TransactionDomain,TransactionUi>() {
    override fun map(input: TransactionDomain?): TransactionUi {
        return TransactionUi(
            input!!.transactionId,
            input.type,
            input.amountInCents,
            input.commaSeparatedTags,
            input.timestamp,
            input.flagged,
            input.remarks,
            input.isHVT
        )
    }
}