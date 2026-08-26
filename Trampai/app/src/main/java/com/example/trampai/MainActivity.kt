package com.example.trampai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.trampai.ui.theme.TrampaiTheme
import com.example.trampai.Tela1
import com.example.trampai.Tela2
import com.example.trampai.Tela3
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrampaiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var telaAtual by remember { mutableStateOf(1) }

                    // Troca o visual dependendo do número
                    when (telaAtual) {
                        1 -> TelaUm( irParaProxima = { telaAtual = 2 } )
                        2 -> TelaDois( irParaProxima = { telaAtual = 3 } )
                        3 -> TelaTres( voltarParaInicio = { telaAtual = 1 } )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrampaiTheme {
        Greeting("Android")
    }
}