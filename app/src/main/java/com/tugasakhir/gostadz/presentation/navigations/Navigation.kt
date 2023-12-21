package com.tugasakhir.gostadz.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tugasakhir.gostadz.presentation.add_santri_screen.AddSantri
import com.tugasakhir.gostadz.presentation.add_ustadz_screen.AddUstadz
import com.tugasakhir.gostadz.presentation.daftar_santri_screen.DaftarSantri
import com.tugasakhir.gostadz.presentation.daftar_ustadz_screen.DaftarUstadz
import com.tugasakhir.gostadz.presentation.getstarted_screen.GetStartedScreen
import com.tugasakhir.gostadz.presentation.home_admin_screen.HomeAdmin
import com.tugasakhir.gostadz.presentation.home_screen.Home
import com.tugasakhir.gostadz.presentation.infaq_screen.Infaq
import com.tugasakhir.gostadz.presentation.jadwal_kegiatan_screen.JadwalKegiatan
import com.tugasakhir.gostadz.presentation.login_masjid_screen.LoginMasjid
import com.tugasakhir.gostadz.presentation.login_tpq_screen.LoginTpq
import com.tugasakhir.gostadz.presentation.mainmenu_admin_masjid_screen.MainMenuAdmin
import com.tugasakhir.gostadz.presentation.mainmenu_masjid_screen.MainMenuMasjid
import com.tugasakhir.gostadz.presentation.route.Route

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController,startDestination = Route.GetStarted.route){
        composable(Route.GetStarted.route){
            GetStartedScreen(navController = navController)
        }
        composable(route = Route.LoginMasjid.route){
            LoginMasjid(navController = navController)
        }
        composable(route = Route.HomeAdmin.route){
            HomeAdmin(navController = navController)
        }
        composable(route = Route.Home.route){
            Home(navController = navController)
        }
        composable(route = Route.LoginTpq.route){
            LoginTpq(navController = navController)
        }
        composable(route = Route.MainMenuAdmin.route){
            MainMenuAdmin(navController = navController)
        }
        composable(route = Route.MainMenuMasjid.route){
            MainMenuMasjid(navController = navController)
        }
//        composable(route = Route.Santri.route){
//            Santri(navController = navController)
//        }
        composable(route = Route.AddSantri.route){
            AddSantri(navController = navController)
        }
        composable(route = Route.AddUstadz.route){
            AddUstadz(navController = navController)
        }
        composable(route = Route.DaftarSantri.route){
            DaftarSantri(navController = navController)
        }
        composable(route = Route.DaftarUstadz.route){
            DaftarUstadz(navController = navController)
        }
        composable(route = Route.Infaq.route){
            Infaq(navController = navController)
        }
        composable(route = Route.JadwalKegiatan.route){
            JadwalKegiatan(navController = navController)
        }

    }
}

