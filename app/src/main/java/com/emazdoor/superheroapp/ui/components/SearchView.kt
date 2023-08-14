package com.emazdoor.superheroapp.ui.components

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


/**
 * A search view for searching for superheros. User can type in a search term and then press the search button.
 * @param modifier any modifiers to apply to the search view
 * @param context any context
 * @param onSearchTermChange function to call when the search term changes
* */
@Composable
fun SearchView(
    modifier: Modifier = Modifier,
    context: Context,
    onSearchTermChange: (String) -> Unit = {}
) = Surface(
    color = Color.LightGray, modifier = modifier.padding(16.dp),
    shape = RoundedCornerShape(5.dp)
) {
    var searchTerm by remember { mutableStateOf(TextFieldValue()) }
    BasicTextField(
        value = searchTerm,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                hideKeyboard(context)
            }
        ),
        onValueChange = {
            searchTerm = it
            onSearchTermChange(it.text)
        }
    )
}


fun hideKeyboard(context: Context) {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
}