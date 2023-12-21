package com.tugasakhir.gostadz.presentation.infaq_screen

data class InfaqState(
    val amount:String = "",
    val selected1:Boolean = false,
    val selected2: Boolean = false,
    val selected3: Boolean = false,
    val errorMessage:String = "",
    val successMessage:String = "",
    val redirectUrl:String = "",
)
