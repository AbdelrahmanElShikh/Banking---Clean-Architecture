package com.abdelrahman.banking.di

import com.abdelrahman.banking.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
@Module
public abstract class FragmentsModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment():MainFragment

}