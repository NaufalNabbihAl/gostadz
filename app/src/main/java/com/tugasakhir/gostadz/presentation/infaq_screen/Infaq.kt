package com.tugasakhir.gostadz.presentation.infaq_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tugasakhir.gostadz.R
import com.tugasakhir.gostadz.ui.component.BackButton
import com.tugasakhir.gostadz.ui.component.GButton
import com.tugasakhir.gostadz.ui.component.OutTextInFilledTW
import com.tugasakhir.gostadz.ui.component.PopSemi24
import com.tugasakhir.gostadz.ui.theme.Black
import com.tugasakhir.gostadz.ui.theme.Primary
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Infaq(viewModel: InfaqViewModel = getViewModel(), navController: NavHostController,) {

    val state = viewModel.state
    val scope  = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Spacer(modifier = Modifier.padding(top = 44.dp))

        Column(
            modifier = Modifier
                .padding(start = 24.dp)
        ) {
            BackButton(onClick = { navController.navigateUp() }, text = stringResource(id = R.string.PilihJenis))
        }

        Spacer(modifier = Modifier.padding(top = 34.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PopSemi24(text = stringResource(id = R.string.PilihNominal), color = Black)

            Image(painter = painterResource(id = R.drawable.iconmenuinfaq), contentDescription = "iconMenuInfaq")

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FilterChip(
                    modifier = Modifier.width(102.dp),
                    onClick = {
                        viewModel.onEvent(InfaqEvent.Selected1(!state.selected1))
                        viewModel.onEvent(InfaqEvent.FormChanged("25000"))
                    },
                    label = {
                        Text(
                            "25.000",
                            color = Primary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    },
                    selected = state.selected1,
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color.White,
                        selectedLeadingIconColor = Primary,
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        selectedBorderColor = Primary,
                        borderColor = Primary
                    ),
                    leadingIcon = if (state.selected1) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize),
                            )
                        }
                    } else {
                        null
                    },
                )
                Spacer(modifier = Modifier.padding(start = 8.dp))
                FilterChip(
                    modifier = Modifier.width(102.dp),
                    onClick = {
                        viewModel.onEvent(InfaqEvent.Selected2(!state.selected2))
                        viewModel.onEvent(InfaqEvent.FormChanged("50000"))
                    },
                    label = {
                        Text(
                            "50.000",
                            color = Primary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    },
                    selected = state.selected2,
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color.White,
                        selectedLeadingIconColor = Primary,
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        selectedBorderColor = Primary,
                        borderColor = Primary
                    ),
                    leadingIcon = if (state.selected2) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else {
                        null
                    },
                )
                Spacer(modifier = Modifier.padding(start = 8.dp))
                FilterChip(
                    modifier = Modifier.width(102.dp),
                    onClick = {
                        viewModel.onEvent(InfaqEvent.Selected3(!state.selected3))
                        viewModel.onEvent(InfaqEvent.FormChanged("100000"))
                    },
                    label = {
                        Text(
                            "100.000",
                            color = Primary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    },
                    selected = state.selected3,
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color.White,
                        selectedLeadingIconColor = Primary,
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        selectedBorderColor = Primary,
                        borderColor = Primary
                    ),
                    leadingIcon = if (state.selected3) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else {
                        null
                    },
                )
            }

            OutTextInFilledTW(
                value = state.amount,
                onValueChange = { viewModel.onEvent(InfaqEvent.FormChanged(it)) },
                "Isi nominal lain",
                width = 318.dp,
            )
            Spacer(modifier = Modifier.padding(top = 32.dp))
            GButton("Lanjutkan", onClick = {
                scope.launch {
                    viewModel.onEvent(InfaqEvent.Pay)
                }
            })
            if (state.errorMessage.isNotBlank()) {
                AlertDialog(title = { Text("Error") },
                    text = { Text(state.errorMessage) },
                    confirmButton = {
                        Button(
                            onClick = {
                                viewModel.onEvent(InfaqEvent.DialogErrorDismissed(""))
                            }
                        ) {
                            Text("OK")
                        }
                    },
                    onDismissRequest = {
                        viewModel.onEvent(InfaqEvent.DialogErrorDismissed(""))
                    }
                )
            }
            if (state.successMessage.isNotBlank()) {
                AlertDialog(title = { Text("Success") },
                    text = { Text(state.successMessage) },
                    confirmButton = {
                        Button(
                            onClick = {
                                viewModel.onEvent(InfaqEvent.DialogSuccessDismissed(""))
                            }
                        ) {
                            Text("OK")
                        }
                    },
                    onDismissRequest = {
                        viewModel.onEvent(InfaqEvent.DialogSuccessDismissed(""))
                    }
                )
            }
        }
    }

    if (state.redirectUrl.isNotEmpty()) {
        val uriHandler = LocalUriHandler.current
        uriHandler.openUri(state.redirectUrl)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInfaq() {
}