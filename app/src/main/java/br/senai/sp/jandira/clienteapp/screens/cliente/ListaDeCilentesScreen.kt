package br.senai.sp.jandira.clienteapp.screens.cliente

import android.content.res.Configuration
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.clienteapp.screens.cliente.componentes.BarraDeTitulo
import br.senai.sp.jandira.clienteapp.screens.cliente.componentes.BarraInferior
import br.senai.sp.jandira.clienteapp.screens.cliente.componentes.BotaoFlutuante
import br.senai.sp.jandira.clienteapp.screens.cliente.componentes.Conteudo
import br.senai.sp.jandira.clienteapp.ui.theme.ClienteAppTheme

@Composable
fun ListaDeClientes(modifier: Modifier = Modifier){

    var controleNavegacao = rememberNavController()
    Scaffold (
        topBar = {
            BarraDeTitulo()
        },
        bottomBar = {
            BarraInferior(controleNavegacao)
        },
        floatingActionButton = {
            BotaoFlutuante(controleNavegacao)
        },
        content = { padding ->
            NavHost(
                navController = controleNavegacao,
                startDestination = "conteudo"
            ){
                composable(route = "conteudo") { Conteudo(padding) }
                composable(route = "cadastro") { ClienteForm(padding) }
            }
        }
    )
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun ListaDeClientesPreview(){
    ClienteAppTheme {
        ListaDeClientes()
    }
}