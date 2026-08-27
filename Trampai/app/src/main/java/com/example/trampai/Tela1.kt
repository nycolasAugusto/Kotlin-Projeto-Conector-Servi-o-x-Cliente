package com.example.trampai

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaUm(
        irParaProxima: () -> Unit
) {

    Column(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
    ) {

        // MENU SUPERIOR
        Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
        ) {

            // Nome do aplicativo
            Text(
                    text = "Taskly",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
            )

            // Botões do lado direito
            Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                        onClick = {
                            // ação da notificação futuramente
                        }
                ) {
                    Text("🔔")
                }

                Button(
                        onClick = {
                            // ação do perfil futuramente
                        }
                ) {
                    Text("👤")
                }
            }
        }

        // Área reservada para o restante da Tela 1
        Box(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                contentAlignment = Alignment.TopStart
        ) {
            // Conteúdo será colocado aqui depois
        }
    }
}