package br.senai.sp.jandira.clienteapp.screens.cliente

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.clienteapp.screens.cliente.componentes.BarraDeTitulo
import br.senai.sp.jandira.clienteapp.screens.cliente.componentes.BarraInferior
import br.senai.sp.jandira.clienteapp.screens.cliente.componentes.BotaoFlutuante
import br.senai.sp.jandira.clienteapp.screens.cliente.componentes.Conteudo
import br.senai.sp.jandira.clienteapp.ui.theme.ClienteAppTheme

@Composable
fun ListaDeClientes(modifier: Modifier = Modifier){
    Scaffold (
        topBar = {
            BarraDeTitulo()
        },
        bottomBar = {
            BarraInferior()
        },
        floatingActionButton = {
            BotaoFlutuante()
        },
        content = {
            Conteudo(it)
        }
    )
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ListaDeClientesPreview(){
    ClienteAppTheme {
        ListaDeClientes()
    }
}