package com.tugasakhir.gostadz.di

import com.tugasakhir.gostadz.domain.use_case.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val useCaseModules = module {
    single {
        LoginUseCase(repo = get())
    }
    single {
        ValidatePassword(androidContext())
    }
    single {
        ValidateEmail(androidContext())
    }
    single {
        GetSantri(repository = get())
    }
    single {
        GetUstadz(repository = get())
    }
    single {
        CreateMidtrans(midtransRepository = get())
    }
}