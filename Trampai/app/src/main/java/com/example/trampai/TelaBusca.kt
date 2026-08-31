package com.example.trampai

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Data class para representar cada categoria com seu respectivo ícone
data class Categoria(
    val nome: String,
    val icone: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaBuscaServicos() {
    var searchText by remember { mutableStateOf("") }

    // Cores da paleta
    val primaryColor = Color(0xFF4F46E5)
    val backgroundColor = Color(0xFFF9FAFB)
    val textColor = Color(0xFF111827)

    // Lista de categorias com ícones específicos
    val categorias = listOf(
        Categoria("Limpeza", Icons.Default.CleaningServices),
        Categoria("Encanamento", Icons.Default.Plumbing),
        Categoria("Elétrica", Icons.Default.ElectricalServices),
        Categoria("Pintura", Icons.Default.Brush),
        Categoria("Jardinagem", Icons.Default.Grass),
        Categoria("Mecânica", Icons.Default.Engineering)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Text(
            text = "Busca de Serviços",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            placeholder = { Text("O que você está procurando?") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.Gray
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = primaryColor,
                unfocusedBorderColor = Color(0xFFD1D5DB),
                focusedTextColor = textColor,
                unfocusedTextColor = textColor
            )
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(categorias) { categoria ->
                CardCategoria(categoria, primaryColor)
            }
        }
    }
}


@Composable
fun CardCategoria(categoria: Categoria, accentColor: Color) {
    Card(
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Container do ícone com cor de fundo suave
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(48.dp)
                        .background(accentColor.copy(alpha = 0.1f), shape = RoundedCornerShape(12.dp))
                ) {
                    Icon(
                        imageVector = categoria.icone,
                        contentDescription = categoria.nome,
                        tint = accentColor,
                        modifier = Modifier.size(28.dp)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = categoria.nome,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Color(0xFF374151)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaBusca() {
    TelaBuscaServicos()
}
