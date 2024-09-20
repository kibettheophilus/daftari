package com.theophiluskibet.daftari

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.theophiluskibet.daftari.presentation.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Daftari",
    ) {
        App()
    }
}