package com.tugasakhir.gostadz.di

import com.tugasakhir.gostadz.presentation.add_santri_screen.AddSantriViewModel
import com.tugasakhir.gostadz.presentation.daftar_santri_screen.DaftarSantriViewModel
import com.tugasakhir.gostadz.presentation.daftar_ustadz_screen.DaftarUstadzViewModel
import com.tugasakhir.gostadz.presentation.infaq_screen.InfaqViewModel
import com.tugasakhir.gostadz.presentation.jadwal_kegiatan_screen.JadwalKegiatanViewModel
import com.tugasakhir.gostadz.presentation.laporan_mengaji_screen.LaporanMengajiViewModel
import com.tugasakhir.gostadz.presentation.login_tpq_screen.LoginFormViewModel
import com.tugasakhir.gostadz.presentation.menu_video_screen.MenuVideoViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel {
        LoginFormViewModel(login = get(), validateEmail = get(), validatePassword = get())
    }
    viewModel {
        DaftarSantriViewModel(getSantri = get())
    }
    viewModel {
        InfaqViewModel(db = get(), context = androidContext())
    }

    viewModel {
        DaftarUstadzViewModel(getUstadz = get())
    }

    viewModel {
        JadwalKegiatanViewModel(db = get())
    }
    viewModel {
        MenuVideoViewModel(db = get())
    }
    viewModel {
        LaporanMengajiViewModel(getSantri = get())
    }
    viewModel {
        AddSantriViewModel(firebaseAuth = get(), firebaseFirestore = get(), context = androidContext())
    }

}