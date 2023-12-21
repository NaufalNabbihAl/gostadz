package com.tugasakhir.gostadz.presentation.infaq_screen

sealed class InfaqEvent {
    data class Selected1(val selected1 :Boolean) : InfaqEvent()
    data class Selected2(val selected2 :Boolean) : InfaqEvent()
    data class Selected3(val selected3 :Boolean) : InfaqEvent()
    data class FormChanged(val amount:String) : InfaqEvent()
    data class DialogErrorDismissed(val msg:String) : InfaqEvent()
    data class DialogSuccessDismissed(val msg:String) : InfaqEvent()
    object Pay : InfaqEvent()
}