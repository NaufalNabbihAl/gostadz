package com.tugasakhir.gostadz.presentation.add_santri_screen

sealed class AddSantriEvent {
    data class OnFullNameChanged(val full_name: String) : AddSantriEvent()
    data class OnAddressChanged(val address: String) : AddSantriEvent()
    data class OnGenderChanged(val gender: String) : AddSantriEvent()
    data class OnDateChanged(val date: String) : AddSantriEvent()
    data class OnEmailChanged(val email: String) : AddSantriEvent()
    data class OnPasswordChanged(val password: String) : AddSantriEvent()
    data class DialogErrorDismissed(val message: String) : AddSantriEvent()
    data class DialogSuccessDismissed(val message: String) : AddSantriEvent()
    object OnSubmit : AddSantriEvent()
}