package com.example.trampai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.trampai.ui.theme.TrampaiTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            TrampaiTheme {

                Scaffold(
                        modifier = androidx.compose.ui.Modifier.fillMaxSize()
                ) {

                    var telaAtual by remember {
                        mutableStateOf(1)
                    }

                    when (telaAtual) {

                        1 -> TelaUm(
                                irParaProxima = {
                                    telaAtual = 2
                                }
                        )

                        2 -> TelaDois()

                        3 -> TelaTres(
                                voltarParaInicio = {
                                    telaAtual = 1
                                }
                        )
                    }
                }
            }
        }
    }
}