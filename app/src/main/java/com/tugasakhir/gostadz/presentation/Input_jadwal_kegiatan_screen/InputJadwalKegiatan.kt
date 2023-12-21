package com.tugasakhir.gostadz.presentation.Input_jadwal_kegiatan_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugasakhir.gostadz.ui.component.*
import com.tugasakhir.gostadz.ui.theme.Primary
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun InputJadwalKegiatan() {
    Column() {
        TopBarText(onClick = {}, text = "ADMIN")
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Primary)
            ,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(top = 16.dp))
                PopSemi14(text = "Jadwal Kegiatan", Color.White)
                Spacer(modifier = Modifier.padding(32.dp))
                OutTextFilledWhite(value = "", onValueChange = {}, text = "Nama Kegiatan")
                Spacer(modifier = Modifier.padding(8.dp))

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
                        .width(320.dp)
                        .height(60.dp)
                        .padding(top = 8.dp),
                    shape = RoundedCornerShape(10.dp),
                    placeholder = {
                        Text(
                            text = "Pick a date",
                            fontFamily = poppins,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.White,
                        focusedBorderColor = Color.White,
                    ),
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = {
                            dateDialogState.show()
                        }) {
                            Icon(
                                Icons.Filled.DateRange,
                                contentDescription = null,
                                tint = Color.White
                            )
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
                Spacer(modifier = Modifier.padding(top = 48.dp))
                WButton(text = "Tambah", onClick = {}, modifier = Modifier.width(320.dp))
                Spacer(modifier = Modifier.padding(top = 355.dp))
                HomeBack(onClick = {}, onClick2 = {})
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInputJadwalKegiatan() {
    InputJadwalKegiatan()
}