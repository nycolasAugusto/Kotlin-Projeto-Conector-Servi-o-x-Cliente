package com.example.trampai

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TelaTres(voltarParaInicio: () -> Unit) {
    Column {
        Text("Aqui é a Tela 3!")
        Button(onClick = voltarParaInicio) {
            Text("Voltar para Início")
        }
    }
}