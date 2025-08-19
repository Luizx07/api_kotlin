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
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.clienteapp.model.cliente
import br.senai.sp.jandira.clienteapp.service.ClienteService
import br.senai.sp.jandira.clienteapp.service.Conexao
import br.senai.sp.jandira.clienteapp.ui.theme.ClienteAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await

@Composable
fun  Conteudo(paddingValues: PaddingValues){

    val clienteApi = Conexao().getClienteService()

    var clientes by remember {
        mutableStateOf(listOf<cliente>())
    }

    var mostrarConfirmacaoExculsao by remember{ mutableStateOf(false) }

    LaunchedEffect(Dispatchers.IO) {
        clientes = clienteApi.listarTodos().await()
    }

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
        LazyColumn(
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            items(clientes){ cliente ->
                CardCliente(
                    cliente,
                    clienteApi
                )

            }
        }
    }
}

@Composable
private fun CardCliente(
    cliente: cliente,
    clienteApi: ClienteService,
) {

    var mostrarConfirmacaoExculsao by remember{ mutableStateOf(false) }

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
                Text(text = cliente.nome)
                Text(text = cliente.email)
            }
            IconButton(
                onClick = {
                    mostrarConfirmacaoExculsao = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "delete"
                )
            }
        }
        if (mostrarConfirmacaoExculsao) {
            AlertDialog(
                onDismissRequest = {
                    mostrarConfirmacaoExculsao = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            GlobalScope.launch(Dispatchers.IO) {
                                val clienteApagado = clienteApi.excluir(cliente)
                                println("************************$clienteApagado")
                            }
                            mostrarConfirmacaoExculsao = false
                        }
                    ) {
                        Text("Confirmar")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            mostrarConfirmacaoExculsao = false
                        }
                    ) {
                        Text("Cancelar")
                    }
                },
                title = {
                    Text(text = "Exclusão de Cliente")
                },
                text = {
                    Text("Confirmar exclusão do cliente abaixo?\n\n${cliente.nome}")
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "cuidado"
                    )
                }
            )
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