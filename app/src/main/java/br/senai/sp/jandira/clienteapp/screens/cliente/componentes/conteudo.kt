package br.senai.sp.jandira.clienteapp.screens.cliente.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.clienteapp.ui.theme.ClienteAppTheme

@Composable
fun  Conteudo(paddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) { Row (
        modifier = Modifier
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "pessoas"
        )
        Spacer(
            modifier = Modifier
                .width(4.dp)
        )
        Text(
            text = "Lista de Clientes"
        )
    }
        LazyColumn {
            items(10){
                Card(
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp,
                            bottom = 8.dp
                        )
                        .fillMaxSize()
                        .height(80.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "Nome do Cliente")
                            Text(text = "email@do.cliente")
                        }
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "delete"
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ConteudoPreview(){
    ClienteAppTheme {
        Conteudo(PaddingValues(16.dp) )
    }
}