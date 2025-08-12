package br.senai.sp.jandira.clienteapp.screens.cliente.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import br.senai.sp.jandira.clienteapp.ui.theme.ClienteAppTheme

@Composable
fun BarraInferior(controleNavegacao: NavHostController?) { //barra inferior
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary, //mudar a cor
        contentColor = MaterialTheme.colorScheme.primary //mudar a cor
    ) { //composta por itens de barra de navigacao
        NavigationBarItem(
            selected = false,
            onClick = {
                controleNavegacao!!.navigate("conteudo")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = MaterialTheme.colorScheme.onPrimary //mudar a cor do icon
                )
            },
            label = { //texto para o icon
                Text(text = "Home",
                    color = MaterialTheme.colorScheme.onPrimary) //mudar a cor do texto
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            },
            label = { //texto para o icon
                Text(text = "Favorite",
                    color = MaterialTheme.colorScheme.onPrimary)
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {
                controleNavegacao!!.navigate("cadastro")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "novo",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            },
            label = { //texto para o icon
                Text(text = "novo cliente",
                    color = MaterialTheme.colorScheme.onPrimary)
            }
        )
    }
}

@Preview
@Composable
private fun BarraInferiorPreview(){
    ClienteAppTheme {
        BarraInferior(null)
    }
}