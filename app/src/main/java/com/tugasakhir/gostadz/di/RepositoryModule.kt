package com.tugasakhir.gostadz.di

import com.tugasakhir.gostadz.data.repository.AuthImpl
import com.tugasakhir.gostadz.data.repository.FirebaseRepostoryImpl
import com.tugasakhir.gostadz.data.repository.MidtransRepositoryImpl
import com.tugasakhir.gostadz.domain.repository.Auth
import com.tugasakhir.gostadz.domain.repository.FirebaseRepository
import com.tugasakhir.gostadz.domain.repository.MidtransRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<Auth> {
        AuthImpl(auth = get())
    }
    factory<FirebaseRepository> {
        FirebaseRepostoryImpl(db = get())
    }
    factory<MidtransRepository> {
        MidtransRepositoryImpl(androidContext())
    }
}