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
    val icone: ImageVector,
    val cor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaBuscaServicos() {
    var searchText by remember { mutableStateOf("") }

    // Cores da paleta
    val primaryColor = Color(0xFF4F46E5)
    val backgroundColor = Color(0xFFF7F8FA)
    val textColor = Color(0xFF1F2937)

    // Lista de categorias com ícones e cores vibrantes específicas
    val categorias = listOf(
        Categoria("Limpeza", Icons.Default.CleaningServices, Color(0xFF0EA5E9)),
        Categoria("Encanamento", Icons.Default.Plumbing, Color(0xFF3B82F6)),
        Categoria("Elétrica", Icons.Default.ElectricalServices, Color(0xFFEAB308)),
        Categoria("Pintura", Icons.Default.Brush, Color(0xFFEC4899)),
        Categoria("Jardinagem", Icons.Default.Grass, Color(0xFF10B981)),
        Categoria("Mecânica", Icons.Default.Engineering, Color(0xFFF59E0B))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Text(
            text = "Busca de Serviços",
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            color = textColor,
            modifier = Modifier.padding(bottom = 20.dp, top = 8.dp)
        )

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            placeholder = { Text("O que você está procurando?", color = Color.Gray) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = primaryColor
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = primaryColor,
                unfocusedBorderColor = Color(0xFFE5E7EB),
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
                CardCategoria(categoria)
            }
        }
    }
}


@Composable
fun CardCategoria(categoria: Categoria) {
    Card(
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFF3F4F6))
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Container do ícone com cor de fundo suave baseada na cor da categoria
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .background(categoria.cor.copy(alpha = 0.12f), shape = RoundedCornerShape(18.dp))
                ) {
                    Icon(
                        imageVector = categoria.icone,
                        contentDescription = categoria.nome,
                        tint = categoria.cor,
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = categoria.nome,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
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
