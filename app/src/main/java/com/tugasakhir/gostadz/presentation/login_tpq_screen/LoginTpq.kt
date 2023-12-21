package com.tugasakhir.gostadz.presentation.login_tpq_screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tugasakhir.gostadz.R
import com.tugasakhir.gostadz.presentation.route.Route
import com.tugasakhir.gostadz.ui.component.*
import com.tugasakhir.gostadz.ui.theme.Black
import com.tugasakhir.gostadz.ui.theme.Primary
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginTpq(viewModel: LoginFormViewModel = getViewModel(),navController:NavHostController){


    val email = viewModel.state.email
    val password = viewModel.state.password
    val context = LocalContext.current

    LaunchedEffect(true) {
        viewModel.loginEvents.collect { event ->
            when (event) {
                is LoginFormViewModel.LoginEvent.Loading -> {
//                    Toast.makeText(context, "Login Loading", Toast.LENGTH_SHORT).show()
                    viewModel.onEvent(LoginFormEvent.Loading(true))
                }

                is LoginFormViewModel.LoginEvent.Success -> {
                    viewModel.onEvent(LoginFormEvent.Loading(false))
                    Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                    navController.navigate(Route.HomeAdmin.route)
                }

                is LoginFormViewModel.LoginEvent.Error -> {
                    viewModel.onEvent(LoginFormEvent.Loading(false))
                    Toast.makeText(context, "Login Error", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }


    Column(
        modifier = Modifier
            .padding(top = 54.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize(),
    ) {
        BackButton(onClick = { navController.navigate(Route.Home.route) }, text = stringResource(id = R.string.PilihJenis))
        Spacer(modifier = Modifier.padding(top = 88.dp))
        Column{
            PopSem32(text = stringResource(id = R.string.SignIn), color = Black)
            IbmSem32(text = stringResource(id = R.string.TPQ), color = Primary)

            Spacer(modifier = Modifier.padding(top = 24.dp))

            OutTextFilled(value = email, { viewModel.onEvent(LoginFormEvent.EmailChanged(it)) }, text = "Email")

            Spacer(modifier = Modifier.padding(top = 16.dp))

            var passwordHidden by rememberSaveable { mutableStateOf(true) }
            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.onEvent(LoginFormEvent.PasswordChanged(it)) },
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Primary,
                    focusedBorderColor = Primary,
                ),
                label = { Text("Enter password") },
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
                    .width(320.dp)
                    .height(60.dp)
            )
            Spacer(modifier = Modifier.padding(top = 32.dp))
            GButton(text = stringResource(id = R.string.Login), onClick = {
                viewModel.onEvent(LoginFormEvent.Submit)
            })

        }

        if (viewModel.state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator(
                    color = Primary,
                    modifier = Modifier
                        .size(50.dp)
                )
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {

}