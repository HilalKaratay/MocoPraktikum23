package com.example.mocopraktikum23.screens

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mocopraktikum23.AppViewModelProvider
import com.example.mocopraktikum23.screens.menu.MenuViewModel

@Composable
fun MenuScreen(
    menuViewModel: MenuViewModel= androidx.lifecycle.viewmodel.compose.viewModel(factory = AppViewModelProvider.Factory)
){
Column(modifier = Modifier.padding(2.dp)) {
    Text(text = "Das ist mein Menü")

}
}
