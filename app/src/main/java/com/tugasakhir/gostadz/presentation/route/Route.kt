package com.tugasakhir.gostadz.presentation.route

sealed class Route(val route: String) {
    object GetStarted : Route("getStarted")
    object Home : Route("home")
    object HomeAdmin : Route("homeAdmin")
    object LoginMasjid : Route("loginMasjid")
    object LoginTpq : Route("loginTpq")
    object MainMenuAdmin : Route("mainMenuAdmin")
    object MainMenuMasjid : Route("mainMenuMasjid")
    object Santri : Route("santri")
    object AddSantri : Route("addSantri")
    object DaftarSantri : Route("daftarSantri")
    object DaftarUstadz : Route("daftarUstadz")
    object AddUstadz : Route("addUstadz")
    object Infaq : Route("infaq")
    object JadwalKegiatan : Route("jadwalKegiatan")
}