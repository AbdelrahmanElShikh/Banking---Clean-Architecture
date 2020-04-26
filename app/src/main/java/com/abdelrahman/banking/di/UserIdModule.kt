package com.abdelrahman.banking.di

import com.abdelrahman.presentation.qualifier.UserId
import dagger.Module
import dagger.Provides


/**
 *@author: Abdel-Rahman El-Shikh on 24-Apr-20.
 */

@Module
class UserIdModule {
    @Provides
    @UserId
    fun providesUserID(): String = "REH99PAG4EW5"
}