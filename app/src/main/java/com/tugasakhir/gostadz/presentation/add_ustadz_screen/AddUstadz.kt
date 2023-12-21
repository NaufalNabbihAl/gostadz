package com.tugasakhir.gostadz.presentation.add_ustadz_screen

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
import com.tugasakhir.gostadz.ui.theme.Gray
import com.tugasakhir.gostadz.ui.theme.Primary
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddUstadz(navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(35.dp)
    ) {
        BackButton(onClick = {}, "Daftar Ustadz/Ustadzah")
        Spacer(modifier = Modifier.padding(16.dp))
        PopSemi24("Tambah", Black)
        PopSemi24("Ustadz/Ustadzah", Primary)
        Spacer(modifier = Modifier.padding(8.dp))

        OutTextInFilled(
            value = "",
            text = "Fullname",
            onValueChange = {},
            height = 60.dp,
            width = 358.dp
        )

        OutTextInFilled(
            value = "",
            text = "Email",
            onValueChange = {},
            height = 60.dp,
            width = 358.dp
        )
        OutTextInFilled(
            value = "",
            text = "Address",
            onValueChange = {},
            height = 60.dp,
            width = 358.dp
        )

        var isExpanded by remember {
            mutableStateOf(false)
        }

        var gender by remember {
            mutableStateOf("")
        }
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { newValue ->
                isExpanded = newValue
            },
        ) {
            OutlinedTextField(
                value = gender,
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
                        gender = "Male"
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
                        gender = "Female"
                        isExpanded = false
                    },

                    )
            }
        }
        var password by rememberSaveable { mutableStateOf("") }
        var passwordHidden by rememberSaveable { mutableStateOf(true) }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
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
            onValueChange = { },
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
        GButton(text = "Tambah", onClick = {}, modifier = Modifier.width(358.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddUstadz() {

}