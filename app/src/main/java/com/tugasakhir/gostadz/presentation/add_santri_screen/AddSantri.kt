package com.tugasakhir.gostadz.presentation.add_santri_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tugasakhir.gostadz.ui.component.*
import com.tugasakhir.gostadz.ui.theme.Black
import com.tugasakhir.gostadz.ui.theme.GostadzTheme
import com.tugasakhir.gostadz.ui.theme.Gray
import com.tugasakhir.gostadz.ui.theme.Primary
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import org.koin.androidx.compose.getViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSantri(navController: NavHostController, viewModel: AddSantriViewModel = getViewModel()) {
    val state = viewModel.state
    Column(
        modifier = Modifier
            .padding(35.dp)
    ) {
        BackButton(onClick = {
            navController.navigateUp()
        }, "Daftar Santri")
        Spacer(modifier = Modifier.padding(16.dp))
        PopSemi24("Tambah", Black)
        PopSemi24("Santri", Primary)
        Spacer(modifier = Modifier.padding(8.dp))

        OutTextInFilled(
            value = state.full_name,
            text = "Fullname",
            onValueChange = {
                viewModel.onEvent(AddSantriEvent.OnFullNameChanged(it))
            },
            height = 60.dp,
            width = 358.dp
        )
        OutTextInFilled(
            value = state.email,
            text = "Email",
            onValueChange = {
                viewModel.onEvent(AddSantriEvent.OnEmailChanged(it))
            },
            height = 60.dp,
            width = 358.dp
        )
        OutTextInFilled(
            value = state.address,
            text = "Address",
            onValueChange = {
                viewModel.onEvent(AddSantriEvent.OnAddressChanged(it))
            },
            height = 60.dp,
            width = 358.dp
        )

        var isExpanded by remember {
            mutableStateOf(false)
        }
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { newValue ->
                isExpanded = newValue
            },
        ) {
            OutlinedTextField(
                value = state.gender,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                placeholder = {
                    Text(
                        text = "Please select your gender",
                        fontFamily = poppins,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = Gray
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(
                    unfocusedIndicatorColor = Primary,
                    focusedIndicatorColor = Primary,
                    focusedTrailingIconColor = Primary,
                    unfocusedTrailingIconColor = Primary,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(358.dp)
                    .padding(top = 8.dp)
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = {
                    isExpanded = false
                },
                modifier = Modifier
                    .background(Color.White)
            ) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Male",
                            fontFamily = poppins,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    },
                    onClick = {
                        viewModel.onEvent(AddSantriEvent.OnGenderChanged("Male"))
                        isExpanded = false
                    },
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Female",
                            fontFamily = poppins,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = Color.Black

                        )
                    },
                    onClick = {
                        viewModel.onEvent(AddSantriEvent.OnGenderChanged("Female"))
                        isExpanded = false
                    },

                    )
            }
        }
        var passwordHidden by rememberSaveable { mutableStateOf(true) }
        OutlinedTextField(
            value = state.password,
            onValueChange = { viewModel.onEvent(AddSantriEvent.OnPasswordChanged(it)) },
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Primary,
                focusedBorderColor = Primary,
            ),
            label = {
                Text(
                    "Enter password",
                    fontFamily = poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Gray
                )
            },
            visualTransformation =
            if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(
                    onClick = { passwordHidden = !passwordHidden },
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = if (passwordHidden) Color.Gray else Color.Black
                    )
                ) {
                    val visibilityIcon =
                        if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    val description = if (passwordHidden) "Show password" else "Hide password"
                    Icon(imageVector = visibilityIcon, contentDescription = description)
                }
            },
            modifier = Modifier
                .width(358.dp)
                .height(60.dp)
        )
        var pickedDate by remember {
            mutableStateOf<LocalDate?>(null)
        }

        val formattedDate by remember(pickedDate) {
            derivedStateOf {
                pickedDate?.let {
                    DateTimeFormatter
                        .ofPattern("MMM dd yyyy")
                        .format(it)
                } ?: ""
            }
        }

        val dateDialogState = rememberMaterialDialogState()

        OutlinedTextField(
            value = formattedDate,
            onValueChange = {
                viewModel.onEvent(AddSantriEvent.OnDateChanged(formattedDate))
            },
            modifier = Modifier
                .width(358.dp)
                .height(60.dp)
                .padding(top = 8.dp),
            shape = RoundedCornerShape(10.dp),
            placeholder = {
                Text(
                    text = "Pick a date",
                    fontFamily = poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Gray
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Primary,
                focusedBorderColor = Primary,
            ),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = {
                    dateDialogState.show()
                }) {
                    Icon(Icons.Filled.DateRange, contentDescription = null)
                }
            },
        )
        MaterialDialog(
            dialogState = dateDialogState,
            buttons = {
                positiveButton(text = "Ok") {}
                negativeButton(text = "Cancel")
            }
        ) {
            datepicker(
                initialDate = LocalDate.now(),
                title = "Pick a date",
            ) {
                pickedDate = it
            }
        }
        Spacer(modifier = Modifier.padding(top = 16.dp))
        GButton(text = "Tambah", onClick = {
            viewModel.onEvent(AddSantriEvent.OnSubmit)
        }, modifier = Modifier.width(358.dp))

        if (state.errorMessage.isNotBlank()) {
            AlertDialog(title = { Text("Error") },
                text = { Text(state.errorMessage) },
                confirmButton = {
                    Button(
                        onClick = {
                            viewModel.onEvent(AddSantriEvent.DialogErrorDismissed(""))
                        }
                    ) {
                        Text("OK")
                    }
                },
                onDismissRequest = {
                    viewModel.onEvent(AddSantriEvent.DialogErrorDismissed(""))
                }
            )
        }
        if (state.successMessage.isNotBlank()) {
            AlertDialog(title = { Text("Success") },
                text = { Text(state.successMessage) },
                confirmButton = {
                    Button(
                        onClick = {
                            viewModel.onEvent(AddSantriEvent.DialogSuccessDismissed(""))
                        }
                    ) {
                        Text("OK")
                    }
                },
                onDismissRequest = {
                    viewModel.onEvent(AddSantriEvent.DialogSuccessDismissed(""))
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAddSantri() {
    GostadzTheme {

    }
}