package com.tugasakhir.gostadz.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugasakhir.gostadz.ui.theme.Primary

@Composable
fun OutTextFilled(
    value: String,
    onValueChange: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    text: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        maxLines = 1,
        label = { PopReg12(text = text, color = Color.Gray) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Primary,
            focusedBorderColor = Primary,
        ),
        textStyle = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color.Black
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(320.dp)
            .height(60.dp)
    )
}

@Composable
fun OutTextFilledWhite(
    value: String,
    onValueChange: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    text: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },

        maxLines = 1,
        label = { PopReg12(text = text, color = Color.White) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.White,
            focusedBorderColor = Color.White,
        ),
        textStyle = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color.Black
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(320.dp)
            .height(60.dp)
    )
}


@Composable
fun OutTextInFilled(
    value: String,
    onValueChange: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    text: String,
    width: Dp,
    height: Dp
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        maxLines = 1,
        label = { PopReg12(text = text, color = Color.Gray) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Primary,
            focusedBorderColor = Primary,

            ),
        textStyle = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color.Black
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .width(width)
            .height(height)
    )
}

@Composable

fun OutTextInFilledTW(
    value: String,
    onValueChange: (String) -> Unit = {},
    text: String,
    width: Dp,
    ) {

    OutlinedTextField(
        value = value,
        onValueChange ={ onValueChange(it) },
        maxLines = 1,
        placeholder = { PopReg16(text = text, color = Primary) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Primary,
            focusedBorderColor = Primary,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            ),
        textStyle = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Primary,
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(width)
            .height(55.dp),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = true,
            keyboardType = KeyboardType.Number,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TextFieldSearch(
    modifier: Modifier,
    onChange: (String) -> Unit = {},
    value: String = "",
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = { onChange(it) },
            leadingIcon = { Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search Icon") },
            modifier = Modifier
                .width(220.dp)
                .padding(vertical = 5.dp),
            placeholder = {
                Text(
                    text =  "Cari Santri",
                    style = MaterialTheme.typography.bodySmall,
                )
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Primary,
                unfocusedIndicatorColor = Primary,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp),
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search,
                autoCorrect = true
            ),
            keyboardActions = KeyboardActions(onSearch = {
                focusManager.clearFocus()
                keyboardController?.hide()
            })
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOutLinedChooseFieldInfaq() {
    TextFieldSearch(
        modifier = Modifier,
        value = "",
        onChange = {

        },
    )
}
