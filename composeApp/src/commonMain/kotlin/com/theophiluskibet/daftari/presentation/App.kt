package com.theophiluskibet.daftari.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.theophiluskibet.daftari.presentation.screens.NotesScreen
import com.theophiluskibet.daftari.presentation.screens.registerScreens
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    registerScreens()
    MaterialTheme {
        Navigator(NotesScreen)
    }
}