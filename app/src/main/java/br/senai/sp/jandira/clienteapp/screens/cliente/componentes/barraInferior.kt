package br.senai.sp.jandira.clienteapp.screens.cliente.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.clienteapp.ui.theme.ClienteAppTheme

@Composable
fun BarraInferior(modifier: Modifier = Modifier) { //barra inferior
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary, //mudar a cor
        contentColor = MaterialTheme.colorScheme.primary //mudar a cor
    ) { //composta por itens de barra de navigacao
        NavigationBarItem(
            selected = false,
            onClick = {},
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
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            },
            label = { //texto para o icon
                Text(text = "Menu",
                    color = MaterialTheme.colorScheme.onPrimary)
            }
        )
    }
}

@Preview
@Composable
private fun BarraInferiorPreview(){
    ClienteAppTheme {
        BarraInferior()
    }
}