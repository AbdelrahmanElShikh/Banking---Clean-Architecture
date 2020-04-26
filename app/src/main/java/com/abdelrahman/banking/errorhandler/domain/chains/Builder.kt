package com.abdelrahman.banking.errorhandler.domain.chains

import com.abdelrahman.banking.errorhandler.domain.handlers.InternetConnectionHandler


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class Builder {
    private var domainErrorChainLinks = ArrayList<DomainErrorChainLink>()

    fun addChain(domainErrorChainLink: DomainErrorChainLink): Builder {
        domainErrorChainLinks.add(domainErrorChainLink)
        return this
    }

    fun setUpChainSequence() {
        if (domainErrorChainLinks.size > 0)
            for (i in 0 until (domainErrorChainLinks.size - 1)) {
                if (i < domainErrorChainLinks.size - 1) {
                    val domainErrorChainLink = domainErrorChainLinks[i]
                    domainErrorChainLink.setNextChain(domainErrorChainLinks[i + 1])
                }
            }
    }

    fun build(): DomainErrorChain {
        setUpChainSequence()
        return DomainErrorChain(
            domainErrorChainLinks[0]
        )
    }


    fun buildWithDefaultChainLinks(): DomainErrorChain {
        domainErrorChainLinks.add(InternetConnectionHandler())
        build()
        return DomainErrorChain(domainErrorChainLinks[0])
    }
}