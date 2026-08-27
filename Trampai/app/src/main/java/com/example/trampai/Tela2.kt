package com.example.trampai

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaDois() {

    // Estados dos campos
    var titulo by remember {
        mutableStateOf("")
    }

    var categoria by remember {
        mutableStateOf("")
    }

    var valor by remember {
        mutableStateOf("")
    }

    var descricao by remember {
        mutableStateOf("")
    }

    var requisitos by remember {
        mutableStateOf("")
    }

    var localizacao by remember {
        mutableStateOf("")
    }

    // Contexto utilizado pelo Toast
    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        // CABEÇALHO
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Criar Serviço",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Button(
                onClick = {
                    // Futuramente poderá voltar para a tela anterior
                }
            ) {
                Text("X")
            }
        }

        // TÍTULO
        Text(
            text = "Título do Serviço",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = titulo,
            onValueChange = {
                titulo = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Ex: Poda de Árvores e Paisagismo")
            },
            singleLine = true
        )

        // CATEGORIA
        Text(
            text = "Categoria",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = categoria,
            onValueChange = {
                categoria = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Ex: Limpeza e Manutenção Externa")
            },
            singleLine = true
        )

        // VALOR
        Text(
            text = "Valor / Orçamento",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = valor,
            onValueChange = {
                valor = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("R$ 50,00 / hora")
            },
            singleLine = true
        )

        // DESCRIÇÃO
        Text(
            text = "Descrição",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = descricao,
            onValueChange = {
                descricao = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Descreva o serviço e os detalhes")
            }
        )

        // REQUISITOS
        Text(
            text = "Requisitos Especiais",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = requisitos,
            onValueChange = {
                requisitos = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Ex: ferramentas necessárias")
            }
        )

        // LOCALIZAÇÃO
        Text(
            text = "Localização",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = localizacao,
            onValueChange = {
                localizacao = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Apenas cidade do serviço")
            },
            singleLine = true
        )

        // ANEXOS
        Text(
            text = "Anexos",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Espaço para adicionar anexos"
                )
            }
        }

        // BOTÃO PUBLICAR
        Button(
            onClick = {

                Toast.makeText(
                    contexto,
                    "Serviço publicado!",
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        ) {

            Text(
                text = "Publicar Serviço",
                fontWeight = FontWeight.Bold
            )
        }
    }
}