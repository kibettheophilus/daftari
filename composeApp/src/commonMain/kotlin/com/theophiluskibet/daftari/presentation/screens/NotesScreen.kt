package com.theophiluskibet.daftari.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import cafe.adriel.voyager.core.registry.ScreenProvider
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

sealed class SharedScreen : ScreenProvider {
    data object Notes : SharedScreen()
    data class Details(val id: String) : SharedScreen()
}

fun registerScreens() {
    ScreenRegistry {
        register<SharedScreen.Notes> {
            NotesScreen
        }
        register<SharedScreen.Details> {
            DetailScreen(id = it.id)
        }
    }
}


val module = module {
    single { NoteScreenModel(repo = get(), repo) }
    singleOf(::NoteScreenModel)
}

class Repository {

}

class NoteScreenModel(val repo: Repository, ) : ScreenModel {


    fun updateId() {
        screenModelScope.launch {

        }
    }
}

val uiModule = module {
    single { NoteScreenModel() }
}

object NotesScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow


        val screenModel = koinScreenModel<NoteScreenModel>()


        val detailScreen = rememberScreen(SharedScreen.Details(id = "Mumbi"))

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Hello from Notes")
            Button(onClick = {
                navigator.push(detailScreen)
            }) {
                Text("Click me")
            }
        }
    }
}

data class DetailScreenState(val id: String? = null)

class DetailScreenModel : StateScreenModel<DetailScreenState>(DetailScreenState()) {
    fun updateId(id: String) {
        mutableState.update {
            it.copy(id = id)
        }
    }
}

data class DetailScreen(val id: String) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = rememberScreenModel { DetailScreenModel() }
        screenModel.updateId(id = id)
        val state by screenModel.state.collectAsStateWithLifecycle()

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("${state.id} Screen ")
            Button(onClick = {
                navigator.pop()
            }) {
                Text("Click me")
            }
        }

    }
}