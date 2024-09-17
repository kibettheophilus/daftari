package com.theophiluskibet.daftari

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Daftari",
    ) {
        App()
    }
}